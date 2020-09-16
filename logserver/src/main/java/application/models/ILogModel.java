package application.models;

import application.entities.LogEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

public interface ILogModel {
    List<LogEntity> findAll(Predicate predicate);
    void deleteAll(Predicate predicate);
    void add(LogEntity data);
    Optional<LogEntity> findOne(Predicate predicate);
}
