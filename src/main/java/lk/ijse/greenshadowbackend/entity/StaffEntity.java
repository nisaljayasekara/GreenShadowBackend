package lk.ijse.greenshadowbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.dto.impl.StaffDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity{
    @Id
    @Column(name = "staff_id")
    private String id;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Enums.Role role;

    @Enumerated(EnumType.STRING)
    private Enums.Gender gender;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @Temporal(TemporalType.DATE)
    private Date dob;


    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNo;
    private String email;

    @ManyToMany(mappedBy = "staff")
    @JsonIgnore
    private List<FieldEntity> field;

    @ManyToMany(mappedBy = "staff")
    @JsonIgnore
    private List<CropDetails> cropDetails;

    @OneToOne(mappedBy = "staff",optional = true)
    @JsonIgnore
    private EquipmentEntity equipment;

    @OneToMany(mappedBy = "staff")
    @JsonIgnore
    private List<VehicleManagementEntity> vehicles;



}
