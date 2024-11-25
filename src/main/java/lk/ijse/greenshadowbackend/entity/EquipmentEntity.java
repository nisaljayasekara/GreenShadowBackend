package lk.ijse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.enums.Status;
import lk.ijse.greenshadowbackend.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity{
    @Id
    private String equipmentId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
}
