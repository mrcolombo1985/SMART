package application.models.data.arduino;

import application.dtoes.data.ArduinoDeviceDTO;
import application.entities.data.ArduinoDeviceEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface IArduinoDeviceModel {
    List<ArduinoDeviceDTO> getAll(Predicate predicate);

    Optional<ArduinoDeviceEntity> getOne(Predicate predicate);

    void save(ArduinoDeviceDTO data);

    void save(ArduinoDeviceEntity data);


    void delete(Predicate predicate);

    void deleteAll();

    public void edit(ArduinoDeviceDTO data, String name);

    boolean exists(Predicate predicate);
}
