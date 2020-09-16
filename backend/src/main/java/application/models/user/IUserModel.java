package application.models.user;

import application.dtoes.security.UserDTO;
import application.entities.UserEntity;
import com.querydsl.core.types.Predicate;

import java.util.HashMap;
import java.util.List;

public interface IUserModel {
    UserEntity getByUsernameAndPassword(String username, String password);

    public List<UserEntity> getAll(Predicate predicate);

    public UserEntity getById(Integer userId);


    public UserEntity add(UserDTO data);

    void addRole(String username, String role);

    void removeRole(String username, String role);

    List<String> getRoles(String username);

    public UserEntity update(String username,
                             HashMap<String, String> data);

    public UserEntity deleteByID(Integer userId);

    public List<UserEntity> deleteAll();

    public UserEntity activateByID(Integer userId);

    public UserEntity deactivateByID(Integer userId);

    public UserEntity prepareForDeletionByID(Integer userId);


    void add(UserEntity alyssa);

    void delete(UserEntity alyssa);
}
