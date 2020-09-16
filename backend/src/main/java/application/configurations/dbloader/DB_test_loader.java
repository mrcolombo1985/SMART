package application.configurations.dbloader;

import application.configurations.dbloader.loaders.ILoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Load the production DB with integration test data; TODO: make it a Spring
 * profile
 */
@Component
@Transactional
public class DB_test_loader implements CommandLineRunner {

    @Autowired
    @Qualifier("userLoader")
    private ILoader userLoader;

    @Autowired
    @Qualifier("deviceLoader")
    private ILoader deviceLoader;

    @Autowired
    @Qualifier("cameraLoader")
    private ILoader cameraLoader;

    @Autowired
    @Qualifier("sensorLoader")
    private ILoader sensorLoader;

    @Autowired
    @Qualifier("roleLoader")
    private ILoader roleLoader;

    @Autowired
    @Qualifier("userRoleLoader")
    private ILoader userRoleLoader;

    @Autowired
    @Qualifier("optionLoader")
    private ILoader optionLoader;

    @Autowired
    @Qualifier("valueLoader")
    private ILoader valueLoader;

    @Autowired
    @Qualifier("arduinoDeviceLoader")
    private ILoader arduinoDeviceLoader;

    @Override
    public void run(String... args) throws Exception {

        loadTest(MPHEntity.USER);
        loadTest(MPHEntity.ARDUINO);
        loadTest(MPHEntity.SENSOR);
        loadTest(MPHEntity.DEVICE);
        loadTest(MPHEntity.OPTIONS);
        loadTest(MPHEntity.VALUE);
        loadTest(MPHEntity.LOGS);
        loadTest(MPHEntity.ROLE);
        loadTest(MPHEntity.USERROLE);
        loadTest(MPHEntity.CAMERA);


    }

    public void loadTest(MPHEntity entity) {

        switch (entity) {
            case USER: {
                userLoader.load();
                break;
            }
            case DEVICE: {
                deviceLoader.load();
                break;
            }
            case SENSOR: {
                sensorLoader.load();
                break;
            }

            case OPTIONS: {
                optionLoader.load();
                break;
            }
            case ARDUINO: {
                arduinoDeviceLoader.load();
                break;
            }
            case VALUE: {
                valueLoader.load();
                break;
            }
            case ROLE: {
                roleLoader.load();
                break;
            }
            case USERROLE: {
                userRoleLoader.load();
                break;
            }
            case CAMERA: {
                cameraLoader.load();
                break;
            }

        }

    }

}
