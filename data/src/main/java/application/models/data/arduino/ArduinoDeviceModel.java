package application.models.data.arduino;

import application.dtoes.data.ArduinoDeviceDTO;
import application.entities.data.*;
import application.repositories.data.*;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArduinoDeviceModel implements IArduinoDeviceModel {

    @Autowired
    ArduinoDeviceRepository arduinoDeviceRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    ValueRepository valueRepository;

    @Override
    public List<ArduinoDeviceDTO> getAll(Predicate predicate) {
        List<ArduinoDeviceDTO> deviceDTOS = new ArrayList<>();
        arduinoDeviceRepository.findAll(predicate).forEach(x -> deviceDTOS.add(new ArduinoDeviceDTO(x)));
        return deviceDTOS;
    }

    @Override
    public Optional<ArduinoDeviceEntity> getOne(Predicate predicate) {
        return arduinoDeviceRepository.findOne(predicate);
    }

    @Override
    public void save(ArduinoDeviceDTO data) {
        if (data == null)
            throw new NullPointerException("Arduino device is NULL");
        if (arduinoDeviceRepository.exists(QArduinoDeviceEntity.arduinoDeviceEntity.name.eq(data.getName())))
            throw new EntityNotFoundException("EntityNotFoundException");
        arduinoDeviceRepository.save(new ArduinoDeviceEntity(data));
    }

    @Override
    public void save(ArduinoDeviceEntity data) {
        if (data == null) throw new NullPointerException("Arduino device is NULL");
        arduinoDeviceRepository.save(data);
    }


    @Override
    public void delete(Predicate predicate) {
        arduinoDeviceRepository.findAll(predicate).forEach(x -> {
            sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())).forEach(z -> {
                optionRepository.deleteInBatch(optionRepository.findAll(QOptionEntity.optionEntity.sensor.nameSensor.eq(z.getNameSensor())));
            });
        });
        arduinoDeviceRepository.findAll(predicate).forEach(x -> {
            sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())).forEach(z -> {
                valueRepository.deleteInBatch(valueRepository.findAll(QValueEntity.valueEntity.sensor.nameSensor.eq(z.getNameSensor())));
            });
        });
        arduinoDeviceRepository.findAll(predicate).forEach(x -> {
            sensorRepository.deleteInBatch(sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())));
        });
        arduinoDeviceRepository.findAll(predicate).forEach(x -> {
            deviceRepository.deleteInBatch(deviceRepository.findAll(QDeviceEntity.deviceEntity.arduino.name.eq(x.getName())));
        });
        arduinoDeviceRepository.deleteAll(arduinoDeviceRepository.findAll(predicate));
    }

    @Override
    public void deleteAll() {
        arduinoDeviceRepository.findAll().forEach(x -> {
            sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())).forEach(z -> {
                optionRepository.deleteInBatch(optionRepository.findAll(QOptionEntity.optionEntity.sensor.nameSensor.eq(z.getNameSensor())));
            });
        });
        arduinoDeviceRepository.findAll().forEach(x -> {
            sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())).forEach(z -> {
                valueRepository.deleteInBatch(valueRepository.findAll(QValueEntity.valueEntity.sensor.nameSensor.eq(z.getNameSensor())));
            });
        });
        arduinoDeviceRepository.findAll().forEach(x -> {
            sensorRepository.deleteInBatch(sensorRepository.findAll(QSensorEntity.sensorEntity.arduino.name.eq(x.getName())));
        });
        arduinoDeviceRepository.findAll().forEach(x -> {
            deviceRepository.deleteInBatch(deviceRepository.findAll(QDeviceEntity.deviceEntity.arduino.name.eq(x.getName())));
        });
        arduinoDeviceRepository.deleteAll();
    }

    private List<ArduinoDeviceEntity> toList(Iterable<ArduinoDeviceEntity> data) {
        List<ArduinoDeviceEntity> res = new ArrayList<>();
        data.forEach(item -> {
            res.add(item);
        });
        return res;
    }

    @Override
    public void edit(ArduinoDeviceDTO data, String name) {
        ArduinoDeviceEntity arduinoDeviceEntity = toList(arduinoDeviceRepository.findAll(QArduinoDeviceEntity.arduinoDeviceEntity.name.eq(name))).get(0);
        if (!data.getName().equals(""))
            arduinoDeviceEntity.setName(data.getName());
        if (!data.getDescription().equals(""))
            arduinoDeviceEntity.setDescription(data.getDescription());
        if (!data.getIp().equals(""))
            arduinoDeviceEntity.setIp(data.getIp());
        if (!data.getToken().equals(""))
            arduinoDeviceEntity.setToken(data.getToken());
        arduinoDeviceRepository.save(arduinoDeviceEntity);
    }

    public boolean exists(Predicate predicate) {
        return arduinoDeviceRepository.exists(predicate);
    }
}
