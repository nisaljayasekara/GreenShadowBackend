package lk.ijse.greenshadowbackend.controller;


import lk.ijse.greenshadowbackend.dto.impl.FieldDTO;
import lk.ijse.greenshadowbackend.exceptions.FieldNotFound;
import lk.ijse.greenshadowbackend.service.FieldService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class FieldController {
    @Autowired
    private final FieldService fieldService;
    static Logger logger = LoggerFactory.getLogger(FieldController.class);
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveField(
                                           @RequestPart("fieldName") String fieldName,
                                           @RequestPart("latitude") String latitude,
                                           @RequestPart("longitude") String longitude,
                                           @RequestPart("extentSize") String extentSize,
                                           @RequestPart("fieldImage1") MultipartFile fieldImage1,
                                           @RequestPart("fieldImage2") MultipartFile fieldImage2,
                                           @RequestPart("staffIds") String staffIds
    ){
        try{
            List<String> staffIdList = Arrays.asList(staffIds.split(","));
            java.awt.Point fieldLocation = new java.awt.Point((int) Double.parseDouble(latitude), (int) Double.parseDouble(longitude));
            String base64FieldImage1 = AppUtil.toBase64FieldImage1(fieldImage1);
            String base64FieldImage2 = AppUtil.toBase64FieldImage2(fieldImage2);
            var fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(AppUtil.createFieldId());
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setFieldLocation(fieldLocation);
            fieldDTO.setExtendSize(Double.parseDouble(extentSize));
            fieldDTO.setFieldImage1(base64FieldImage1);
            fieldDTO.setFieldImage2(base64FieldImage2);
            fieldDTO.setStaffIds(staffIdList);

            fieldService.saveField(fieldDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FieldNotFound e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields(){
        return fieldService.getAllFields();
    }


}
