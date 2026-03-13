package com.praktikum.crudktp.repository;

import com.praktikum.crudktp.model.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Ktp, Integer> {
}
