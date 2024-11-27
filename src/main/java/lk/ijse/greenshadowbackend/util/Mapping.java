package lk.ijse.greenshadowbackend.util;

import lk.ijse.greenshadowbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshadowbackend.dto.impl.VehicleDTO;
import lk.ijse.greenshadowbackend.entity.EquipmentEntity;
import lk.ijse.greenshadowbackend.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
