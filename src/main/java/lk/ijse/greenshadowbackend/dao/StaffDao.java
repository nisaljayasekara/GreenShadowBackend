package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<StaffEntity,String> {
}
