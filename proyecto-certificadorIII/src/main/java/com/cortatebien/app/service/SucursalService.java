package com.cortatebien.app.service;

import java.util.List;
import java.util.Optional;

import com.cortatebien.app.dto.SucursalDto;
import com.cortatebien.app.entity.Sucursal;

public interface SucursalService {

	public abstract List<Sucursal> obtenerSucursales();
	
	public abstract Sucursal guardarSucursal(SucursalDto dto);
	
	public Optional<Sucursal> sucursalPorId(Integer id);
}
