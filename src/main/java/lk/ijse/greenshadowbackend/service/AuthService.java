package lk.ijse.greenshadowbackend.service;

import lk.ijse.greenshadowbackend.dto.impl.UserDTO;
import lk.ijse.greenshadowbackend.jwtModels.JWTResponse;
import lk.ijse.greenshadowbackend.jwtModels.SignIn;

public interface AuthService {
    JWTResponse signIn(SignIn signIn);
    JWTResponse signUp(UserDTO userDTO);
    JWTResponse refreshToken(String accessToken);
}
