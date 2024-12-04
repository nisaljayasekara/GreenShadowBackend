package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lk.ijse.greenshadowbackend.dto.impl.CropDetailsDTO;

import java.util.List;

public interface CropDetailsService {

    void saveCropDetails(CropDetailsDTO cropDetailsDTO);
    List<CropDetailsDTO> getAllCropDetails();
    CropDetailsResponse getSelectedCropDetail(String logCode);
    void updateCropDetails(CropDetailsDTO updatecropDetailsDTO);
    void deleteCropDetails(String logCode);

}
