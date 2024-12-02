package lk.ijse.greenshadowbackend.controller;

import lk.ijse.greenshadowbackend.dto.impl.UserDTO;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.jwtModels.JWTResponse;
import lk.ijse.greenshadowbackend.jwtModels.SignIn;
import lk.ijse.greenshadowbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authenticationService;

    @PostMapping(value = "signin")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn) {

        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @PostMapping(value = "signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTResponse> signUp(@RequestBody UserDTO userDTO) {
        try {

            return ResponseEntity.ok(authenticationService.signUp(userDTO));
        }catch (DataPersistFailedException e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("refresh")
    public ResponseEntity<JWTResponse> refreshToken (@RequestParam("refreshToken") String refreshToken) {

        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
