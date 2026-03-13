package com.praktikum.crudktp.mapper;


import com.praktikum.crudktp.model.dto.userDto;
import com.praktikum.crudktp.model.entity.Ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    userDto toUserDtoData (Ktp ktp);
}