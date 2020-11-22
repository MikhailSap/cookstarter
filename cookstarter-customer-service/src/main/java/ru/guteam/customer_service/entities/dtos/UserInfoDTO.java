package ru.guteam.customer_service.entities.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guteam.customer_service.entities.UsersInfo;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel(description = "Class representing a data about user.")
public class UserInfoDTO {

    @NotNull
    @ApiModelProperty(notes = "User's firstname", example = "Ivan", required = true, position = 1)
    private String firstName;

    @NotNull
    @ApiModelProperty(notes = "User's lastname", example = "Ivanov", required = true, position = 2)
    private String lastName;

    @NotNull
    @ApiModelProperty(notes = "User's email", example = "Ivanov@mail.ru", required = true, position = 3)
    private String email;

    public UserInfoDTO(UsersInfo customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
    }
}
