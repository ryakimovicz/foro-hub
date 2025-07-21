package com.ryakimovicz.forohub.controller;

import com.ryakimovicz.forohub.repository.CursoRepository;
import com.ryakimovicz.forohub.repository.TopicoRepository;
import com.ryakimovicz.forohub.repository.UsuarioRepository;
import com.ryakimovicz.forohub.topico.DatosListadoTopico; // <-- Import para tu DTO
import com.ryakimovicz.forohub.topico.DatosRegistroTopico;
import com.ryakimovicz.forohub.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page; // <-- Import para Page
import org.springframework.data.domain.Pageable; // <-- Import para Pageable
import org.springframework.data.web.PageableDefault; // <-- Import para PageableDefault
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; // <-- Import para GetMapping
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ryakimovicz.forohub.topico.DatosDetalleTopico;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.ryakimovicz.forohub.topico.DatosActualizacionTopico;

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
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidationException("Ya existe un tópico con el mismo título y mensaje.");
        }
        var autor = usuarioRepository.findById(datos.autorId()).orElseThrow(() -> new ValidationException("No se encontró el autor."));
        var curso = cursoRepository.findById(datos.cursoId()).orElseThrow(() -> new ValidationException("No se encontró el curso."));
        var topico = new Topico(datos, autor, curso);
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        var page = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizarTopico(@PathVariable Long id, @RequestBody @jakarta.validation.Valid DatosActualizacionTopico datos) {
        var topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}