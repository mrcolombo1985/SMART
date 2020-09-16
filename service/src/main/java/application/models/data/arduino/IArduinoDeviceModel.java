package application.models.data.arduino;

import application.entities.data.ArduinoDeviceEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface IArduinoDeviceModel {
    List<ArduinoDeviceEntity> getAll(Predicate predicate);

    void save(ArduinoDeviceEntity data);

    void delete(Predicate predicate);

    void deleteAll();

    boolean exists(Predicate predicate);
}
