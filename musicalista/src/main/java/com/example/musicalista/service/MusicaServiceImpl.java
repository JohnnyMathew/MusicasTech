package com.example.musicalista.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.musicalista.model.Musica;
import com.example.musicalista.repository.MusicaRepository;
import com.example.musicalista.shared.MusicaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repo;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MusicaDto> obterTodos() {
        List<Musica> musicas = repo.findAll();
        
        return musicas.stream()
            .map(musica -> mapper.map(musica, MusicaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDto obterPorId(String id) {
        Musica musica = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Música não encontrada"));
        
        return mapper.map(musica, MusicaDto.class);
    }

    @Override
    public MusicaDto adicionar(MusicaDto musicaDto) {
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repo.save(musica);
        
        return mapper.map(musica, MusicaDto.class);
    }

    @Override
    public MusicaDto atualizar(String id, MusicaDto musicaDto) {
        musicaDto.setId(id);
        Musica musica = mapper.map(musicaDto, Musica.class);
        musica = repo.save(musica);
        
        return mapper.map(musica, MusicaDto.class);
    }

    @Override
    public void deletar(String id) {
        repo.deleteById(id);
    }
}
