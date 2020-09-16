package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.data.ArduinoDeviceEntity;
import application.entities.data.DeviceEntity;
import application.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class DeviceLoader implements ILoader {

    @Autowired
    LoaderDependencies data;
    Random rr = new Random();
    private Integer selector = 2; // 1- from file 2-generation
    private BufferedReader br;

    public DeviceLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        try {
            this.data.deviceRepository.deleteAll();
            this.data.deviceRepository.flush();
            //do we need flush here?
            // need
            // https://stackoverflow.com/questions/49595852/deleteall-in-repository-randomly-causes-constraintviolationexception
//TODO создать файл для генерации постоянных данных
            if (selector == 1) {
                String detail;
                while ((detail = br.readLine()) != null) {
                    String[] data = detail.split("!");
                    DeviceEntity entity = new DeviceEntity();
                    entity.setDescription(data[2]);
                    entity.setNameDevice(data[0]);
                    entity.setPin(Integer.valueOf(data[3]));

                    ArduinoDeviceEntity deviceEmbedded = this.data.arduinoDeviceRepository.getOne(1 + rr.nextInt(this.data.arduinoDeviceRepository.findAll().size() - 2));

                    entity.setArduino(deviceEmbedded);
                    this.data.deviceRepository.save(entity);
                }
            }
            if (selector == 2) {
                String detail;
                for (int i = 0; i < 16; i++) {
                    DeviceEntity entity = new DeviceEntity();
                    entity.setDescription(RandomGenerator.genText(97, 122));
                    entity.setNameDevice(RandomGenerator.genText(97, 122));
                    entity.setPin(rr.nextInt(43));

                    ArduinoDeviceEntity deviceEmbedded = this.data.arduinoDeviceRepository.getOne(1 + rr.nextInt(this.data.arduinoDeviceRepository.findAll().size() - 2));

                    entity.setArduino(deviceEmbedded);
                    this.data.deviceRepository.save(entity);
                }
            }
            log.debug("DBLoadTest -> DeviceLoader -> In repository " + this.data.deviceRepository.findAll().size() + " records");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}