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

import com.cortatebien.app.dto.SucursalDto;
import com.cortatebien.app.entity.Sucursal;
import com.cortatebien.app.service.SucursalServiceImplement;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

	
	@Autowired
	SucursalServiceImplement sucursalService;
	
	@GetMapping("/listar")
	public ArrayList<Sucursal> obtenerSucursales(){
		return (ArrayList<Sucursal>) sucursalService.obtenerSucursales();
	}
	
	@PostMapping("/guardarSucursal")
	public ResponseEntity<Sucursal> guardarSucursal(@RequestBody SucursalDto dto) {
		return new ResponseEntity<Sucursal>(sucursalService.guardarSucursal(dto), HttpStatus.CREATED);
	}
}
