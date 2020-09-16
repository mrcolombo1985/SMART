package application.models;

import application.entities.UserEntity;
import application.repositories.user.RoleRepository;
import application.repositories.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<String> getRoleNames() {
        List<String> stringList = new ArrayList<>();
        roleRepository.findAll().forEach(x -> {
            stringList.add(x.getRoleName());
        });
        return stringList;
    }

    public List<String> getRolesByUser(UserEntity userEntity) {
        List<String> stringList = new ArrayList<>();
        userRoleRepository.findByAppUser(userEntity).forEach(x -> {
            stringList.add(x.getRoleEntity().getRoleName());
        });
        return stringList;
    }
}
