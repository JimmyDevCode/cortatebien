package com.cortatebien.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortatebien.app.dto.RolDto;
import com.cortatebien.app.entity.Rol;
import com.cortatebien.app.service.RolServiceImplement;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	RolServiceImplement rolService;
	
	@GetMapping("/listar")
	public ArrayList<Rol> obtenerRoles(){
		
		return (ArrayList<Rol>) rolService.obtenerRoles();
	}
	
	@PostMapping("/guardarRol")
	public ResponseEntity<Rol> guardarRol(@RequestBody RolDto rolDto){
		return new ResponseEntity<Rol>(
				rolService.guardarRol(rolDto), HttpStatus.CREATED);
	}
}
