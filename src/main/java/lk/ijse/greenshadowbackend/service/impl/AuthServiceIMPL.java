package lk.ijse.greenshadowbackend.service.impl;


import lk.ijse.greenshadowbackend.dao.UserDao;
import lk.ijse.greenshadowbackend.dto.impl.UserDTO;
import lk.ijse.greenshadowbackend.entity.UserEntity;
import lk.ijse.greenshadowbackend.jwtModels.JWTResponse;
import lk.ijse.greenshadowbackend.jwtModels.SignIn;
import lk.ijse.greenshadowbackend.service.AuthService;
import lk.ijse.greenshadowbackend.service.JWTService;
import lk.ijse.greenshadowbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDao userDao;
    private final JWTService jwtService;
    private final Mapping mapping;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JWTResponse.builder().token(generatedToken).build() ;
    }
    @Override
    public JWTResponse signUp(UserDTO userDTO) {
        UserEntity user = mapping.convertToUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userDao.save(user);
        var genToken = jwtService.generateToken(savedUser);
        return JWTResponse.builder().token(genToken).build();
    }
    @Override
    public JWTResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity =
                userDao.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(userEntity);
        return JWTResponse.builder().token(refreshToken).build();
    }

}
