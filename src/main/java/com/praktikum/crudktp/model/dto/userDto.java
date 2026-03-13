package com.praktikum.crudktp.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class userDto {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}