package com.praktikum.crudktp.service;



import com.praktikum.crudktp.model.dto.UserAddRequest;
import com.praktikum.crudktp.model.dto.userDto;

import java.util.List;

public interface UserService {
    userDto AddUser(UserAddRequest request);
    List<userDto> getAllUser();
    userDto getUserById(Integer id);
    userDto UpdateUser(Integer id, UserAddRequest request);
    void DeleteUser(Integer id);
}