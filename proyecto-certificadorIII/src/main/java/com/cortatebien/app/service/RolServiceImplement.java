package com.cortatebien.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.RolDto;
import com.cortatebien.app.entity.Rol;
import com.cortatebien.app.repository.IRolRepository;

@Service
public class RolServiceImplement implements RolService {

	@Autowired
	IRolRepository irolrepository;
	
	@Override
	public List<Rol> obtenerRoles() {
		// TODO Auto-generated method stub
		return irolrepository.findAll();
	}

	@Override
	public Rol guardarRol(RolDto rolDto) {
		Rol rol = new Rol();
		rol.setNombre(rolDto.getNombre());
		irolrepository.save(rol);
		
		return rol;
	}

}
