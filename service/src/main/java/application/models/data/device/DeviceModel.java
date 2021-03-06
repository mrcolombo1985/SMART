package application.models.data.device;

import application.entities.data.*;
import application.repositories.data.ArduinoDeviceRepository;
import application.repositories.data.DeviceRepository;
import application.repositories.data.OptionRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeviceModel implements IDeviceModel {
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    ArduinoDeviceRepository arduinoDeviceRepository;

    @Override
    public List<DeviceEntity> getAll(Predicate predicate) {
        List<DeviceEntity> deviceDTOS = new ArrayList<>();
        deviceRepository.findAll(predicate).forEach(x -> deviceDTOS.add(x));
        return deviceDTOS;
    }

    @Override
    public Optional<DeviceEntity> findOne(Predicate predicate) {
        return deviceRepository.findOne(predicate);
    }



    @Override
    public void save(DeviceEntity data) {
        if (deviceRepository.exists(QDeviceEntity.deviceEntity.nameDevice.eq(data.getNameDevice())))
            throw new EntityExistsException("EntityExistsException");
        deviceRepository.save(data);
    }

    @Override
    public void deleteAll(Predicate predicate) {
        deviceRepository.findAll(predicate).forEach(x -> {
            optionRepository.deleteAll(optionRepository.findAll(QOptionEntity.optionEntity.device.nameDevice.eq(x.getNameDevice())));
        });
        deviceRepository.deleteAll(deviceRepository.findAll(predicate));
    }


    @Override
    public void deleteAll() {
        deviceRepository.deleteAll();
    }

    @Override
    public List<DeviceEntity> findAll() {
        return deviceRepository.findAll();
    }


}