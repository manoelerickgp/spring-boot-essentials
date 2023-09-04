package com.estudo.SpringEstudoDevDojo.controllers;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import com.estudo.SpringEstudoDevDojo.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    
    private final DateUtil dateUtil;

    @GetMapping(path = "/list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Naruto"), new Anime("One Punch Man2"));
    }
}
