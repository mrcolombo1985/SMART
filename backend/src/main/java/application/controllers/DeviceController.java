package application.controllers;

import application.dtoes.data.DeviceDTO;
import application.entities.data.DeviceEntity;
import application.models.data.device.IDeviceModel;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    IDeviceModel deviceModel;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public Iterable<DeviceDTO> findAllByWebQuerydsl(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                                                    @QuerydslPredicate(root = DeviceEntity.class) Predicate predicate) {
        return deviceModel.getAll(predicate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                     @RequestBody DeviceDTO data) {
        deviceModel.save(data);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void put(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                    @RequestParam(name = "name") String name,
                    @RequestBody DeviceDTO deviceDTO) throws UnknownHostException {
        deviceModel.edit(deviceDTO, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"/"})
    @ResponseBody
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @QuerydslPredicate(root = DeviceEntity.class) Predicate predicate) {
        deviceModel.deleteAll(predicate);
    }
}
