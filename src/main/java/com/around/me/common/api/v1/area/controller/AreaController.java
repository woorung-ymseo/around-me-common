package com.around.me.common.api.v1.area.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.around.me.common.api.v1.area.service.AreaService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Area;
import com.around.me.common.core.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Area 관련 API Controller
 */
@Api(tags = "지역")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class AreaController {

	private final AreaService areaService;
	
	/**
     * 지역 리스트 조회
     * @return Response<List<Area>>
     */
    @ApiOperation(value = "지역 리스트 조회")
    @GetMapping(value = "/areas")
    Response<List<Area>> getAreas() {

        List<Area> areas = areaService.getAreas();

        return Response.ok(areas);
    }
}
