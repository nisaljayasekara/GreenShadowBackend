package lk.ijse.greenshadowbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity  implements SuperEntity{
    @Id
    @Column(name = "field_code", nullable = false)
    private String code;
    private String name;

    @Column(columnDefinition = "Point")
    private String location;
    private Double size_of_Field;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CropEntity> crop;

    @ManyToMany
    @JoinTable(
            name = "field_staff",
            joinColumns = @JoinColumn(name = "field_code"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<StaffEntity> staff;

    @Lob
    private String fieldImage1;

    @Lob
    private String fieldImage2;

    @ManyToMany(mappedBy = "field")
    @JsonIgnore
    private List<CropDetails> cropDetails;


//    @Column(name = "f_image1", columnDefinition = "LONGTEXT")
//    private String fieldImage1;
//    @Column(name = "f_image2", columnDefinition = "LONGTEXT")
//    private String fieldImage2;



}
