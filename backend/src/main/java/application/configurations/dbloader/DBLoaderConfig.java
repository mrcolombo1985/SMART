package application.configurations.dbloader;


import application.configurations.dbloader.loaders.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Configuration
public class DBLoaderConfig {

    @Value("${database-test-folder}") //TODO: test context from Eclipse doesn't load this;
            String testFolder = "short-datafiles";
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream inputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;

    private void createBufferedReader(MPHEntity entity) {
        inputStream = classloader.getResourceAsStream(testFolder + "/" + entity.dataFile());
        if (inputStream != null) {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
        }
        if (bufferedReader == null) throw new IllegalArgumentException();
    }


    @Bean(name = "userLoader")
    public ILoader userLoader() {
        createBufferedReader(MPHEntity.USER);
        return new UserLoader(bufferedReader);
    }


    @Bean(name = "roleLoader")
    public ILoader roleLoader() {
        createBufferedReader(MPHEntity.ROLE);
        return new RoleLoader(bufferedReader);
    }

    @Bean(name = "cameraLoader")
    public ILoader cameraLoader() {
        createBufferedReader(MPHEntity.CAMERA);
        return new CameraLoader(bufferedReader);
    }

    @Bean(name = "userRoleLoader")
    public ILoader userRoleLoader() {
        createBufferedReader(MPHEntity.USERROLE);
        return new UserRoleLoader(bufferedReader);
    }

    @Bean(name = "deviceLoader")
    public ILoader deviceLoader() {
        createBufferedReader(MPHEntity.DEVICE);
        return new DeviceLoader(bufferedReader);
    }

    @Bean(name = "sensorLoader")
    public ILoader sensorLoader() {
        createBufferedReader(MPHEntity.SENSOR);
        return new SensorLoader(bufferedReader);
    }

    @Bean(name = "optionLoader")
    public ILoader optionLoader() {
        createBufferedReader(MPHEntity.OPTIONS);
        return new OptionsLoader(bufferedReader);
    }

    @Bean(name = "valueLoader")
    public ILoader valueLoader() {
        createBufferedReader(MPHEntity.VALUE);
        return new ValueLoader(bufferedReader);
    }

    @Bean(name = "arduinoDeviceLoader")
    public ILoader arduinoDeviceLoader() {
        createBufferedReader(MPHEntity.ARDUINO);
        return new ArduinoDeviceLoader(bufferedReader);
    }
}