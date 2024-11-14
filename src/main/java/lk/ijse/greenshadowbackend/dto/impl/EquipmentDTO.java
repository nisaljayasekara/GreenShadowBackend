package lk.ijse.greenshadowbackend.dto.impl;

import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements SuperDTO, EquipmentResponse {
    private String equipmentId;
    private String name;
    private String type;
    private String status;
    private String assignedStaffId;
    private String assignedFieldCode;
}
