package com.cortatebien.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cortatebien.app.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
	public Usuario findByEmailAndPassword(String email, String password);
}
