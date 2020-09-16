package application.controller;

import application.dtoes.data.ArduinoDeviceDTO;
import application.dtoes.data.SensorDTO;
import application.entities.data.QArduinoDeviceEntity;
import application.entities.data.QValueEntity;
import application.entities.data.SensorEntity;
import application.entities.data.ValueEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.sensor.ISensorModel;
import application.models.data.value.IValueModel;
import application.utils.RandomGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DataWebRequestTest {

    @Autowired
    ISensorModel sensorModel;
    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    @Autowired
    IValueModel valueModel;

    SensorDTO sensorDTO;
    String arduinoNameTest = "dataModelTestArduino";
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String token;
    private final HttpHeaders headers = new HttpHeaders();
    List<String> macList = new ArrayList<>();
    String testName = "testtesttest";
    String dataPoint = "/data";

    @Before
    public void buildEntities() {
        beforeOne();
        beforeTwo();
        headers.add("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    private void beforeOne() {
        ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                .name(arduinoNameTest)
                .description("optionModelTestArduino")
                .ip("192.168.15.11")
                .token("testtesttest")
                .build();
        arduinoDeviceModel.save(arduinoDeviceDTO);
        for (int i = 0; i < 32; i++) {
            macList.add(RandomGenerator.genMAC());
        }
        macList.forEach(mac -> {
            sensorDTO = new SensorDTO();
            sensorDTO.setName(testName + macList.indexOf(mac));
            sensorDTO.setAddress(mac);
            sensorDTO.setDescription(RandomGenerator.genText(97, 122));
            sensorDTO.setPin("55");
            sensorDTO.setArduino(arduinoNameTest);
            sensorModel.save(sensorDTO);
        });
    }

    private void beforeTwo() {
        for (int i=0;i<128;i++) {
            ArduinoDeviceDTO arduinoDeviceDTO = ArduinoDeviceDTO.builder()
                    .name(arduinoNameTest+i)
                    .description("optionModelTestArduino")
                    .ip("192.168.15.11")
                    .token("testtesttest")
                    .build();
            arduinoDeviceModel.save(arduinoDeviceDTO);
        }
        for (int i = 0; i < 128*128; i++) {
            macList.add(RandomGenerator.genMAC());
        }
        Random rr = new Random();
        macList.forEach(mac -> {
            sensorDTO = new SensorDTO();
            sensorDTO.setName(testName + macList.indexOf(mac)+LocalTime.now().toString());
            sensorDTO.setAddress(mac);
            sensorDTO.setDescription(RandomGenerator.genText(97, 122));
            sensorDTO.setPin("55");
            sensorDTO.setArduino(arduinoNameTest+rr.nextInt(128));
            sensorModel.save(sensorDTO);
        });
        sensorModel.findAll().forEach(x->{
            for (int i = 0; i < 1024; i++) {
                ValueEntity valueEntity = ValueEntity.builder()
                        .sensor(x)
                        .value(-50 + rr.nextDouble()*100)
                        .timeUpdate(LocalTime.now())
                        .dateUpdate(LocalDate.now())
                        .build();
                valueModel.save(valueEntity);
            }
        });
    }

    @Test
    public void sendDataToServer() throws Exception {
        Random rr = new Random();
        Integer rrMax = macList.size() - 1;
        for (int z = 0; z < 8; z++) {
            String rezTest = "";
            for (int i = 0; i < 8; i++) {
                rezTest = rezTest + macList.get(rr.nextInt(rrMax)) + "=" + String.valueOf(50 - rr.nextDouble() * 100);
                if (i < 7) rezTest = rezTest + "!";
            }
            this.restTemplate.exchange("http://localhost:" + port + dataPoint + "/", HttpMethod.POST,
                    new HttpEntity<String>(rezTest), String.class);
        }
    }

    @Test
    public void getDataFromServer() {
        Collection<ValueEntity> valueEntityList = new ArrayList<>();
        List<SensorEntity> sensorEntityListAfter = sensorModel.findAll();
        for (SensorEntity sensorItem : sensorEntityListAfter
        ) {
            System.out.println("Sensor with MAC = " + sensorItem.getMacAddress() + " BEGIN");
            ResponseEntity<Collection<ValueEntity>> result = this.restTemplate.exchange("http://localhost:" + port
                            + dataPoint + "/?sensor.macAddress=" + sensorItem.getMacAddress(), HttpMethod.GET,
                    new HttpEntity<String>(headers),
                    new ParameterizedTypeReference<Collection<ValueEntity>>() {
                    });
            if (result != null) {
                valueEntityList = result.getBody();
            }
            //valueEntityList = sensorModel.getByMAC(sensorItem.getMacAddress()).getValues();
            if (valueEntityList != null) {
                valueEntityList.forEach(valueDataItem -> {
                    System.out.println(valueDataItem.getDateUpdate() + " : " + valueDataItem.getTimeUpdate() + " -> "
                            + valueDataItem.getValue());
                });
            }
            System.out.println("Sensor with MAC = " + sensorItem.getMacAddress() + " END");
        }
    }

    @Test
    public void testGenerator(){
        sensorModel.findAll().forEach(x->{
            assertTrue(!valueModel.findAll(QValueEntity.valueEntity.sensor.nameSensor.eq(x.getNameSensor())).isEmpty());
        });
    }

    @Test
    public void deleteDataFromServerbyMAC() {
        this.restTemplate.exchange("http://localhost:" + port + dataPoint +
                        "/?mac=" + macList.get(1), HttpMethod.DELETE,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Collection<ValueEntity>>() {
                });
    }

    @Test
    public void deleteDataFromServerByDate() {
        this.restTemplate.exchange("http://localhost:" + port + dataPoint
                        + "/?dateUpdate=11.11.01&dateUpdate=11.11.41", HttpMethod.DELETE,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Collection<ValueEntity>>() {
                });
    }

    @Test
    public void deleteDataFromServerByDateAndMAC() {
        System.out.println("Yes");
        this.restTemplate.exchange("http://localhost:" + port + dataPoint
                        + "/?sensor.macAddress=" + macList.get(4)
                        + "&dateUpdate=11.11.11&dateUpdate=11.11.21",
                HttpMethod.DELETE,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Collection<ValueEntity>>() {
                });
    }

    @Test
    public void deleteDataFromServerAll() {
        this.restTemplate.exchange("http://localhost:" + port + dataPoint + "/", HttpMethod.DELETE,
                new HttpEntity<String>(headers),
                new ParameterizedTypeReference<Collection<ValueEntity>>() {
                });
    }


    @After
    public void tearDown() {
        arduinoDeviceModel.deleteAll();
    }


}