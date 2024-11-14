package lk.ijse.greenshadowbackend.dto.impl;

import lk.ijse.greenshadowbackend.customObj.CropResponse;
import lk.ijse.greenshadowbackend.customObj.FieldResponse;
import lk.ijse.greenshadowbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO   implements SuperDTO, FieldResponse {
    private String code;
    private String name;
    private Point location;
    private Double size_of_Field;
    private List<String> cropCodes;
    private List<String> staffIds;
    private String fieldImage1;
    private String fieldImage2;
}
