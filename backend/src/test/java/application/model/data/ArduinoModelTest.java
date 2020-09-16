package application.model.data;

import application.dtoes.data.ArduinoDeviceDTO;
import application.entities.data.QArduinoDeviceEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.utils.RandomGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArduinoModelTest {

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    String arduinoNameTest = "optionModelTestArduino";
    String arduinoNameTestNoDuplicate = "optionModelTestArduinoZ";

    @Before
    public void beforeTest() {
        List<String> arduinoNameList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            arduinoNameList.add(arduinoNameTest + i);
        }
        arduinoNameList.forEach(x -> {
            ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                    .name(x)
                    .description("optionModelTestArduino")
                    .ip(RandomGenerator.genIP())
                    .token("testtesttest")
                    .build();
            try {
                arduinoDeviceModel.save(arduinoDeviceDTO);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTest)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        try {
            arduinoDeviceModel.save(arduinoDeviceDTO);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void addDuplicate() {
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTest)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        try {
            arduinoDeviceModel.save(arduinoDeviceDTO);
            assertFalse(true);
        } catch (Exception e) {
            assertFalse(false);
        }
    }

    @Test
    public void addNoDuplicate() {
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTestNoDuplicate)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        arduinoDeviceModel.save(arduinoDeviceDTO);
        assertTrue(true);
    }

    @Test
    public void edit() {

    }

    @Test
    public void get() {
        arduinoDeviceModel.getAll(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest)).forEach(x -> {
            System.out.println(x);
        });
        assertTrue(!arduinoDeviceModel.getAll(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest)).isEmpty());
    }

    @Test
    public void remove() {
        arduinoDeviceModel.delete(QArduinoDeviceEntity.arduinoDeviceEntity.name.contains(arduinoNameTest));
    }

    @After
    public void afterTest() {
        arduinoDeviceModel.deleteAll();
    }


}
