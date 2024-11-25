package lk.ijse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cropDetails")
public class CropDetailsEntity implements SuperEntity{
    @Id
    private String logCode;

    @CreationTimestamp
    private LocalDate logDate;

    private String logDetails;

    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logField",
            joinColumns = @JoinColumn(name = "logCode"),
            inverseJoinColumns = @JoinColumn(name = "fieldCode")
    )
    private List<FieldEntity> field;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logCrop",
            joinColumns = @JoinColumn(name = "logCode"),
            inverseJoinColumns = @JoinColumn(name = "cropCode")
    )
    private List<CropEntity> crop;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logStaff",
            joinColumns = @JoinColumn(name = "logCode"),
            inverseJoinColumns = @JoinColumn(name = "staffId")
    )
    private List<StaffEntity> staff;
}
