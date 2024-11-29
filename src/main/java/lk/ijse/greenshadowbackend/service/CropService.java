package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.CropResponse;
import lk.ijse.greenshadowbackend.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropResponse getSelectedCrop(String cropCode);
}
