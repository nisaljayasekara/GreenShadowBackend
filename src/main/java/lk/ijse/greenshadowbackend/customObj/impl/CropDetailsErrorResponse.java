package lk.ijse.greenshadowbackend.customObj.impl;

import lk.ijse.greenshadowbackend.customObj.CropDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDetailsErrorResponse implements CropDetailsResponse {
    private int errorCode;
    private String errorMessage;
}