package lk.ijse.greenshadowbackend.util;

import lk.ijse.greenshadowbackend.dto.impl.*;
import lk.ijse.greenshadowbackend.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    public Mapping(){this.modelMapper = new ModelMapper();}

    //VehicleEntity and DTO
    public VehicleDTO convertToVehicleDTO(VehicleEntity vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
    public VehicleEntity convertToVehicleEntity(VehicleDTO dto){
        return modelMapper.map(dto, VehicleEntity.class);
    }
    public List<VehicleDTO> convertVehicleToDTOList(List<VehicleEntity> vehicles){
        return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>(){}.getType());
    }

   //vehicle equimpent

    public EquipmentDTO convertToEquipmentDTO(EquipmentEntity equipment){return modelMapper.map(equipment, EquipmentDTO.class);}
    public EquipmentEntity convertToEquipmentEntity(EquipmentDTO dto){return modelMapper.map(dto, EquipmentEntity.class);}
    public List<EquipmentDTO> convertEquipmentToDTOList(List<EquipmentEntity> equipment){
        return modelMapper.map(equipment, new TypeToken<List<EquipmentDTO>>(){}.getType());
    }

    public CropDTO convertToCropDTO(CropEntity crop){return modelMapper.map(crop, CropDTO.class);}
    public CropEntity convertToCropEntity(CropDTO dto){return modelMapper.map(dto, CropEntity.class);}
    public List<CropDTO> convertCropToDTOList(List<CropEntity> crop){
        return modelMapper.map(crop, new TypeToken<List<CropDTO>>(){}.getType());
    }

    public StaffDTO convertToStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public StaffEntity convertToStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, StaffEntity.class);
    }
    public List<StaffDTO> convertStaffToDTOList(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>(){}.getType());
    }




}
