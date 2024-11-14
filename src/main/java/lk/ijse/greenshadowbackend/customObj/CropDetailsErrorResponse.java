package lk.ijse.greenshadowbackend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CropDetailsErrorResponse implements Serializable,CropDetailsResponse {
    private int errorCode;
    private String errorMessage;
}
