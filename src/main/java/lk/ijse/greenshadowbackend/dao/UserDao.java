package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao  extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
