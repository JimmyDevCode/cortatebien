package com.cortatebien.app.service;

import java.util.List;

import com.cortatebien.app.dto.RolDto;
import com.cortatebien.app.entity.Rol;

public interface RolService {

	
	public abstract List<Rol> obtenerRoles();
	
	public abstract Rol guardarRol(RolDto rolDto);
}
