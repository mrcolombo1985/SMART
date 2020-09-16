package application.models.data.option;

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
    public List<OptionEntity> findAll(Predicate predicate) {
        List<OptionEntity> optionS = new ArrayList<>();
        optionRepository.findAll(predicate).forEach(x -> optionS.add(x));
        return optionS;
    }

    @Override
    public List<OptionEntity> findAll() {
        return optionRepository.findAll();
    }

    @Override
    public OptionEntity findOne(Predicate predicate) {
        return optionRepository.findOne(predicate).get();
    }



}
