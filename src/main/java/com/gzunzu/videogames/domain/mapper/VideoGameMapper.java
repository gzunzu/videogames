package com.gzunzu.videogames.domain.mapper;

import com.gzunzu.common.domain.mapper.ModelMapper;
import com.gzunzu.videogames.domain.dto.VideoGameDTO;
import com.gzunzu.videogames.domain.model.VideoGame;

public interface VideoGameMapper extends ModelMapper<VideoGame, VideoGameDTO> {

    @Override
    VideoGameDTO toDto(VideoGame videoGame);

    @Override
    VideoGame fromDto(VideoGameDTO videoGameDTO);
}
