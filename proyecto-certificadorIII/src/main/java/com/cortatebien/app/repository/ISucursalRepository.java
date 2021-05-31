package com.cortatebien.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cortatebien.app.entity.Sucursal;

public interface ISucursalRepository extends JpaRepository<Sucursal, Integer> {

}
