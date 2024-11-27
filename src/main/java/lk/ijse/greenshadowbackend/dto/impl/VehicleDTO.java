package lk.ijse.greenshadowbackend.dto.impl;

import lk.ijse.greenshadowbackend.customObj.VehicleResponse;
import lk.ijse.greenshadowbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements SuperDTO, VehicleResponse {
    private String vehicleCode;
    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private String staffId;
    private String remarks;
}
