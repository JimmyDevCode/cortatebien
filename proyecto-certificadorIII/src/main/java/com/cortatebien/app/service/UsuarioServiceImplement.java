package com.cortatebien.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortatebien.app.dto.UsuarioDto;
import com.cortatebien.app.entity.Rol;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.repository.IRolRepository;
import com.cortatebien.app.repository.ISucursalRepository;
import com.cortatebien.app.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImplement implements UsuarioService {

	@Autowired
	IUsuarioRepository iusuarioRepository;
	
	@Autowired
	IRolRepository irolRepository;

	@Override
	public List<Usuario> obtenerUsuarios() {

			return iusuarioRepository.findAll();
	}

	@Override
	public Usuario guardarUsuario(UsuarioDto dto) {
		Usuario user = new Usuario();
		user.setNombre(dto.getNombre());
		user.setApe_pat(dto.getApe_pat());
		user.setApe_mat(dto.getApe_mat());
		user.setDNI(dto.getDNI());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		Optional<Rol> rolOptional = irolRepository.findById(dto.getId_rol());
		if(rolOptional.isPresent()) {
			user.setRol(rolOptional.get());
		}
		iusuarioRepository.save(user);
		return user;
	}

	@Override
	public Optional<Usuario> usuarioPorId(Integer id) {
		return iusuarioRepository.findById(id);
	}

	@Override
	public Usuario loginUsuario(UsuarioDto dto) {
		Usuario userExist = iusuarioRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
		return userExist;
	}

	


}

