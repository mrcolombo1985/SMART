package application.controller;


import application.dtoes.security.LoginDTO;
import application.dtoes.security.LoginResponse;
import application.entities.UserEntity;
import application.repositories.user.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SensorWebRequestTest {

    private final UserEntity ALYSSA = new UserEntity();
    private final HttpHeaders headers = new HttpHeaders();
    @Autowired
    UserRepository userRepo;
    private String token;
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void buildEntities() { //TODO: save token manually instead of doing login;
        ALYSSA.setUserName("cshoobridge7");
        ALYSSA.setEMail("cshoobridge7@jalbum.net");
        ALYSSA.setEncrytedPassword(DigestUtils.md5Hex(ALYSSA.getUserName()));

        userRepo.save(ALYSSA);
        userRepo.flush();

        restTemplate.setRequestFactory(new HttpComponentsAsyncClientHttpRequestFactory());

        token = this.restTemplate.exchange("http://localhost:" + port + "/login/", HttpMethod.POST,
                new HttpEntity<LoginDTO>(new LoginDTO("cshoobridge7", "cshoobridge7")),
                new ParameterizedTypeReference<LoginResponse>() {
                }).getBody().getToken();
        headers.add("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void get() throws Exception {

    }


    @Test
    public void add() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void edit() throws Exception {

    }

    @After
    public void tearDown() {
        ALYSSA.putIntoDeletionQueue();
        userRepo.delete(ALYSSA);
    }

}