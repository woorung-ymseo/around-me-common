package com.around.me.common.api.v1.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.around.me.common.api.v1.code.dto.PatchCodeParamDTO;
import com.around.me.common.api.v1.code.dto.PatchGroupcodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostCodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostGroupcodeParamDTO;
import com.around.me.common.api.v1.code.service.CodeService;
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
     * 공통그룹코드 생성
     * @param PostGroupcodeParamDTO dto
     * @return Response<Groupcode>
     */
    @ApiOperation(value = "공통그룹코드 생성")
    @PostMapping(value = "/groupcode")
	Response<Groupcode> postGroupcode(@RequestBody PostGroupcodeParamDTO dto) {

        Groupcode result = codeService.postGroupcode(dto);

        if(result==null) {
        	return Response.badRequest(null);
    	}else {
    		return Response.ok(result);
    	}
    }
    /**
     * 공통그룹코드 수정
     * @param long groupcodeNo, PatchGroupcodeParamDTO dto
     * @return Response<Long>
     */
    @ApiOperation(value = "공통그룹코드 수정")
    @PatchMapping(value = "/groupcode/{groupcodeNo}")
    Response<Long> patchGroupcode(@ApiParam(value = "공통그룹코드 번호", required = true, example = "1") @PathVariable long groupcodeNo, @RequestBody PatchGroupcodeParamDTO dto) {
    	
    	Groupcode result = codeService.patchGroupcode(groupcodeNo, dto);
    	
    	if(result==null) {
    		return Response.badRequest(null);
    	}else {
    		return Response.ok(result.getCommonGroupCodeNo());
    	}
    }
    
    /**
     * 공통그룹코드 삭제
     * @param long groupcodeNo
     * @return Response<Long>
     */
    @ApiOperation(value = "공통그룹코드 삭제")
    @DeleteMapping(value = "/groupcode/{groupcodeNo}")
    Response<Long> deleteGroupcode(@ApiParam(value = "공통그룹코드 번호", required = true, example = "1") @PathVariable long groupcodeNo) {

    	Groupcode result = codeService.deleteGroupcode(groupcodeNo);
    	
    	if(result==null) {
    		return Response.badRequest(null);
    	}else {
    		return Response.ok(result.getCommonGroupCodeNo());
    	}
    }
    
    /**
     * 공통코드 리스트 조회
     * @param String groupcode
     * @return Response<List<Code>>
     */
    @ApiOperation(value = "공통코드 리스트 조회")
    @GetMapping(value = "/codes/{groupcode}")
    Response<List<Code>> getCodes(@ApiParam(value="공통그룹코드", required=true) @PathVariable String groupcode) {

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
    
    /**
     * 공통코드 생성
     * @param PostCodeParamDTO dto
     * @return Response<Code>
     */
    @ApiOperation(value = "공통코드 생성")
    @PostMapping(value = "/code")
	Response<Code> postCode(@RequestBody PostCodeParamDTO dto) {

        Code result = codeService.postCode(dto);

        if(result==null) {
        	return Response.badRequest(null);
    	}else {
    		return Response.ok(result);
    	}
    }
    /**
     * 공통코드 수정
     * @param long codeNo, PatchCodeParamDTO dto
     * @return Response<Long>
     */
    @ApiOperation(value = "공통코드 수정")
    @PatchMapping(value = "/code/{codeNo}")
    Response<Long> patchCode(@ApiParam(value = "공통코드 번호", required = true, example = "1") @PathVariable long codeNo, @RequestBody PatchCodeParamDTO dto) {
 
    	Code result = codeService.patchCode(codeNo, dto);
    	
    	if(result==null) {
    		return Response.badRequest(null);
    	}else {
    		return Response.ok(result.getCommonCodeNo());
    	}
    }
    
    /**
     * 공통코드 삭제
     * @param long codeNo
     * @return Response<Long>
     */
    @ApiOperation(value = "공통코드 삭제")
    @DeleteMapping(value = "/code/{codeNo}")
    Response<Long> deleteCode(@ApiParam(value = "공통코드 번호", required = true, example = "1") @PathVariable long codeNo) {

    	Code result = codeService.deleteCode(codeNo);
    	
    	if(result==null) {
    		return Response.badRequest(null);
    	}else {
    		return Response.ok(result.getCommonCodeNo());
    	}
    }
}
