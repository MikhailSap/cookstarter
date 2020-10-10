package ru.guteam.customer_service.entities.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UsersTypesConvertor implements AttributeConverter<UsersType, String> {

    @Override
    public String convertToDatabaseColumn(UsersType usersType) {
        if (usersType == null) {
            return null;
        }
        return usersType.getCode();
    }

    @Override
    public UsersType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(UsersType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);    }
}
