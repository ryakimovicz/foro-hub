package com.ryakimovicz.forohub.repository;
import com.ryakimovicz.forohub.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // Metodo para validar tópicos duplicados
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}