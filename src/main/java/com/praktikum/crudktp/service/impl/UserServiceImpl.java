package com.praktikum.crudktp.service.impl;



import com.praktikum.crudktp.mapper.UserMapper;
import com.praktikum.crudktp.model.dto.UserAddRequest;
import com.praktikum.crudktp.model.dto.userDto;
import com.praktikum.crudktp.model.entity.Ktp;
import com.praktikum.crudktp.repository.UserRepository;
import com.praktikum.crudktp.service.UserService;
import com.praktikum.crudktp.util.ValiationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValiationUtil validationUtil;

    @Override
    public userDto AddUser(UserAddRequest request) {
        validationUtil.validate(request);

        Ktp saveUser = Ktp.builder()
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        userRepository.save(saveUser);

        userDto userDto = UserMapper.MAPPER.toUserDtoData(saveUser);

        return userDto;
    }

    @Override
    public List<userDto> getAllUser() {
        List<Ktp> users = userRepository.findAll();
        List<userDto> userDto = new ArrayList<>();
        for (Ktp ktp : users) {
            userDto.add(UserMapper.MAPPER.toUserDtoData(ktp));
        }
        return userDto;
    }

    @Override
    public userDto getUserById(Integer id) {
        Ktp ktp = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        return UserMapper.MAPPER.toUserDtoData(ktp);
    }

    @Override
    public userDto UpdateUser(String id, UserAddRequest request) {
        validationUtil.validate(request);

        Ktp existingUser = userRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new RuntimeException("user not found"));

        existingUser.setNomorKtp(request.getNomorKtp());
        existingUser.setNamaLengkap(request.getNamaLengkap());
        existingUser.setAlamat(request.getAlamat());
        existingUser.setTanggalLahir(request.getTanggalLahir());
        existingUser.setJenisKelamin(request.getJenisKelamin());

        userRepository.save(existingUser);

        return UserMapper.MAPPER.toUserDtoData(existingUser);
    }

    @Override
    public void DeleteUser(Integer id) {

        Ktp user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));

        userRepository.delete(user);
    }
}