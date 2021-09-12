package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Meta;
import com.fiap.challenge.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MetaController {

    @Autowired
    private MetaRepository metaRepository;

    @GetMapping("/metas")
    public List<Meta> listarTodasMetas() {
        return metaRepository.findAll();
    }

    @GetMapping("/metas/{id}")
    public Meta detalharMeta(@PathVariable long id) {
        Optional<Meta> meta = metaRepository.findById(id);
        return meta.get();
    }

    @DeleteMapping("/metas/{id}")
    public void deletarMeta(@PathVariable long id) {
        metaRepository.deleteById(id);
    }

    @PostMapping("/metas")
    public ResponseEntity<Object> criarMeta(@RequestBody Meta meta) {
        Meta metaSalva = metaRepository.save(meta);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(metaSalva.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/metas/{id}")
    public ResponseEntity<Object> atualizarMeta(@RequestBody Meta meta, @PathVariable long id) {
        Optional<Meta> metaOptional = metaRepository.findById(id);

        if (!metaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        meta.setId(id);
        metaRepository.save(meta);

        return ResponseEntity.noContent().build();

    }

}
