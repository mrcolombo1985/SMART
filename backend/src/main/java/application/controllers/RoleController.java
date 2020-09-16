package application.controllers;

import application.models.user.IUserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    IUserModel userModel;

    @GetMapping(value = "/")
    public List<String> getAll(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request, @RequestParam(name = "username", required = false) String username) {
        return userModel.getRoles(username);
    }

    @PostMapping(value = "/")
    public void post(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request) {

    }

    @DeleteMapping(value = "/")
    public void delete(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request) {

    }
}
