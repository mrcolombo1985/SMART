package application.controllers;

import application.dtoes.data.ArduinoDeviceDTO;
import application.entities.data.ArduinoDeviceEntity;
import application.entities.data.QArduinoDeviceEntity;
import application.models.data.arduino.IArduinoDeviceModel;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/arduino")
public class ArduinoController {
    @Autowired
    IArduinoDeviceModel arduinoDeviceModel;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public Iterable<ArduinoDeviceDTO> findAllByWebQuerydsl(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                                                           @QuerydslPredicate(root = ArduinoDeviceEntity.class) Predicate predicate) {
        System.out.println("predicate -> " + predicate);
        return arduinoDeviceModel.getAll(predicate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                     @RequestBody ArduinoDeviceDTO data) {
        arduinoDeviceModel.save(data);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void put(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                    @RequestBody ArduinoDeviceDTO data,
                    @RequestParam(name = "name") String name) throws UnknownHostException {
        arduinoDeviceModel.edit(data, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"/"})
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @QuerydslPredicate(root = ArduinoDeviceEntity.class) Predicate predicate) {

            arduinoDeviceModel.delete(predicate);

    }
}
