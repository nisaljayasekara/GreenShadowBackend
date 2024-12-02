package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserResponse getSelectedUser(String email);
    void updateUser(String email, UserDTO userDTO);
    void deleteUser(String email);
//    UserDetailsService userDetailsService();


}
