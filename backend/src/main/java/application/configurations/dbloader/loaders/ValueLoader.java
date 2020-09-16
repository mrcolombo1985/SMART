package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.data.SensorEntity;
import application.entities.data.ValueEntity;
import application.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class ValueLoader implements ILoader {

    @Autowired
    LoaderDependencies data;

    Random rr = new Random();

    private BufferedReader br;
    Integer countT = 32;
    public ValueLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        try {


            //do we need flush here?
            // need
            // https://stackoverflow.com/questions/49595852/deleteall-in-repository-randomly-causes-constraintviolationexception
            //TODO создать файл для генерации постоянных данных
            ValueLoaderThread[] myThreads = new ValueLoaderThread[countT];
            for (int i = 0; i < countT; i++) {
                myThreads[i] = new ValueLoaderThread();
            }
            for (int i = 0; i < countT; i++) {
                myThreads[i].start();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}