package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);

    List<FieldDTO> getAllFields();


}
