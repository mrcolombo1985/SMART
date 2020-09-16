package application.repositories.user;

import application.entities.UserEntity;
import application.entities.security.RoleEntity;
import application.entities.security.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    public List<UserRoleEntity> findByAppUser(UserEntity userEntity);

    public void deleteByAppUserAndRoleEntity(UserEntity userEntity, RoleEntity roleEntity);

    public boolean existsByAppUserAndRoleEntity(UserEntity userEntity, RoleEntity roleEntity);
}
