package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.dao.EquipmentDao;
import lk.ijse.greenshadowbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshadowbackend.entity.EquipmentEntity;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.service.EquipmentService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (savedEquipment == null){
            throw new DataPersistFailedException("Cannot save equipment");
        }
    }
    @Override
    public List<EquipmentDTO> getAllEquipments() {
        List<EquipmentEntity> getAllEquipments = equipmentDao.findAll();
        return mapping.convertEquipmentToDTOList(getAllEquipments);
    }


}
