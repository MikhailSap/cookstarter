package ru.guteam.customer_service.entities.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing data about restaurant's id and user's authority for updating it by his id in the application.")
public class RestaurantInfo {

    @NotNull
    @ApiModelProperty(notes = "User's unique identifier. No two users can have the same id. ", example = "1", required = true, position = 1)
    private Long userId;

    @NotNull
    @ApiModelProperty(notes = "Restaurant's unique identifier. No two restaurants can have the same id. ", example = "101", required = true, position = 2)
    private Long restaurantId;

    @NotNull
    @ApiModelProperty(notes = "User's authority name.", example = "RESTAURANT_MANAGER", required = true, position = 3)
    private String roleName;



}
