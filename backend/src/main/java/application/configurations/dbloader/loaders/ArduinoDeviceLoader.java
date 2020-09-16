package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.data.ArduinoDeviceEntity;
import application.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class ArduinoDeviceLoader implements ILoader {

    @Autowired
    LoaderDependencies data;

    Random rr = new Random();

    private BufferedReader br;

    public ArduinoDeviceLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        try {
            //do we need flush here?
            // need
            // https://stackoverflow.com/questions/49595852/deleteall-in-repository-randomly-causes-constraintviolationexception
            //TODO создать файл для генерации постоянных данных
            for (int i = 0; i < 5; i++) {
                ArduinoDeviceEntity deviceEmbedded = new ArduinoDeviceEntity();
                deviceEmbedded.setIp(RandomGenerator.genIP());
                deviceEmbedded.setName(RandomGenerator.genText(97, 122));
                deviceEmbedded.setToken(UUID.randomUUID().toString());
                deviceEmbedded.setDescription(RandomGenerator.genText(97, 122));
                this.data.arduinoDeviceRepository.save(deviceEmbedded);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}