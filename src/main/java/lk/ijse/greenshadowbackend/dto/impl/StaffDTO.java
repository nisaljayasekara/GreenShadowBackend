package lk.ijse.greenshadowbackend.dto.impl;


import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.dto.SuperDTO;
import lk.ijse.greenshadowbackend.enums.Designation;
import lk.ijse.greenshadowbackend.enums.Gender;
import lk.ijse.greenshadowbackend.enums.Role;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDTO implements SuperDTO {
    private String staffId;
    private String firstName;
    private String lastName;
    private Designation designation;
    private Gender gender;
    private LocalDate joinedDate;
    private LocalDate dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;






}
