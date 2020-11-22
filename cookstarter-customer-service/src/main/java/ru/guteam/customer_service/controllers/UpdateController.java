package ru.guteam.customer_service.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guteam.customer_service.entities.User;
import ru.guteam.customer_service.entities.utils.RestaurantInfo;
import ru.guteam.customer_service.services.UsersService;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/update")
@AllArgsConstructor
@Api("Set of endpoints for users information")
public class UpdateController {
    private final UsersService usersService;


    @ApiOperation("Updates restaurant's id and user's authority by his id.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateRestaurantId (@RequestBody @ApiParam("Cannot be empty") @Valid RestaurantInfo info) {
        Optional<User> user = usersService.findOptionalById(info.getUserId());
        if (!user.isPresent()) {
            return new ResponseEntity<>("User with id: " + info.getUserId() + " is not found", HttpStatus.NOT_FOUND);
        } else {
            usersService.updateRestaurantId (info);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}