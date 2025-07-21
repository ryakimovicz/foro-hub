package com.ryakimovicz.forohub.repository;
import com.ryakimovicz.forohub.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}