package com.example.musicalista.controller;

import java.util.List;

import com.example.musicalista.shared.MusicaDto;
import com.example.musicalista.service.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public MusicaDto obterPorId(@PathVariable String id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public MusicaDto adicionar(@RequestBody MusicaDto musica) {
        return service.adicionar(musica);
    }

    @PutMapping("/{id}")
    public MusicaDto atualizar(@PathVariable String id, @RequestBody MusicaDto musica) {
        return service.atualizar(id, musica);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}
