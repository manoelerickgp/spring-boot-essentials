package com.estudo.SpringEstudoDevDojo.service;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {

    public static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Naruto"),
                new Anime(2L, "DBZ"), new Anime(3L, "One Punch Man")));
    }

    public List<Anime> findAll(){
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(0, 1000));
        animes.add(anime);
        return anime;
    }

    public void update(Long id, Anime anime) {
        animes.remove(findById(id));
        save(anime);
    }

    public void delete(Long id) {
        animes.remove(findById(id));
    }

    public void updateAnime(Anime animeToBeUpdate, Anime anime) {
        animeToBeUpdate.setId(anime.getId());
        animeToBeUpdate.setName(anime.getName());
    }
}
