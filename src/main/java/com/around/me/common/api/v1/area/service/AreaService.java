package com.around.me.common.api.v1.area.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.around.me.common.api.v1.area.repository.AreaRepository;
import com.around.me.common.core.domain.Area;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AreaService {

	private final AreaRepository areaRepository;
	
	/**
     * 지역 리스트 조회
     * @return List<Area>
     */
    public List<Area> getAreas() {
    	
    	Optional<List<Area>> areas = Optional.ofNullable(areaRepository.findAll());

        return areas.orElse(null);
    }
}
