package application.model.data;

import application.dtoes.data.ArduinoDeviceDTO;
import application.dtoes.data.SensorDTO;
import application.entities.data.QArduinoDeviceEntity;
import application.entities.data.QSensorEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.sensor.ISensorModel;
import application.utils.RandomGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorModelTest {

    @Autowired
    ISensorModel sensorModel;

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    SensorDTO sensorDTO;
    String arduinoNameTest = "optionModelTestArduino";
    String testName = "testtesttest";
    String testDescriptionForEdit = "testEditDewscription";


    @Before
    public void beforeTest() {
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTest)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        arduinoDeviceModel.save(arduinoDeviceDTO);
        sensorDTO = new SensorDTO();
        sensorDTO.setName(testName);
        sensorDTO.setAddress(RandomGenerator.genMAC());
        sensorDTO.setDescription("test");
        sensorDTO.setPin("55");
        sensorDTO.setArduino(arduinoNameTest);
        sensorModel.save(sensorDTO);
    }

    @Test
    public void addDuplicate() {
        sensorDTO = new SensorDTO();
        sensorDTO.setName(testName);
        sensorDTO.setAddress("128.0.0.5");
        sensorDTO.setDescription("test");
        sensorDTO.setPin("55");
        sensorDTO.setArduino(arduinoNameTest);
        try {
            sensorModel.save(sensorDTO);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void edit() {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setDescription(testDescriptionForEdit);
        sensorModel.edit(testName, sensorDTO);
        assertTrue(sensorModel.getOne(QSensorEntity.sensorEntity.nameSensor.eq(testName)).get().getDescription().equals(testDescriptionForEdit));
    }

    @Test
    public void get() {
        assertTrue(new SensorDTO(sensorModel.getOne(QSensorEntity.sensorEntity.nameSensor.eq(testName)).get()).equals(sensorDTO));
    }

    @Test
    public void remove() {
        sensorModel.deleteAll(QSensorEntity.sensorEntity.nameSensor.eq(testName));
        assertTrue(sensorModel.findAll(QSensorEntity.sensorEntity.nameSensor.eq(testName)).isEmpty());
    }

    @After
    public void afterTest() {
        arduinoDeviceModel.delete(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest));
    }
}
