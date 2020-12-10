package com.around.me.common.api.v1.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.around.me.common.api.v1.code.service.CodeService;
import com.around.me.common.api.v1.code.service.GroupcodeService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Code;
import com.around.me.common.core.domain.Groupcode;
import com.around.me.common.core.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * groupode 관련 API Controller
 */
@Api(tags = "공통그룹코드")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class GroupcodeController {
	
	private final GroupcodeService groupcodeService;
	
	/**
     * 공통그룹코드 리스트 조회
     * @return Response<List<GroupCode>>
     */
    @ApiOperation(value = "공통그룹코드 리스트 조회")
    @GetMapping(value = "/groupcodes")
    Response<List<Groupcode>> getGroupcodes() {

        List<Groupcode> groupcodes = groupcodeService.getGroupcodes();

        return Response.ok(groupcodes);
    }
}
