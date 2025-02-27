package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.VehicleResponse;
import lk.ijse.greenshadowbackend.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String vehicleCode);

    List<VehicleDTO> getAllVehicles();

    VehicleResponse getSelectedVehicle(String vehicleCode);

    void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO);
}
