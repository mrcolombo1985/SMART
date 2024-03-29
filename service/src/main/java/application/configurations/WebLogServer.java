package application.aspects;

import application.dtoes.security.UserDTO;
import application.entities.LogDTO;
import application.entities.UserEntity;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class WebLogServer {
    private int port=8040;
    private RestTemplate restTemplate = new RestTemplate();
    public void add(LogDTO logDTO){
        this.restTemplate.exchange("http://localhost:" + port + "/", HttpMethod.POST,
                new HttpEntity<LogDTO>(logDTO),
                new ParameterizedTypeReference<LogDTO>() {
                }).getBody();
    }
}
