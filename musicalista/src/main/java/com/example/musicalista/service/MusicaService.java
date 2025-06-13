package com.example.musicalista.service;

import java.util.List;
import com.example.musicalista.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodos();
    MusicaDto obterPorId(String id);
    MusicaDto adicionar(MusicaDto musica);
    MusicaDto atualizar(String id, MusicaDto musica);
    void deletar(String id);
}
