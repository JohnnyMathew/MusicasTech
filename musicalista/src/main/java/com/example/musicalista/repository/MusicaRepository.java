package com.example.musicalista.repository;

import com.example.musicalista.model.Musica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String> {
}
