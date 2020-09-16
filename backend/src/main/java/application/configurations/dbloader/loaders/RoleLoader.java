package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.security.RoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class RoleLoader implements ILoader {

    @Autowired
    LoaderDependencies data;

    Random rr = new Random();

    private BufferedReader br;

    public RoleLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        this.data.roleRepository.deleteAll();
        this.data.roleRepository.flush();
        String detail;
        try {
            while ((detail = br.readLine()) != null) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRoleName(detail);
                this.data.roleRepository.save(roleEntity);
            }
            log.debug("DBLoadTest -> RoleLoader -> In repository " + this.data.userRepository.findAll().size() + " records");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}