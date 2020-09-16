package application.utils;

import application.dtoes.data.OptionDTO;
import application.entities.data.*;
import application.models.data.device.IDeviceModel;
import application.models.data.sensor.ISensorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
public class OptionConverter {
    @Autowired
    IDeviceModel deviceModel;

    @Autowired
    ISensorModel sensorModel;

    public OptionEntity converter(OptionDTO data) {
        System.out.println(data);
        OptionEntity res = new OptionEntity();
        res.setNameOption(data.getName());
        res.setType(Integer.valueOf(data.getType()));
        res.setIfType(Integer.valueOf(data.getIfType()));
        res.setDateS(LocalDate.parse(data.getDate()));
        res.setTimeS(LocalTime.parse(data.getTime()));
        SensorEntity sensorEntity = new SensorEntity(sensorModel.findAll(QSensorEntity.sensorEntity.nameSensor.eq(data.getSensorName())).get(0));
        // System.out.println(sensorEntity);
        // res.setSensor(sensorEntity);
        DeviceEntity deviceEntity = new DeviceEntity(deviceModel.getAll(QDeviceEntity.deviceEntity.nameDevice.eq(data.getDeviceName())).get(0));
        System.out.println(deviceEntity);
        res.setDevice(deviceEntity);
        res.setDescription(data.getDescription());
        return res;
    }
}
