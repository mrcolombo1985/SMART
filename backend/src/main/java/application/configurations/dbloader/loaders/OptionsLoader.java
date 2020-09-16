package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.data.DeviceEntity;
import application.entities.data.OptionEntity;
import application.entities.data.SensorEntity;
import application.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class OptionsLoader implements ILoader {

    @Autowired
    LoaderDependencies data;

    private BufferedReader br;
    Integer countT = 8;
    private Integer selector = 2; // 1- from file 2-generation

    public OptionsLoader(BufferedReader br) {
        this.br = br;
    }

    //TODO создать файл для генерации постоянных данных
    @Override
    public void load() {
        try {
            Random rr = new Random();
            this.data.optionRepository.deleteAll();
            this.data.optionRepository.flush();
            List<SensorEntity> sensorEntityList = this.data.sensorRepository.findAll();
            Integer sensorMax = sensorEntityList.size() - 1;
            List<DeviceEntity> deviceEntityList = this.data.deviceRepository.findAll();
            Integer deviceMax = deviceEntityList.size() - 1;
            //do we need flush here?
            // need
            // https://stackoverflow.com/questions/49595852/deleteall-in-repository-randomly-causes-constraintviolationexception
            if (selector == 1) {
                String detail;
                while ((detail = br.readLine()) != null) {
                    String[] data = detail.split("!");
                    OptionEntity entity = new OptionEntity();
                    entity.setDevice(deviceEntityList.get(Integer.valueOf(data[6])));
                    entity.setSensor(sensorEntityList.get(Integer.valueOf(data[7])));
                    entity.setTimeS(LocalTime.parse(data[4]));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
                    entity.setDateS(LocalDate.parse(data[0], formatter));
                    entity.setIfType(Integer.valueOf(data[2]));
                    entity.setType(Integer.valueOf(data[5]));
                    entity.setNameOption(data[3]);
                    entity.setDescription(data[1]);
                    entity.setData(Integer.valueOf(33));
                    entity.setCommand(Integer.valueOf(33));
                    entity.setData(rr.nextInt(255));
                    this.data.optionRepository.save(entity);
                }
            }
            if (selector == 2) {Thread[] myThreads = new Thread[countT];
                for (int i = 0; i < countT; i++) {
                    myThreads[i] = new Thread(new Runnable()
                    {
                        public void run()
                        {
                            generatorOptions();
                        }
                    });
                }
                for (int i = 0; i < countT; i++) {
                    myThreads[i].start();
                }

            }
            log.debug("DBLoadTest -> OptionLoader -> In repository " + this.data.optionRepository.findAll().size() + " records");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void generatorOptions() {
        Random rr = new Random();
        List<SensorEntity> sensorEntityList = this.data.sensorRepository.findAll();
        Integer sensorMax = sensorEntityList.size() - 1;
        List<DeviceEntity> deviceEntityList = this.data.deviceRepository.findAll();
        Integer deviceMax = deviceEntityList.size() - 1;
        for (int i = 0; i < 128; i++) {
            //TODO генерация в потоках
            OptionEntity entity = new OptionEntity();
            entity.setDevice(deviceEntityList.get(rr.nextInt(deviceMax)));
            entity.setSensor(sensorEntityList.get(rr.nextInt(sensorMax)));
            entity.setTimeS(RandomGenerator.genTime());
            entity.setDateS(RandomGenerator.genDate());
            entity.setIfType(rr.nextInt(1024) % 3);
            entity.setType(rr.nextInt(1024) % 2);
            entity.setNameOption(RandomGenerator.genText(97, 122));
            entity.setDescription(RandomGenerator.genText(97, 122));
            entity.setData(rr.nextInt(255));
            this.data.optionRepository.save(entity);
        }
    }
}