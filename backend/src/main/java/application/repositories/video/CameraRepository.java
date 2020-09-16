package application.repositories.video;

import application.entities.video.CameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<CameraEntity, Integer> {
    public CameraEntity getByName(String name);

    public Boolean existsByName(String name);

    public void deleteByName(String name);
}
