package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.CropDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDetailsDao  extends JpaRepository<CropDetailsEntity,String> {

}
