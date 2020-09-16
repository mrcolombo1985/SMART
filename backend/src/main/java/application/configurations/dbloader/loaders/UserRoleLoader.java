package application.configurations.dbloader.loaders;

import application.configurations.dbloader.LoaderDependencies;
import application.entities.UserEntity;
import application.entities.security.RoleEntity;
import application.entities.security.UserRoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Loads users
 */
@Slf4j
@Transactional
public class UserRoleLoader implements ILoader {

    @Autowired
    LoaderDependencies data;

    Random rr = new Random();

    private BufferedReader br;

    public UserRoleLoader(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void load() {
        this.data.userRoleRepository.deleteAll();
        this.data.userRoleRepository.flush();
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList = this.data.userRepository.findAll();
        Integer userEntityMax = userEntityList.size();
        List<RoleEntity> roleEntityList = new ArrayList<>();
        roleEntityList = this.data.roleRepository.findAll();
        Integer roleEntityMax = roleEntityList.size() - 1;
        for (int i = 0; i < userEntityMax; i++) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setAppUser(userEntityList.get(i));
            userRoleEntity.setRoleEntity(roleEntityList.get(rr.nextInt(roleEntityMax)));
            this.data.userRoleRepository.save(userRoleEntity);
        }


    }
}