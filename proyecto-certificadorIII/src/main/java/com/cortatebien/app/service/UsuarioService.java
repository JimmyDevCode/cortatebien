package com.cortatebien.app.service;

import java.util.List;
import java.util.Optional;

import com.cortatebien.app.dto.UsuarioDto;
import com.cortatebien.app.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> obtenerUsuarios();
	
	public abstract Usuario guardarUsuario(UsuarioDto dto);
	
	public abstract Optional<Usuario> usuarioPorId (Integer id);
	
	public abstract Usuario loginUsuario (UsuarioDto dto);
	
}
