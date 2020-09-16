package application.controllers;

import application.entities.LogDTO;
import application.entities.LogEntity;
import application.models.ILogModel;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/")
public class LogController {

    @Autowired
    ILogModel logModel;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public List<LogEntity> findAllByWebQuerydsl(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                                                @QuerydslPredicate(root = LogEntity.class) Predicate predicate) {
        return logModel.findAll(predicate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                     @RequestBody LogDTO data) {
        logModel.add(new LogEntity(data));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"/"})
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @QuerydslPredicate(root = LogEntity.class) Predicate predicate) {
        logModel.deleteAll(predicate);
    }
}
