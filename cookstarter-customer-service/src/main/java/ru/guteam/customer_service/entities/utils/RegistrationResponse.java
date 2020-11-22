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
@ApiModel(description = "Class representing response with user's id after user's registration in the application.")
public class RegistrationResponse {

    @NotNull
    @ApiModelProperty(notes = "User's unique identifier. No two users can have the same id. ", example = "1", required = true)
    private Long id;

}
