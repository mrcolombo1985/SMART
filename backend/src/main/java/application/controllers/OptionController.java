package application.controllers;

import application.dtoes.data.OptionDTO;
import application.entities.data.OptionEntity;
import application.models.data.option.IOptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/option")
public class OptionController {
    @Autowired
    IOptionModel optionModel;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public Iterable<OptionDTO> findAll(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                                                    @QuerydslPredicate(root = OptionEntity.class) com.querydsl.core.types.Predicate predicate) {
        return optionModel.findAll(predicate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request, @RequestBody OptionDTO data) {
        optionModel.save(data);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                       @QuerydslPredicate(root = OptionEntity.class) com.querydsl.core.types.Predicate predicate) {
        optionModel.delete(predicate);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void put(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request,
                    @RequestParam(name = "name") String name,
                    @RequestBody OptionDTO optionDTO

    ) {

        optionModel.edit(name, optionDTO);
    }
}
