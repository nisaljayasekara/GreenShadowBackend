package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.dao.EquipmentDao;
import lk.ijse.greenshadowbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshadowbackend.entity.EquipmentEntity;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exceptions.EquipmentNotFound;
import lk.ijse.greenshadowbackend.service.EquipmentService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EquimpentServiceIMPL implements EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        equipmentDTO.setEquipmentId(AppUtil.createEquipmentId());
        var equipmentEntity = mapping.convertToEquipmentEntity(equipmentDTO);
        var savedEquipment = equipmentDao.save(equipmentEntity);
        if (savedEquipment == null) {
            throw new DataPersistFailedException("Cannot save equipment");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        List<EquipmentEntity> getAllEquipments = equipmentDao.findAll();
        return mapping.convertEquipmentToDTOList(getAllEquipments);
    }
    @Override
    public void deleteEquipment(String equipmentId) {
        Optional<EquipmentEntity> findId = equipmentDao.findById(equipmentId);
        if (!findId.isPresent()){
            throw new EquipmentNotFound("Equipment not Found");
        }else {
            equipmentDao.deleteById(equipmentId);
        }
    }
}
