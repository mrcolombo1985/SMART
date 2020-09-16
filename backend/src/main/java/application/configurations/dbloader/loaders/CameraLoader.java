package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.video.CameraEntity;
import application.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class CameraLoader implements ILoader {

    private final BufferedReader br;
    @Autowired
    LoaderDependencies data;
    Random rr = new Random();

    public CameraLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        this.data.cameraRepository.deleteAll();
        this.data.cameraRepository.flush();
        for (int i = 0; i < 32; i++) {
            CameraEntity cameraEntity = new CameraEntity();
            cameraEntity.setName(RandomGenerator.genText(97, 122));
            cameraEntity.setTitle(RandomGenerator.genText(97, 122));
            cameraEntity.setUrl("http://" + RandomGenerator.genIP() + ":9191/gen");
            cameraEntity.setPath("d:\\video\\" + cameraEntity.getName());
            this.data.cameraRepository.save(cameraEntity);
        }
    }
}