package application.configurations.scheduler;

import application.entities.data.OptionEntity;
import application.entities.data.QOptionEntity;
import application.entities.data.QValueEntity;
import application.entities.data.ValueEntity;
import application.models.data.device.IDeviceModel;
import application.models.data.option.IOptionModel;
import application.models.data.value.IValueModel;
import application.repositories.data.DeviceRepository;
import application.repositories.data.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CheckingData {
    private Integer delta = 10;
    private String sendIP = "";
    private Integer sendPIN = -1;
    private  Integer sendCOM = 0;
    public static final RestTemplate restTemplate = new RestTemplate();


    @Autowired
    IOptionModel optionModel;

    @Autowired
    IDeviceModel deviceModel;

    @Autowired
    IValueModel valueModel;

    InetAddress inetAddress;


    private void scheduleFixedDelayTaskMethod(Integer num){
        if (deviceModel.findAll().size()>num)
        {
            List<OptionEntity> optionEntityList = optionModel.findAll(QOptionEntity.optionEntity.device.id.eq(num));
            //System.out.println("scheduleFixedDelayTask -> Number = " + num + " -> Size -> " + optionEntityList.size());
            optionEntityList.forEach(z -> {
                if (!z.getDevice().getArduino().getIp().isEmpty()) {
                    System.out.println("Error!!! Unknown host -> IP = " + z.getDevice().getArduino().getIp() + " Device num = " + num + " Data = " + z.toString());
                    return;
                }
                //System.out.println("scheduleFixedDelayTask - " + num + " -> data = " + z);
                //TODO написать прохождение по значениям
                List<ValueEntity> valueEntities = valueModel.findAll(QValueEntity.valueEntity.sensor.nameSensor.eq(z.getSensor().getNameSensor()));
                switch (z.getType()){
                    case  0:{
                            //TODO Sensor
                        switch (z.getIfType()){
                            case 0:{

                                if (valueEntities.get(valueEntities.size()-1).getValue() > z.getData())
                                {
                                    sendIP = z.getDevice().getArduino().getIp().toString();
                                    sendPIN = z.getDevice().getPin();
                                    sendCOM = z.getCommand();
                                }
                                break;
                            }
                            case 1:{
                                if ((valueEntities.get(valueEntities.size()-1).getValue() > z.getData() - delta) && (valueEntities.get(valueEntities.size()-1).getValue() < z.getData() + delta))
                                {
                                    sendIP = z.getDevice().getArduino().getIp().toString();
                                    sendPIN = z.getDevice().getPin();
                                    sendCOM = z.getCommand();
                                }
                                break;
                            }
                            case 2:{
                                if (valueEntities.get(valueEntities.size()-1).getValue() < z.getData())
                                {
                                    sendIP = z.getDevice().getArduino().getIp().toString();
                                    sendPIN = z.getDevice().getPin();
                                    sendCOM = z.getCommand();
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case  1:{
                            //TODO Time
                        LocalDateTime dateTime = LocalDateTime.of(z.getDateS().getYear(), z.getDateS().getMonth(), z.getDateS().getDayOfMonth(), z.getTimeS().getHour(), z.getTimeS().getMinute());
                        Date now = new Date();
                        Instant curr = now.toInstant();
                        LocalDateTime currentDT = LocalDateTime.ofInstant(curr, ZoneId.systemDefault());
                        if (currentDT.isAfter(dateTime))
                        {
                            sendIP = z.getDevice().getArduino().getIp().toString();
                            sendPIN = z.getDevice().getPin();
                            sendCOM = z.getCommand();
                        }
                        break;
                    }
                }
                //TODO sending
                String url = "http://" + sendIP;
                String urn = "/in?pin=" + sendPIN.toString() + "&value=" + sendCOM;
                RequestEntity<?> request = null;
                try {
                    request = new RequestEntity(null, HttpMethod.POST, new URI(url+urn));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                try {
                    ResponseEntity<String> responseS = restTemplate.exchange(request, String.class);
                } catch (RestClientException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask0() {
        Integer deviceNumber = 0;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask1() {
        Integer deviceNumber = 1;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask2() {
        Integer deviceNumber = 2;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask3() {
        Integer deviceNumber = 3;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask4() {
        Integer deviceNumber = 4;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask5() {
        Integer deviceNumber = 5;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask6() {
        Integer deviceNumber = 6;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask7() {
        Integer deviceNumber = 7;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask8() {
        Integer deviceNumber = 8;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask9() {
        Integer deviceNumber = 9;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask10() {
        Integer deviceNumber = 10;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask11() {
        Integer deviceNumber = 11;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask12() {
        Integer deviceNumber = 12;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask13() {
        Integer deviceNumber = 13;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask14() {
        Integer deviceNumber = 14;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask15() {
        Integer deviceNumber = 15;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask16() {
        Integer deviceNumber = 16;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask17() {
        Integer deviceNumber = 17;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask18() {
        Integer deviceNumber = 18;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask19() {
        Integer deviceNumber = 19;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask20() {
        Integer deviceNumber = 20;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask21() {
        Integer deviceNumber = 21;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask22() {
        Integer deviceNumber = 22;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask23() {
        Integer deviceNumber = 23;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask24() {
        Integer deviceNumber = 24;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask25() {
        Integer deviceNumber = 25;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask26() {
        Integer deviceNumber = 26;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask27() {
        Integer deviceNumber = 27;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask28() {
        Integer deviceNumber = 28;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask29() {
        Integer deviceNumber = 29;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask30() {
        Integer deviceNumber = 30;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask31() {
        Integer deviceNumber = 31;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask32() {
        Integer deviceNumber = 32;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask33() {
        Integer deviceNumber = 33;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask34() {
        Integer deviceNumber = 34;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask35() {
        Integer deviceNumber = 35;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask36() {
        Integer deviceNumber = 36;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask37() {
        Integer deviceNumber = 37;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask38() {
        Integer deviceNumber = 38;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask39() {
        Integer deviceNumber = 39;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask40() {
        Integer deviceNumber = 40;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask41() {
        Integer deviceNumber = 41;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask42() {
        Integer deviceNumber = 42;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask43() {
        Integer deviceNumber = 43;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask44() {
        Integer deviceNumber = 44;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask45() {
        Integer deviceNumber = 45;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask46() {
        Integer deviceNumber = 46;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask47() {
        Integer deviceNumber = 47;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask48() {
        Integer deviceNumber = 48;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask49() {
        Integer deviceNumber = 49;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }

    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask50() {
        Integer deviceNumber = 50;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask51() {
        Integer deviceNumber = 51;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask52() {
        Integer deviceNumber = 52;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask53() {
        Integer deviceNumber = 53;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask54() {
        Integer deviceNumber = 54;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask55() {
        Integer deviceNumber = 55;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask56() {
        Integer deviceNumber = 56;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask57() {
        Integer deviceNumber = 57;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask58() {
        Integer deviceNumber = 58;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask59() {
        Integer deviceNumber = 59;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask60() {
        Integer deviceNumber = 60;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask61() {
        Integer deviceNumber = 61;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask62() {
        Integer deviceNumber = 62;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }
    @Scheduled(cron = "${cron.timedata}")
    public void scheduleFixedDelayTask63() {
        Integer deviceNumber = 63;
        scheduleFixedDelayTaskMethod(deviceNumber);
    }

}
