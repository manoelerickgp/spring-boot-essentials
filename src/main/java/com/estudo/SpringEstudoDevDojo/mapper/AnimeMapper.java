package com.estudo.SpringEstudoDevDojo.mapper;

import com.estudo.SpringEstudoDevDojo.domain.Anime;
import com.estudo.SpringEstudoDevDojo.request.AnimePostRequestBody;
import com.estudo.SpringEstudoDevDojo.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
