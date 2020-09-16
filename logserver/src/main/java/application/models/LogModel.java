package application.models;

import application.entities.LogEntity;
import application.repositories.LogRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LogModel implements ILogModel {
    @Autowired
    LogRepository logRepository;

    @Override
    public List<LogEntity> findAll(Predicate predicate) {
        List<LogEntity> res = new ArrayList<>();
        logRepository.findAll(predicate).forEach(x -> {
            res.add(x);
        });
        return res;
    }

    @Override
    public void deleteAll(Predicate predicate) {
        logRepository.deleteInBatch(logRepository.findAll(predicate));
    }

    @Override
    public void add(LogEntity data) {
        logRepository.save(data);
    }

    @Override
    public Optional<LogEntity> findOne(Predicate predicate) {
        return logRepository.findOne(predicate);
    }
}
