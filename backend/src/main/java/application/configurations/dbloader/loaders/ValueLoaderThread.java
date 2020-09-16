package application.configurations.dbloader.loaders;

import application.entities.data.SensorEntity;
import application.entities.data.ValueEntity;
import application.repositories.data.ValueRepository;
import application.repositories.data.SensorRepository;
import application.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class ValueLoaderThread extends Thread {
    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    ValueRepository valueRepository;
    private void generateValues() {
        Random rr = new Random();
        List<SensorEntity> sensorEntityList = sensorRepository.findAll();
        Integer sensorMax = sensorEntityList.size() - 1;
        int zz =  sensorMax;
        for (int i = 0; i < zz; i++) {
            ValueEntity entity = new ValueEntity();
            entity.setValue(50 - rr.nextDouble() * 100);
            entity.setTimeUpdate(RandomGenerator.genTime());
            entity.setDateUpdate(RandomGenerator.genDate());
            SensorEntity sensorEntity = sensorEntityList.get(rr.nextInt(sensorMax));
            entity.setSensor(sensorEntity);
            valueRepository.save(entity);
        }
    }
    @Override
    public void run()
    {
        generateValues();
    }
}
