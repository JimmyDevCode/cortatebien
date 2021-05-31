package com.cortatebien.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.SucursalDto;
import com.cortatebien.app.entity.Sucursal;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.repository.ISucursalRepository;
import com.cortatebien.app.repository.IUsuarioRepository;

@Service
public class SucursalServiceImplement implements SucursalService{

	@Autowired
	IUsuarioRepository iusuarioRepository;
	
	@Autowired
	ISucursalRepository isucursalRepository;
	
	
	
	@Override
	public Sucursal guardarSucursal(SucursalDto dto) {
		Sucursal sucursal = new Sucursal();
		sucursal.setNombre(dto.getNombre());
		sucursal.setRazon_social(dto.getRazon_social());
		sucursal.setRuc(dto.getRuc());
		sucursal.setTelefono(dto.getTelefono());
		Optional<Usuario> usuarioOptional = iusuarioRepository.findById(dto.getId_usuario());
		if(usuarioOptional.isPresent()) {
			sucursal.setUsuario(usuarioOptional.get());
		}
		sucursal.setHorario(dto.getHorario());
		//sucursal.setDireccion(dto.getDireccion());
		isucursalRepository.save(sucursal);
		return sucursal;
		
	}

	@Override
	public Optional<Sucursal> sucursalPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sucursal> obtenerSucursales() {
		
		return isucursalRepository.findAll();
	}

}
