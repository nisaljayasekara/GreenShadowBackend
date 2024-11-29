package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropDao  extends JpaRepository<CropEntity,String> {

}
