package application.models.data.device;

import application.dtoes.data.DeviceDTO;
import application.entities.data.DeviceEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface IDeviceModel {
    public List<DeviceDTO> getAll(Predicate predicate);

    public Optional<DeviceEntity> findOne(Predicate predicate);

    public void save(DeviceDTO data);

    public void save(DeviceEntity data);

    public void deleteAll(Predicate predicate);

    public void deleteAll();

    List<DeviceEntity> findAll();

    void edit(DeviceDTO entity, String name);
}
