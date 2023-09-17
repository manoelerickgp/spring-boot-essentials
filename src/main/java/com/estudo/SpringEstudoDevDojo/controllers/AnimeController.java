package com.estudo.SpringEstudoDevDojo.controllers;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import com.estudo.SpringEstudoDevDojo.request.AnimePostRequestBody;
import com.estudo.SpringEstudoDevDojo.request.AnimePutRequestBody;
import com.estudo.SpringEstudoDevDojo.service.AnimeService;
import com.estudo.SpringEstudoDevDojo.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Anime> insert(@RequestBody AnimePostRequestBody animePostRequestBody) {
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
        /*Long id = anime.getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anime.getId()).toUri();
        return ResponseEntity.created(uri).body(id);*/
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Anime> update(@PathVariable Long id,@Validated @RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.update(id, animePutRequestBody);
        return ResponseEntity.ok().body(new Anime(id, animePutRequestBody.getName()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
