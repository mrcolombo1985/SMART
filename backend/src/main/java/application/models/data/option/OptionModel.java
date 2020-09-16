package application.models.data.option;

import application.dtoes.data.OptionDTO;
import application.entities.data.OptionEntity;
import application.entities.data.QDeviceEntity;
import application.entities.data.QOptionEntity;
import application.entities.data.QSensorEntity;
import application.repositories.data.DeviceRepository;
import application.repositories.data.OptionRepository;
import application.repositories.data.SensorRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OptionModel implements IOptionModel {
    @Autowired
    OptionRepository optionRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Override
    public List<OptionDTO> findAll(Predicate predicate) {
        List<OptionDTO> optionDTOS = new ArrayList<>();
        optionRepository.findAll(predicate).forEach(x -> optionDTOS.add(new OptionDTO(x)));
        return optionDTOS;
    }

    @Override
    public OptionEntity findOne(Predicate predicate) {
        return optionRepository.findOne(predicate).get();
    }

    @Override
    public void save(OptionDTO data) {
        if (optionRepository.exists(QOptionEntity.optionEntity.nameOption.eq(data.getName())))
            throw new EntityExistsException("EntityExistsException");
        optionRepository.save(converter(data));
    }


    public OptionEntity converter(OptionDTO data) {
        System.out.println(data);
        OptionEntity res = new OptionEntity();
        res.setNameOption(data.getName());
        res.setType(Integer.valueOf(data.getType()));
        res.setIfType(Integer.valueOf(data.getIfType()));
        res.setDateS(java.time.LocalDate.parse(data.getDate()));
        res.setTimeS(java.time.LocalTime.parse(data.getTime()));
            res.setSensor(sensorRepository.findOne(QSensorEntity.sensorEntity.nameSensor.eq(data.getSensorName())).get());
        if (res.getSensor() == null) throw new EntityNotFoundException("Sensor with this name is not found");
            res.setDevice(deviceRepository.findOne(QDeviceEntity.deviceEntity.nameDevice.eq(data.getDeviceName())).get());
        if (res.getDevice() == null) throw new EntityNotFoundException("Device with this name is not found");
        res.setDescription(data.getDescription());
        res.setData(Integer.valueOf(data.getData()));
        return res;
    }

    @Override
    public void delete(Predicate predicate) {
        optionRepository.deleteInBatch(optionRepository.findAll(predicate));
    }

    @Override
    public void deleteAll() {
        optionRepository.deleteAll();
    }

    @Override
    public void edit(String name, OptionDTO optionDTO) {
        if (!optionRepository.exists(QOptionEntity.optionEntity.nameOption.eq(name)))
            throw new EntityNotFoundException("Option with name = " + name + " is not found");
        OptionEntity optionEntity = optionRepository.findOne(QOptionEntity.optionEntity.nameOption.eq(name)).get();
        System.out.println("option->put-> " + optionDTO);
        if ((optionDTO.getData() != null) && (!optionDTO.getData().equals("")))
            optionEntity.setData(Integer.valueOf(optionDTO.getData()));
        if ((optionDTO.getDescription() != null) && (!optionDTO.getDescription().equals("")))
            optionEntity.setDescription(optionDTO.getDescription());
        if ((optionDTO.getDeviceName() != null) && (!optionDTO.getDeviceName().equals("")))
                optionEntity.setDevice(deviceRepository.findOne(QDeviceEntity.deviceEntity.nameDevice.eq(optionDTO.getDeviceName())).get());
        if ((optionDTO.getType() != null) && (!optionDTO.getType().equals("")))
            optionEntity.setType(Integer.valueOf(optionDTO.getType()));
        if ((optionDTO.getDate() != null) && (!optionDTO.getDate().equals("")))
            optionEntity.setDateS(java.time.LocalDate.parse(optionDTO.getDate()));
        if ((optionDTO.getTime() != null) && (!optionDTO.getTime().equals("")))
            optionEntity.setTimeS(LocalTime.parse(optionDTO.getTime()));
        if ((optionDTO.getIfType() != null) && (!optionDTO.getIfType().equals("")))
            optionEntity.setIfType(Integer.valueOf(optionDTO.getIfType()));
        if ((optionDTO.getSensorName() != null) && (!optionDTO.getSensorName().equals("")))
                optionEntity.setSensor(sensorRepository.findOne(QSensorEntity.sensorEntity.nameSensor.eq(optionDTO.getSensorName())).get());
        if ((optionDTO.getName() != null) && (!optionDTO.getName().equals(""))) {
            if (optionRepository.exists(QOptionEntity.optionEntity.nameOption.eq(optionDTO.getName())))
                throw new EntityExistsException("");
            optionEntity.setNameOption(optionDTO.getName());
        }
        optionRepository.save(optionEntity);
    }

    @Override
    public void save(OptionEntity entity) {
        optionRepository.save(entity);
    }
}
