package application.models.user;

import application.dtoes.security.UserDTO;
import application.entities.QUserEntity;
import application.entities.UserEntity;
import application.entities.security.RoleEntity;
import application.entities.security.UserRoleEntity;
import application.repositories.user.RoleRepository;
import application.repositories.user.UserRepository;
import application.repositories.user.UserRoleRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserModel implements IUserModel {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserEntity getByUsernameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndAndEncrytedPassword(username, password);
    }

    private UserEntity toOne(Iterable<UserEntity> data) {
        List<UserEntity> res = new ArrayList<>();
        data.forEach(item -> {
            res.add(item);
        });
        return res.get(0);
    }

    @Override
    public List<UserEntity> getAll(Predicate predicate) {
        List<UserEntity> res = new ArrayList<>();
        userRepository.findAll(predicate).forEach(item -> {
            res.add(item);
        });
        return res;
    }


    @Override
    public UserEntity getById(Integer userId) {
        return userRepository.getOne(userId);
    }


    @Override
    public UserEntity add(UserDTO data) {
        return userRepository.save(new UserEntity((data)));
    }

    @Override
    public void addRole(String username, String role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity = roleRepository.getByRoleName(role);
        if (userRoleRepository.existsByAppUserAndRoleEntity(toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username))), roleEntity))
            throw new EntityExistsException("");
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRoleEntity(roleEntity);
        userRoleEntity.setAppUser(toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username))));
        userRoleRepository.save(userRoleEntity);
    }

    @Override
    public void removeRole(String username, String role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity = roleRepository.getByRoleName(role);
        if (!userRoleRepository.existsByAppUserAndRoleEntity(toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username))), roleEntity))
            throw new EntityNotFoundException("");
        userRoleRepository.deleteByAppUserAndRoleEntity(toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username))), roleEntity);
    }

    @Override
    public List<String> getRoles(String username) {
        List<String> rolesList = new ArrayList<>();
        userRoleRepository.findByAppUser(toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username)))).forEach(x -> {
            rolesList.add(x.getRoleEntity().getRoleName());
        });
        return rolesList;
    }


    @Override
    public UserEntity update(String username,
                             HashMap<String, String> data) {
        UserEntity user = toOne(userRepository.findAll(QUserEntity.userEntity.userName.eq(username)));
        //TODO едактирование данных пользователя
        // if (userRepository.existsByUserNameAndEMail(user.getUserName(), user.getEMail())) throw new EntityExistsException(""); 
        // we're trying to update existing user. throwing an exception if it exists will stop our job. 
        userRepository.save(user);
        return user;
    }

    /**
     * Deletes the user skipping checks
     */
    @Override
    public UserEntity deleteByID(Integer userId) {
        UserEntity usr = userRepository.getOne(userId);
        usr.putIntoDeletionQueue();
        userRepository.deleteById(userId);
        return usr;
    }

    /**
     * Deletes all users skipping checks
     */
    @Override
    public List<UserEntity> deleteAll() {
        List<UserEntity> all = userRepository.findAll();
        for (UserEntity user : all) {
            user.putIntoDeletionQueue();
        }
        userRepository.deleteAll();
        return all;
    }

    /**
     * Activates the user, activating all his "deactivated" events and subscriptions;
     */
    @Override
    public UserEntity activateByID(Integer userId) {
        UserEntity usr = userRepository.getOne(userId);
        usr.activate();
        return usr;
    }

    /**
     * Deactivates the user, all his events and subscriptions;
     */
    @Override
    public UserEntity deactivateByID(Integer userId) {
        UserEntity usr = userRepository.getOne(userId);
        usr.deactivate();
        return usr;
    }

    /**
     * Puts the user into deletion queue;
     */
    @Override
    public UserEntity prepareForDeletionByID(Integer userId) {
        UserEntity usr = userRepository.getOne(userId);
        usr.putIntoDeletionQueue();
        return null;
    }

    @Override
    public void add(UserEntity alyssa) {
        userRepository.save(alyssa);
    }

    @Override
    public void delete(UserEntity alyssa) {
        userRepository.delete(alyssa);
    }
}
