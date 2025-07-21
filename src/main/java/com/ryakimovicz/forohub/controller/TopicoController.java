package com.ryakimovicz.forohub.controller;

import com.ryakimovicz.forohub.repository.CursoRepository;
import com.ryakimovicz.forohub.repository.TopicoRepository;
import com.ryakimovicz.forohub.repository.UsuarioRepository;
import com.ryakimovicz.forohub.topico.DatosRegistroTopico;
import com.ryakimovicz.forohub.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @jakarta.validation.Valid DatosRegistroTopico datos) {
        // Validación de duplicados
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidationException("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Buscamos el autor y el curso
        var autor = usuarioRepository.findById(datos.autorId()).orElseThrow(() -> new ValidationException("No se encontró el autor."));
        var curso = cursoRepository.findById(datos.cursoId()).orElseThrow(() -> new ValidationException("No se encontró el curso."));

        // Creamos y guardamos el tópico
        var topico = new Topico(datos, autor, curso);
        topicoRepository.save(topico);

        return ResponseEntity.ok(topico); // Devuelve el tópico creado con código 200 OK
    }
}