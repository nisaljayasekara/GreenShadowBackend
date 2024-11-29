package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.customObj.CropResponse;
import lk.ijse.greenshadowbackend.customObj.impl.CropErrorResponse;
import lk.ijse.greenshadowbackend.dao.CropDao;
import lk.ijse.greenshadowbackend.dto.impl.CropDTO;
import lk.ijse.greenshadowbackend.entity.CropEntity;
import lk.ijse.greenshadowbackend.service.CropService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropSeviceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping mapping;
    public void saveCrop(CropDTO cropDTO) {
        CropEntity cropEntity = mapping.convertToCropEntity(cropDTO);

        if (cropEntity.getCropCode() == null || cropEntity.getCropCode().isEmpty()){
            cropEntity.setCropCode(AppUtil.createCropId());
        }

        cropDao.save(cropEntity);
    }
    @Override
    public List<CropDTO> getAllCrops() {
        List<CropEntity> getAllCrops = cropDao.findAll();
        return mapping.convertCropToDTOList(getAllCrops);
    }
    @Override
    public CropResponse getSelectedCrop(String cropCode) {
        if (cropDao.existsById(cropCode)) {
            CropEntity cropEntityByCropCode = cropDao.getReferenceById(cropCode);
            return mapping.convertToCropDTO(cropEntityByCropCode);
        } else {
            return new CropErrorResponse(0, "Crop not Found");
        }
    }


}
