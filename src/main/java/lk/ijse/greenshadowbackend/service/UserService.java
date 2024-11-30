package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();

}
