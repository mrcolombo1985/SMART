package application.models.data.value;

import application.entities.data.ValueEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface IValueModel {
    List<ValueEntity> findAll(Predicate predicate);
    void deleteAll(Predicate predicate);
    Optional<ValueEntity> findOne(Predicate predicate);
    void save(ValueEntity valueEntity);
}
