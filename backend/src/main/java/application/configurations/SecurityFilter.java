package application.configurations;

import application.entities.QUserEntity;
import application.entities.UserEntity;
import application.entities.security.UserRoleEntity;
import application.entities.security.UserSession;
import application.models.user.IUserModel;
import application.repositories.user.UserRoleRepository;
import application.repositories.user.UserSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    public UserSessionRepository userSessionRepository;

    @Autowired
    public IUserModel userModel;

    @Autowired
    public UserRoleRepository userRoleRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Security Filter");
        log.info("Security Filter -> Remote address -> " + request.getRemoteAddr());
        log.info("Security Filter -> Remote port -> " + request.getRemotePort());
        log.info("Security Filter -> HTTP - method -> " + request.getMethod());
        String token = request.getHeader("Authorization");
        if (token != null) {
            //if ((token != null) || (token.equals("f796c5b8-861b-4da7-81e1-f065d0a47d97"))) {
            log.info("Security Filter -> token -> {}", token);
            UserSession userSession = userSessionRepository.findByTokenAndIsValidTrue(token);
            UserEntity userEntity = userModel.getAll(QUserEntity.userEntity.userName.eq(userSession.getUserName())).get(0);
            List<UserRoleEntity> userRoleEntities = new ArrayList<>();
            userRoleEntities = userRoleRepository.findByAppUser(userEntity);
            //TODO проверка прав!!!
            if (userSession != null) {
                log.info("Security Filter -> token is valid");

                String usernameForController = userSession.getUserName();

                if (usernameForController == null) {
                    usernameForController = "no nameOption";
                }
                Authentication key = new UsernamePasswordAuthenticationToken(
                        usernameForController,
                        null,
                        new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(key);
            }
        }

        log.info("Security Filter -> exit");
        filterChain.doFilter(request, response);
    }
}
