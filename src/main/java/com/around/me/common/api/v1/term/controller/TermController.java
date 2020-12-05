package com.around.me.common.api.v1.term.controller;

import com.around.me.common.api.v1.term.dto.PatchTermParamDTO;
import com.around.me.common.api.v1.term.dto.PostTermParamDTO;
import com.around.me.common.api.v1.term.service.TermService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Term 관련 API Controller
 */
@Api(tags = "약관")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class TermController {

    private final TermService termService;

    /**
     * 약관 생성
     * @return Response<Term>
     */
    @ApiOperation(value = "약관 생성")
    @PostMapping(value = "/term")
    Response<Term> postTerm(@RequestBody PostTermParamDTO dto) {

        Term result = termService.postTerm(dto);

        if(result==null) {
        	return Response.badRequest(null);
    	}else {
    		return Response.ok(result);
    	}
    }
    
    /**
     * 약관 수정
     * @return Response<Term>
     */
    @ApiOperation(value = "약관 수정")
    @PatchMapping(value = "/term/{termNo}")
    Response<Long> patchTerm(@ApiParam(value = "약관 번호", required = true, example = "1") @PathVariable long termNo, @RequestBody PatchTermParamDTO dto) {
    	
    	Term result = termService.patchTerm(termNo, dto);
    	if(result==null) {
    		return Response.badRequest(null);
    	}else {
    		return Response.ok(result.getTermNo());
    	}
    }
    
    /**
     * 약관 삭제
     * @return Response<Term>
     */
    @ApiOperation(value = "약관 삭제")
    @DeleteMapping(value = "/term/{termNo}")
    Response<Long> deleteTerm(@ApiParam(value = "약관 번호", required = true, example = "1") @PathVariable long termNo) {

    	int result = termService.deleteTerm(termNo);
    	if(result>0) {
    		return Response.ok(termNo);
    	}else {
    		return Response.badRequest(termNo);
    	}
    }
    
    /**
     * 약관 리스트 조회
     * @return Response<List<Term>>
     */
    @ApiOperation(value = "약관 리스트 조회")
    @GetMapping(value = "/terms")
    Response<List<Term>> getTerms() {

        List<Term> term = termService.getTerms();

        return Response.ok(term);
    }
    
    /**
     * 약관 내용 조회
     * @param termNo
     * @return Response<Term>
     */
    @ApiOperation(value = "약관 내용 조회")
    @GetMapping(value = "/term/{termNo}")
    Response<Term> getTerm(@ApiParam(value = "약관 번호", required = true, example = "1") @PathVariable long termNo) {

        Term term = termService.getTerm(termNo);

        return Response.ok(term);
    }
}
