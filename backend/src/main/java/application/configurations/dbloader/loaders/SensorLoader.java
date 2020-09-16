package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.documentstypes.PdfDocumentFormat;
import application.entities.data.ArduinoDeviceEntity;
import application.entities.data.SensorEntity;
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
public class SensorLoader implements ILoader {

    @Autowired
    LoaderDependencies data;
    private Integer selector = 2;
    private BufferedReader br;

    public SensorLoader(BufferedReader br) {
        this.br = br;
    }

    //TODO создать файл для генерации постоянных данных
    @Override
    public void load() {
        try {
            this.data.sensorRepository.deleteAll();
            this.data.sensorRepository.flush();

            Random random = new Random();
            //do we need flush here?
            // need
            // https://stackoverflow.com/questions/49595852/deleteall-in-repository-randomly-causes-constraintviolationexception
            if (selector == 1) {
                String detail;
                while ((detail = br.readLine()) != null) {
                    String[] data = detail.split("!");
                    SensorEntity entity = new SensorEntity();
                    entity.setNameSensor(data[0]);
                    ArduinoDeviceEntity deviceEmbedded = this.data.arduinoDeviceRepository.getOne(1 + random.nextInt(this.data.arduinoDeviceRepository.findAll().size() - 2));
                    entity.setArduino(deviceEmbedded);
                    entity.setMacAddress(data[2]);
                    entity.setDescription(data[3]);
                    entity.setPin(Integer.valueOf(data[4]));
                    this.data.sensorRepository.save(entity);
                    //this.data.sensorRepository.flush();
                }
            }
            if (selector == 2) {
                generatorSensors();
            }
            if (selector == 3) {
                String detail;
                while ((detail = br.readLine()) != null) {
                    String[] data = detail.split("!");
                    SensorEntity entity = new SensorEntity();
                    entity.setNameSensor(data[0]);
                    ArduinoDeviceEntity deviceEmbedded = this.data.arduinoDeviceRepository.getOne(1 + random.nextInt(this.data.arduinoDeviceRepository.findAll().size() - 2));
                    entity.setArduino(deviceEmbedded);
                    entity.setMacAddress(data[2]);
                    entity.setDescription(data[3]);
                    entity.setPin(Integer.valueOf(data[4]));
                    this.data.sensorRepository.save(entity);
                    //this.data.sensorRepository.flush();
                }
                generatorSensors();
            }
            PdfDocumentFormat.createSensorsReport(this.data.sensorRepository.findAll());
            log.debug("DBLoadTest -> SensorLoader -> In repository " + this.data.sensorRepository.findAll().size() + " records");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void generatorSensors() {
        Random zzz = new Random();
        this.data.arduinoDeviceRepository.findAll().forEach(x->{
            int z=zzz.nextInt(256) + 32;
            for (int i = 0; i < z; i++) {
                SensorEntity entity = new SensorEntity();
                entity.setNameSensor(RandomGenerator.genText(97, 122));
                entity.setArduino(x);
                entity.setMacAddress(RandomGenerator.genMAC());
                entity.setDescription(RandomGenerator.genText(97, 122));
                entity.setPin(zzz.nextInt(64));
                this.data.sensorRepository.save(entity);
                this.data.sensorRepository.flush();
            }
        });
    }
}