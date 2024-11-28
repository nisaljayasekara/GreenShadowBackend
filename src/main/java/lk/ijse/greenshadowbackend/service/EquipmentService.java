package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.impl.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);

    List<EquipmentDTO> getAllEquipments();

    void deleteEquipment(String equipmentId);


}
