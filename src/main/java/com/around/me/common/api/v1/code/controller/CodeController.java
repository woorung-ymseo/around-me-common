package com.around.me.common.api.v1.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.around.me.common.api.v1.code.service.CodeService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Code;
import com.around.me.common.core.domain.Groupcode;
import com.around.me.common.core.dto.Response;
import com.around.me.common.core.enums.code.GroupcodeTypeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Code 관련 API Controller
 */
@Api(tags = "공통코드")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class CodeController {
	
	private final CodeService codeService;

	/**
     * 공통그룹코드 리스트 조회
     * @return Response<List<Groupcode>>
     */
    @ApiOperation(value = "공통그룹코드 리스트 조회")
    @GetMapping(value = "/groupcodes")
    Response<List<Groupcode>> getGroupcodes() {

        List<Groupcode> groupcodes = codeService.getGroupcodes();

        return Response.ok(groupcodes);
    }
    
    /**
     * 공통코드 리스트 조회
     * @param GroupcodeTypeEnum groupcode
     * @return Response<List<Code>>
     */
    @ApiOperation(value = "공통코드 리스트 조회")
    @GetMapping(value = "/codes/{groupcode}")
    Response<List<Code>> getCodes(@ApiParam(value="공통그룹코드", required=true) @PathVariable GroupcodeTypeEnum groupcode) {

        List<Code> codes = codeService.getCodes(groupcode);

        return Response.ok(codes);
    }
    
    /**
     * 공통코드 조회
     * @param long codeNo
     * @return Response<Code>
     */
    @ApiOperation(value = "공통코드 조회")
    @GetMapping(value = "/code/{codeNo}")
    Response<Code> getCode(@ApiParam(value="공통코드번호", required=true) @PathVariable long codeNo) {

        Code code = codeService.getCode(codeNo);

        return Response.ok(code);
    }
}
