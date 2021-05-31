package com.cortatebien.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cortatebien.app.dto.UsuarioDto;
import com.cortatebien.app.entity.Usuario;
import com.cortatebien.app.service.UsuarioServiceImplement;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500/", methods= {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImplement usuarioService;
	
	@GetMapping("/listar")
	public ArrayList<Usuario> obtenerUsuarios(){
		return (ArrayList<Usuario>) usuarioService.obtenerUsuarios();
	}

	@PostMapping("/guardarUsuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDto dto) {
		return new ResponseEntity<Usuario>(usuarioService.guardarUsuario(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> usuarioPorId(@PathVariable("id") Integer id){
		return usuarioService.usuarioPorId(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> loginUsuario(@RequestBody UsuarioDto dto){
		
		 return new ResponseEntity<Usuario>(usuarioService.loginUsuario(dto), HttpStatus.OK);
	}
}
