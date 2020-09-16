package application.models.data.option;

import application.entities.data.OptionEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface IOptionModel {
    public List<OptionEntity> findAll(Predicate predicate);
    public List<OptionEntity> findAll();

    public OptionEntity findOne(Predicate predicate);




}
