package application.controllers;

import application.dtoes.video.CameraDTO;
import application.models.video.camera.ICameraModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/camera")
public class CameraController {
    @Autowired
    ICameraModel cameraModel;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public Iterable<CameraDTO> findAllByWebQuerydsl(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                                                    @RequestParam(name = "name", required = false) String cameraName) {
        if (cameraName != null) {
            List<CameraDTO> cameraDTOS = new ArrayList<>();
            cameraDTOS.add(cameraModel.getByName(cameraName));
            return cameraDTOS;
        }
        return cameraModel.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                     @RequestBody CameraDTO data) {
        cameraModel.save(data);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void put(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                    @RequestParam(name = "name") String cameraName,
                    @RequestBody CameraDTO data) {
        cameraModel.edit(data, cameraName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @RequestParam(name = "name") String cameraName) {
        cameraModel.delete(cameraName);
    }
}
