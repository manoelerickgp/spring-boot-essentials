package com.estudo.SpringEstudoDevDojo.repository;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
