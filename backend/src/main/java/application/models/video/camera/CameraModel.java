package application.models.video.camera;

import application.dtoes.video.CameraDTO;
import application.entities.video.CameraEntity;
import application.repositories.video.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CameraModel implements ICameraModel {

    @Autowired
    CameraRepository cameraRepository;

    @Override
    public Iterable<CameraDTO> getAll() {
        List<CameraDTO> cameraDTOS = new ArrayList<>();
        cameraRepository.findAll().forEach(x -> cameraDTOS.add(new CameraDTO(x)));
        return cameraDTOS;
    }

    @Override
    public CameraDTO getByName(String name) {
        return new CameraDTO(cameraRepository.getByName(name));
    }

    @Override
    public void edit(CameraDTO data, String cameraName) {
        CameraEntity cameraEntity = cameraRepository.getByName(cameraName);
        if (!data.getName().equals(""))
            cameraEntity.setName(data.getName());
        if (!data.getPath().equals(""))
            cameraEntity.setPath(data.getPath());
        if (!data.getTitle().equals(""))
            cameraEntity.setTitle(data.getTitle());
        if (!data.getUrl().equals(""))
            cameraEntity.setUrl(data.getUrl());
        cameraRepository.save(cameraEntity);
    }

    @Override
    public void save(CameraDTO data) {
        cameraRepository.save(new CameraEntity((data)));
    }

    @Override
    public void delete(String cameraName) {
        if (cameraName != null) {
            if (!cameraRepository.existsByName(cameraName))
                throw new EntityNotFoundException("Camera with name " + cameraName + " not exists");
            cameraRepository.deleteByName(cameraName);
        } else cameraRepository.deleteAll();
    }
}
