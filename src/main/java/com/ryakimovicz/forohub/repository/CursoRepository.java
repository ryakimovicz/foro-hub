package com.ryakimovicz.forohub.repository;
import com.ryakimovicz.forohub.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CursoRepository extends JpaRepository<Curso, Long> {}