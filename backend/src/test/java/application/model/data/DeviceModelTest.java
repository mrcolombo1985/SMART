package application.model.data;

import application.dtoes.data.ArduinoDeviceDTO;
import application.dtoes.data.DeviceDTO;
import application.entities.data.QArduinoDeviceEntity;
import application.entities.data.QDeviceEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.device.IDeviceModel;
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
public class DeviceModelTest {

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    @Autowired
    IDeviceModel deviceModel;

    String arduinoNameTest = "optionModelTestArduino";
    String deviceNameTest = "optionModelTest";
    String deviceNameTestN = "optionModelTestNNN";

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
    }

    @Test
    public void addDulicate() {
        DeviceDTO deviceDTO = DeviceDTO.builder()
                .arduino(arduinoNameTest)
                .description("testtest")
                .pin("11")
                .name(deviceNameTest)
                .build();
        try {
            deviceModel.save(deviceDTO);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void addNoDulicate() {
        DeviceDTO deviceDTO = DeviceDTO.builder()
                .arduino(arduinoNameTest)
                .description("testtest")
                .pin("11")
                .name(deviceNameTestN)
                .build();
        deviceModel.save(deviceDTO);
    }

    @Test
    public void edit() {
        DeviceDTO deviceDTO = DeviceDTO.builder()
                .description("testtest11111")
                .build();
        deviceModel.edit(deviceDTO, deviceNameTest);
    }

    @Test
    public void get() {
        assertTrue(!deviceModel.getAll(QDeviceEntity.deviceEntity.nameDevice.eq(deviceNameTest)).isEmpty());
    }

    @Test
    public void remove() {
        deviceModel.deleteAll(QDeviceEntity.deviceEntity.nameDevice.eq(deviceNameTest));
        assertTrue(deviceModel.getAll(QDeviceEntity.deviceEntity.nameDevice.eq(deviceNameTest)).isEmpty());
    }

    @After
    public void afterTest() {
        arduinoDeviceModel.delete(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest));
    }
}
