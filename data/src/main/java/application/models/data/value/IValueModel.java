package application.models.data.value;

import application.dtoes.data.ValueDTO;
import application.entities.data.ValueEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface IValueModel {
    List<ValueEntity> findAll(Predicate predicate);

    List<ValueDTO> toDTO(List<ValueEntity> data);

    void deleteAll(Predicate predicate);

    void deleteAll();

    Optional<ValueEntity> findOne(Predicate predicate);

    void save(ValueEntity valueEntity);
}
