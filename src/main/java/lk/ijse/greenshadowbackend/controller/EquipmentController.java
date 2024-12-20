package lk.ijse.greenshadowbackend.controller;


import lk.ijse.greenshadowbackend.customObj.EquipmentResponse;
import lk.ijse.greenshadowbackend.dto.impl.EquipmentDTO;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exceptions.EquipmentNotFound;
import lk.ijse.greenshadowbackend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    @Autowired
    private final EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createEquipment( @RequestBody EquipmentDTO equipment){
        if (equipment == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                equipmentService.saveEquipment(equipment);

                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO> getAllEquipments(){
        return equipmentService.getAllEquipments();
    }

    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable("equipmentId") String equipmentId){
        try{
            equipmentService.deleteEquipment(equipmentId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EquipmentNotFound e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentResponse getSelectedEquipment(@PathVariable("equipmentId") String equipmentId){
        return equipmentService.getSelectedEquipment(equipmentId);
    }

}
