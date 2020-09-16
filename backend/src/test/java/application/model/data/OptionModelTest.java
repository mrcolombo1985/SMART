package application.model.data;

import application.dtoes.data.ArduinoDeviceDTO;
import application.dtoes.data.DeviceDTO;
import application.dtoes.data.OptionDTO;
import application.dtoes.data.SensorDTO;
import application.entities.data.QArduinoDeviceEntity;
import application.entities.data.QOptionEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.device.IDeviceModel;
import application.models.data.option.IOptionModel;
import application.models.data.sensor.ISensorModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptionModelTest {

    @Autowired
    IOptionModel optionModel;

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    @Autowired
    IDeviceModel deviceModel;

    @Autowired
    ISensorModel sensorModel;

    String arduinoNameTest = "optionModelTestArduino";
    String deviceNameTest = "optionModelTestArduinoDevice";
    String sensorNameTest = "optionModelTestArduinoSensor";
    String optionNameTest = "optionModelTestName";

    @Before
    public void beforeTest() {
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTest)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        arduinoDeviceModel.save(arduinoDeviceDTO);
        DeviceDTO deviceDTO = DeviceDTO.builder()
                .arduino(arduinoNameTest)
                .description("testtest")
                .pin("11")
                .name(deviceNameTest)
                .build();
        deviceModel.save(deviceDTO);
        SensorDTO sensorDTO = SensorDTO.builder()
                .name(sensorNameTest)
                .address("ff:ff:ff:ff:ff:ff:ff:ff")
                .arduino(arduinoNameTest)
                .description("testtest")
                .pin("123")
                .build();
        sensorModel.save(sensorDTO);
        OptionDTO optionDTO = OptionDTO.builder()
                .name(optionNameTest)
                .deviceName(deviceNameTest)
                .sensorName(sensorNameTest)
                .description("testtest")
                .ifType("1")
                .type("1")
                .data("1212")
                .date("2020-10-10")
                .time("01:01:01")
                .build();
        optionModel.save(optionDTO);
    }

    @Test
    public void addDuplicate() {
        OptionDTO optionDTO = OptionDTO.builder()
                .name(optionNameTest)
                .deviceName(deviceNameTest)
                .sensorName(sensorNameTest)
                .description("testtest")
                .ifType("1")
                .type("1")
                .data("1212")
                .date("2020-10-10")
                .time("01:01:01")
                .build();
        try {
            optionModel.save(optionDTO);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void edit() {
        OptionDTO optionDTOold = new OptionDTO(optionModel.findOne(QOptionEntity.optionEntity.nameOption.eq(optionNameTest)));
        OptionDTO dtoPut = OptionDTO.builder()
                .description("!!!!!!!!!!!!!!")
                .build();
        optionModel.edit(optionNameTest, dtoPut);
        OptionDTO optionDTOnew = new OptionDTO(optionModel.findOne(QOptionEntity.optionEntity.nameOption.eq(optionNameTest)));
        assertFalse(optionDTOold.equals(optionDTOnew));
    }

    @Test
    public void get() {


        List<OptionDTO> optionDTOs = optionModel.findAll(QOptionEntity.optionEntity.nameOption.eq(optionNameTest));
        System.out.println(optionDTOs);
    }

    @Test
    public void remove() {
        optionModel.delete(QOptionEntity.optionEntity.nameOption.eq(optionNameTest));
        assertTrue(optionModel.findAll(QOptionEntity.optionEntity.nameOption.eq(optionNameTest)).isEmpty());
    }

    @After
    public void afterTest() {
        arduinoDeviceModel.delete(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest));
        //optionModel.delete(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest));
    }
}
