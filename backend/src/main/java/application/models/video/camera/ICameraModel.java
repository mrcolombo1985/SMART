package application.models.video.camera;

import application.dtoes.video.CameraDTO;

public interface ICameraModel {
    Iterable<CameraDTO> getAll();

    CameraDTO getByName(String name);

    public void edit(CameraDTO data, String cameraName);

    public void save(CameraDTO data);

    public void delete(String cameraName);
}
