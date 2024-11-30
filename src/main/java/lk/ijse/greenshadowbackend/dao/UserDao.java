package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao  extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
