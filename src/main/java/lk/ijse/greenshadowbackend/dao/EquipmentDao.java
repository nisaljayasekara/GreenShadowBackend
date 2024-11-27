package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDao extends JpaRepository<EquipmentEntity,String> {
}
