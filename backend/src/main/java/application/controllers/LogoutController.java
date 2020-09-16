package application.controllers;

import application.dtoes.security.LogoutResponse;
import application.entities.security.UserSession;
import application.models.user.IUserModel;
import application.repositories.user.UserSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/logout")
public class LogoutController {

    @Autowired
    IUserModel userModel;

    @Autowired
    UserSessionRepository userSessionRepository;

    @PostMapping(value = "/")
    public LogoutResponse logout(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request) {
        if (httpHeaders.getFirst(HttpHeaders.AUTHORIZATION) == null) throw new RuntimeException("Token is NULL");
        UserSession userSession = userSessionRepository.findByTokenAndIsValidTrue(httpHeaders.getFirst(HttpHeaders.AUTHORIZATION));
        if (userSession == null) throw new RuntimeException("Token is incorrect");
        userSession.setIsValid(false);
        userSession.setLocalDateEnd(LocalDate.now());
        userSession.setLocalTimeEnd(LocalTime.now());
        userSessionRepository.save(userSession);
        return new LogoutResponse("OK");
    }

}
