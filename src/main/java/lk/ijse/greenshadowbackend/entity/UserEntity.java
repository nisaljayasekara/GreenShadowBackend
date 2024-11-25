package lk.ijse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity{
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}