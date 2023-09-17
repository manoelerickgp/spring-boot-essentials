package com.estudo.SpringEstudoDevDojo.service;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import com.estudo.SpringEstudoDevDojo.mapper.AnimeMapper;
import com.estudo.SpringEstudoDevDojo.repository.AnimeRepository;
import com.estudo.SpringEstudoDevDojo.request.AnimePostRequestBody;
import com.estudo.SpringEstudoDevDojo.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final AnimeMapper mapper;

    public List<Anime> findAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(Long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(mapper.toAnime(animePostRequestBody));
    }

    public void update(Long id, AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(id);
        Anime anime = mapper.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void updateAnime(Anime animeToBeUpdate, Anime anime) {
        animeToBeUpdate.setId(anime.getId());
        animeToBeUpdate.setName(anime.getName());
    }
}
