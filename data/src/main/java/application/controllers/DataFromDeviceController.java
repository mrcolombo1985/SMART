package application.controllers;

import application.dtoes.data.ValueDTO;
import application.entities.data.*;
import application.models.data.arduino.IArduinoDeviceModel;
import application.models.data.sensor.ISensorModel;
import application.models.data.value.IValueModel;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/")
public class DataFromDeviceController {
    @Autowired
    ISensorModel sensorModel;

    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;


    @Autowired
    IValueModel valueModel;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                     @RequestBody String data) {
        String[] dataArr = data.split("!");
        Stream<String> stream = Arrays.stream(dataArr);
        stream.forEach(str -> {
            String[] rezData = str.split("=");
            SensorEntity sensorEntity = sensorModel.getOne(QSensorEntity.sensorEntity.macAddress.eq(rezData[0])).orElse(null);
            if (sensorEntity != null) {
                ValueEntity valueEntity = new ValueEntity();
                valueEntity.setDateUpdate(LocalDate.now());
                valueEntity.setTimeUpdate(LocalTime.now());
                valueEntity.setValue(Double.valueOf(rezData[1]));
                System.out.println(DateTime.now() + " : Value = " + valueEntity + " Sensor = " + sensorEntity);
                valueEntity.setSensor(sensorEntity);
                valueModel.save(valueEntity);
            } else {
                /*System.out.println(DateTime.now() + " Sensor with MAC = " + rezData[0] + " is not found");
                SensorEntity newSensor = SensorEntity.builder()
                        .macAddress(rezData[0])
                        .description("auto added")
                        .arduino(arduinoDeviceModel.getOne(QArduinoDeviceEntity.arduinoDeviceEntity.ip.eq(request.getRemoteAddr())).orElse(null))
                        .pin(32)
                        .nameSensor("auto " + rezData[0])
                        .build();
                sensorModel.save(newSensor);*/
            }
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<ValueDTO> get(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                              @QuerydslPredicate(root = ValueEntity.class) Predicate predicate) {
        //TODO вывод значений для датчика по его идентификатору
        return valueModel.toDTO(valueModel.findAll(predicate));
        //sensorModel.getByMAC(mac).getValues();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    //TODO проверка коррктности дат до их использования
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @QuerydslPredicate(root = ValueEntity.class) Predicate predicate) {

                valueModel.deleteAll(predicate);


    }

}
