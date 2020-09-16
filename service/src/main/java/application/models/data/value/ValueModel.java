package application.models.data.value;

import application.entities.data.ValueEntity;
import application.repositories.data.ValueRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ValueModel implements IValueModel {
    @Autowired
    ValueRepository valueRepository;

    @Override
    public List<ValueEntity> findAll(Predicate predicate) {
        List<ValueEntity> res = new ArrayList<>();
        valueRepository.findAll(predicate).forEach(x->{
            res.add(x);
        });
        return res;
    }

    @Override
    public void deleteAll(Predicate predicate) {
        valueRepository.deleteInBatch(valueRepository.findAll(predicate));
    }

    @Override
    public Optional<ValueEntity> findOne(Predicate predicate) {
        return valueRepository.findOne(predicate);
    }

    @Override
    public void save(ValueEntity valueEntity) {
        valueRepository.save(valueEntity);
    }
}
