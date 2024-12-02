package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.customObj.UserResponse;
import lk.ijse.greenshadowbackend.customObj.impl.UserErrorResponse;
import lk.ijse.greenshadowbackend.dao.UserDao;
import lk.ijse.greenshadowbackend.dto.impl.UserDTO;
import lk.ijse.greenshadowbackend.entity.UserEntity;
import lk.ijse.greenshadowbackend.enums.Role;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exceptions.UserNotFound;
import lk.ijse.greenshadowbackend.service.UserService;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveUser(UserDTO userDTO) {
        var userEntity = mapping.convertToUserEntity(userDTO);
        var savedUser = userDao.save(userEntity);
        if (savedUser == null) {
            throw new DataPersistFailedException("Cannot Save User");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> getAllUsers = userDao.findAll();
        return mapping.convertUserToDTOList(getAllUsers);
    }

    @Override
    public UserResponse getSelectedUser(String email) {
        if (userDao.existsById(email)) {
            UserEntity userEntityByEmail = userDao.getReferenceById(email);
            return (UserResponse) mapping.convertToUserDTO(userEntityByEmail);
        } else {
            return new UserErrorResponse(0, "User not Found");
        }
    }
    @Override
    public void updateUser(String email, UserDTO incomeUserDTO) {
        UserEntity existingUser = userDao.findById(email)
                .orElseThrow(() -> new UserNotFound("User not found with email: " + email));

        UserEntity updatedUser = new UserEntity();
        updatedUser.setEmail(incomeUserDTO.getEmail() != null ? incomeUserDTO.getEmail() : existingUser.getEmail());
        updatedUser.setPassword(incomeUserDTO.getPassword() != null ? incomeUserDTO.getPassword() : existingUser.getPassword());

        if (incomeUserDTO.getRole() != null) {
            updatedUser.setRole(Role.valueOf(String.valueOf(incomeUserDTO.getRole())));
        } else {
            updatedUser.setRole(existingUser.getRole());
        }

        userDao.delete(existingUser);

        userDao.save(updatedUser);
    }
    @Override
    public void deleteUser(String email) {
        Optional<UserEntity> findId = userDao.findById(email);
        if (!findId.isPresent()){
            throw new UserNotFound("User not Found");
        }else {
            userDao.deleteById(email);
        }
    }
//    @Override
//    public UserDetailsService userDetailsService() {
//        return email ->
//                userDao.findByEmail(email)
//                        .orElseThrow(()-> new UserNotFound("User Not found"));
//    }


}
