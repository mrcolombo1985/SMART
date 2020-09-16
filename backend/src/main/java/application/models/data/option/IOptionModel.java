package application.models.data.option;

import application.dtoes.data.OptionDTO;
import application.entities.data.OptionEntity;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface IOptionModel {
    public List<OptionDTO> findAll(Predicate predicate);

    public OptionEntity findOne(Predicate predicate);

    public void save(OptionDTO data);

    public void delete(Predicate predicate);

    public void deleteAll();

    public void edit(String name, OptionDTO optionDTO);

    public void save(OptionEntity entity);
}
