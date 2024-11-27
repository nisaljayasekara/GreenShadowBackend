package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.impl.VehicleDTO;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String vehicleCode);
}
