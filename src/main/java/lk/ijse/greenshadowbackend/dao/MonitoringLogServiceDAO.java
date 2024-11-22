package lk.ijse.greenshadowbackend.dao;

import lk.ijse.greenshadowbackend.entity.MonitoringLogServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogServiceDAO extends JpaRepository<MonitoringLogServiceEntity,String> {
}
