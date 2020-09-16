package application;

import application.dtoes.data.ArduinoDeviceDTO;
import application.dtoes.data.DeviceDTO;
import application.dtoes.data.SensorDTO;
import application.entities.data.QSensorEntity;
import application.entities.data.ValueEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.device.IDeviceModel;
import application.models.data.option.IOptionModel;
import application.models.data.sensor.ISensorModel;
import application.models.data.value.IValueModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValueModelTest {
    @Autowired
    IOptionModel optionModel;

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    @Autowired
    IDeviceModel deviceModel;

    @Autowired
    ISensorModel sensorModel;

    @Autowired
    IValueModel valueModel;

    String arduinoNameTest = "optionModelTestArduino";
    String deviceNameTest = "optionModelTestArduinoDevice";
    String sensorNameTest = "optionModelTestArduinoSensor";

    @Before
    public void before() {
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
        for (int i = 0; i < 32; i++) {
            SensorDTO sensorDTO = SensorDTO.builder()
                    .name(sensorNameTest + i)
                    .address("ff:ff:ff:ff:ff:ff:ff:ff")
                    .arduino(arduinoNameTest)
                    .description("testtest" + i)
                    .pin("123")
                    .build();
            sensorModel.save(sensorDTO);
            for (int j = 0; j < 128; j++) {
                ValueEntity valueEntity = ValueEntity.builder()
                        .dateUpdate(LocalDate.now())
                        .sensor(sensorModel.getOne(QSensorEntity.sensorEntity.nameSensor.eq(sensorNameTest + i)).get())
                        .timeUpdate(LocalTime.now())
                        .value(Double.valueOf(i * j))
                        .build();
                valueModel.save(valueEntity);
            }
        }
    }

    @Test
    public void deleteData() {

    }

    @After
    public void after() {
        valueModel.deleteAll();
    }
}
