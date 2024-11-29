package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.impl.CropDTO;
import lk.ijse.greenshadowbackend.exceptions.CropNotFound;
import lk.ijse.greenshadowbackend.service.CropService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/crop")
@RequiredArgsConstructor
//@PreAuthorize("hasAnyRole('MANAGER', 'SCIENTIST')")
public class CropController {

    @Autowired
    private final CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrop(
                                         @RequestPart("cropCommonName") String cropCommonName,
                                         @RequestPart("cropScientificName") String cropScientificName,
                                         @RequestPart("cropImage")MultipartFile cropImage,
                                         @RequestPart("category") String category,
                                         @RequestPart("cropSeason") String cropSeason,
                                         @RequestPart("filedCode") String fieldCode
    ){
        try {
            String base64CropImage = AppUtil.toBase64CropImage(cropImage);
            var cropDTO = new CropDTO();
            cropDTO.setCropCode(AppUtil.createCropId());
            cropDTO.setCropCommonName(cropCommonName);
            cropDTO.setCropScientificName(cropScientificName);
            cropDTO.setCropImage(base64CropImage);
            cropDTO.setCategory(category);
            cropDTO.setCropSeason(cropSeason);
            cropDTO.setFieldCode(fieldCode);

            cropService.saveCrop(cropDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CropNotFound e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CropDTO> getAllCrops(){
//        return cropService.getAllCrops();
//    }
//
//    @GetMapping(value = "/{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public CropResponse getSelectedCrop(@PathVariable("cropCode") String cropCode){
//        return cropService.getSelectedCrop(cropCode);
//    }
//
//    @PatchMapping(value = "/{cropCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> updateCrop(
//            @PathVariable("cropCode") String cropCode,
//            @RequestPart("updateCropCommonName") String updateCropCommonName,
//            @RequestPart("updateCropScientificName") String updateCropScientificName,
//            @RequestPart(value = "updateCropImage", required = false) MultipartFile updateCropImage,
//            @RequestPart("updateCategory") String updateCategory,
//            @RequestPart("updateCropSeason") String updateCropSeason,
//            @RequestPart("updateFieldCode") String updateFieldCode
//    ) {
//        try {
//            String updateBase64CropImage = null;
//            if (updateCropImage != null && !updateCropImage.isEmpty()) {
//                updateBase64CropImage = AppUtil.toBase64CropImage(updateCropImage);
//            }
//
//            var updateCropDTO = new CropDTO();
//            updateCropDTO.setCropCode(cropCode);
//            updateCropDTO.setCropCommonName(updateCropCommonName);
//            updateCropDTO.setCropScientificName(updateCropScientificName);
//            updateCropDTO.setCategory(updateCategory);
//            updateCropDTO.setCropSeason(updateCropSeason);
//            updateCropDTO.setFieldCode(updateFieldCode);
//
//            if (updateBase64CropImage != null) {
//                updateCropDTO.setCropImage(updateBase64CropImage);
//            }
//
//            cropService.updateCrop(updateCropDTO);
//            logger.info("Crop Updated :" + updateCropDTO);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (CropNotFound e) {
//            logger.error(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping(value = "/{cropCode}")
//    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode){
//        try{
//            cropService.deleteCrop(cropCode);
//            logger.info("Crop deleted :" + cropCode);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }catch (CropNotFound e){
//            logger.error(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}