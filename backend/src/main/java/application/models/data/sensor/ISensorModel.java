package application.models.data.sensor;

import application.dtoes.data.SensorDTO;
import application.entities.data.SensorEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface ISensorModel {
    public List<SensorDTO> findAll(Predicate predicate);

    public List<SensorEntity> findAll();

    public Optional<SensorEntity> getOne(Predicate predicate);

    public void save(SensorDTO data);

    public void save(SensorEntity data);

    public void deleteAll();

    public void deleteAll(Predicate predicate);

    void edit(String name, SensorDTO sensorDTO);
}
