package ru.guteam.customer_service.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guteam.customer_service.entities.utils.SystemRestaurant;
import ru.guteam.customer_service.services.UsersService;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class RegistrationController {
    private final UsersService usersService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processRegistrationForm(@RequestBody SystemRestaurant systemRestaurant) {
        usersService.save(systemRestaurant);
        return new ResponseEntity<>(systemRestaurant, HttpStatus.OK);
    }

//    @PostMapping(value = "/rest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> createRestaurantAuthToken(@RequestBody UsernameAndPasswordRequest authRequest) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            return new ResponseEntity<>("Неверные логин или пароль", HttpStatus.UNAUTHORIZED);
//        }
//        UserDetails userDetails = restaurantsService.loadUserByUsername(authRequest.getUsername());
//        String token = jwtTokenUtil.generateToken(userDetails);
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }

}
