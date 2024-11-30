package lk.ijse.greenshadowbackend.customObj.impl;

import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class StaffErrorResponse implements StaffResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
