package lk.ijse.greenshadowbackend.entity;


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
@Table(name = "crops")
public class CropEntity implements SuperEntity {

    @Id
    @Column(name = "crop_code")
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;

    @Lob
    @Column(name = "c_image")
    private String cropImage;

//    @Column(name = "c_image", columnDefinition = "LONGTEXT")
//    private String cropImage;

    private String category;
    private String cropSeason;

    @ManyToOne
    @JoinColumn(name = "field_code")
    private FieldEntity field;

}
