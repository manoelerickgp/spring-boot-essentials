package com.estudo.SpringEstudoDevDojo.service;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnimeService {

    private List<Anime> animes = List.of(new Anime(1L, "DBZ"),
            new Anime(2L, "Naruto"),
            new Anime(3L, "One Punch Man"));

    public List<Anime> findAll(){
        return  animes;
    }

    public Anime findById(Long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found"));
    }
}
