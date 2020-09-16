package application.models.data.sensor;

import application.dtoes.data.SensorDTO;
import application.entities.data.*;
import application.repositories.data.ArduinoDeviceRepository;
import application.repositories.data.OptionRepository;
import application.repositories.data.SensorRepository;
import application.repositories.data.ValueRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SensorModel implements ISensorModel {
    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    ArduinoDeviceRepository arduinoDeviceRepository;

    @Autowired
    ValueRepository valueRepository;

    @Override
    public List<SensorDTO> findAll(Predicate predicate) {
        List<SensorDTO> sensorDTOS = new ArrayList<>();
        sensorRepository.findAll(predicate).forEach(x -> sensorDTOS.add(new SensorDTO(x)));
        return sensorDTOS;
    }

    @Override
    public List<SensorEntity> findAll() {
        return sensorRepository.findAll();
    }


    @Override
    public Optional<SensorEntity> getOne(Predicate predicate) {
        List<SensorEntity> entities = new ArrayList<>();
        return sensorRepository.findOne(predicate);
    }


    @Override
    public void save(SensorDTO data) {
        if (sensorRepository.exists(QSensorEntity.sensorEntity.nameSensor.eq(data.getName())))
            throw new EntityExistsException("EntityExistsException");
        SensorEntity sensorEntity = new SensorEntity(data);
        sensorEntity.setArduino(arduinoDeviceRepository.findOne(QArduinoDeviceEntity.arduinoDeviceEntity.name.eq(data.getArduino())).get());
        sensorRepository.save(sensorEntity);
    }

    @Override
    public void save(SensorEntity data) {
        if (sensorRepository.exists(QSensorEntity.sensorEntity.nameSensor.eq(data.getNameSensor())))
            throw new EntityExistsException("EntityExistsException");
        sensorRepository.save(data);
    }

    @Override
    public void deleteAll(Predicate predicate) {
        sensorRepository.findAll(predicate).forEach(item -> {
            optionRepository.deleteAll(optionRepository.findAll(QOptionEntity.optionEntity.sensor.nameSensor.eq(item.getNameSensor())));
            valueRepository.deleteInBatch(valueRepository.findAll(QValueEntity.valueEntity.sensor.nameSensor.eq(item.getNameSensor())));
        });
        sensorRepository.deleteAll(sensorRepository.findAll(predicate));
    }

    public void deleteAll() {
        sensorRepository.deleteAll();
    }

    @Override
    public void edit(String name, SensorDTO sensorDTO) {
        if (!sensorRepository.exists(QSensorEntity.sensorEntity.nameSensor.eq(name)))
            throw new EntityExistsException("");
        SensorEntity sensorEntity = sensorRepository.findOne(QSensorEntity.sensorEntity.nameSensor.eq(name)).get();
        if (!sensorDTO.getArduino().equals("")) {
            if (!arduinoDeviceRepository.exists(QSensorEntity.sensorEntity.nameSensor.eq(sensorDTO.getArduino())))
                throw new EntityExistsException("");
            sensorEntity.setArduino(arduinoDeviceRepository.findOne(QArduinoDeviceEntity.arduinoDeviceEntity.name.eq(sensorDTO.getArduino())).get());
        }
        if (!sensorDTO.getName().equals("")) {
            if (sensorRepository.exists(QSensorEntity.sensorEntity.nameSensor.eq(sensorDTO.getName())))
                throw new EntityExistsException("");
            sensorEntity.setNameSensor(sensorDTO.getName());
        }
        if (!sensorDTO.getDescription().equals("")) sensorEntity.setDescription(sensorDTO.getDescription());
        if (!sensorDTO.getAddress().equals("")) sensorEntity.setMacAddress(sensorDTO.getAddress());
        if (!sensorDTO.getPin().equals("")) sensorEntity.setPin(Integer.valueOf(sensorDTO.getPin()));
        sensorRepository.save(sensorEntity);
    }

}
