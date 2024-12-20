package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.customObj.VehicleResponse;
import lk.ijse.greenshadowbackend.customObj.impl.VehicleErrorResponse;
import lk.ijse.greenshadowbackend.dao.VehicleDao;
import lk.ijse.greenshadowbackend.dto.impl.VehicleDTO;
import lk.ijse.greenshadowbackend.entity.VehicleEntity;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exceptions.VehicleNotFound;
import lk.ijse.greenshadowbackend.service.VehicleService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleCode(AppUtil.createVehicleCode());
        var vehicleEntity = mapping.convertToVehicleEntity(vehicleDTO);
        var savedVehicle = vehicleDao.save(vehicleEntity);
        if (savedVehicle == null) {
            throw new DataPersistFailedException("Cannot save vehicle");
        }
    }

    @Override
    public void deleteVehicle(String vehicleCode) {
        Optional<VehicleEntity> findId = vehicleDao.findById(vehicleCode);
        if (!findId.isPresent()) {
            throw new VehicleNotFound("Vehicle not Found");
        } else {
            vehicleDao.deleteById(vehicleCode);
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleEntity> getAllVehicles = vehicleDao.findAll();
        return mapping.convertVehicleToDTOList(getAllVehicles);
    }

    @Override
    public VehicleResponse getSelectedVehicle(String vehicleCode) {
        if (vehicleDao.existsById(vehicleCode)){
            VehicleEntity vehicleEntityByVehicleCode = vehicleDao.getReferenceById(vehicleCode);
            return (VehicleResponse) mapping.convertToVehicleDTO(vehicleEntityByVehicleCode);
        }else {
            return new VehicleErrorResponse(0,"Vehicle not Found");
        }
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO incomevehicleDTO) {
        Optional<VehicleEntity> tmpVehicleEntity = vehicleDao.findById(vehicleCode);

        if (!tmpVehicleEntity.isPresent()) {
            throw new VehicleNotFound("Vehicle not found");
        } else {
            VehicleEntity vehicleEntity = tmpVehicleEntity.get();

            vehicleEntity.setVehicleCategory(incomevehicleDTO.getVehicleCategory());
            vehicleEntity.setFuelType(incomevehicleDTO.getFuelType());
            vehicleEntity.setLicensePlateNumber(incomevehicleDTO.getLicensePlateNumber());
            vehicleEntity.setStatus(incomevehicleDTO.getStatus());
            vehicleEntity.setRemarks(incomevehicleDTO.getRemarks());

            vehicleDao.save(vehicleEntity);
        }
    }

}
