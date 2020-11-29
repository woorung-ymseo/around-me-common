package com.around.me.common.api.v1.term.controller;

import com.around.me.common.api.v1.term.service.TermService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
     * 약관 리스트 조회
     * @return Response<List<Term>>
     */
    @ApiOperation(value = "약관 리스트 조회")
    @GetMapping(value = "/terms")
    Response<List<Term>> termInfoTest() {

        List<Term> term = termService.getTermInfo();

        return Response.ok(term);
    }

    /**
     * 약관 내용 조회
     * @param termNo
     * @return Response<Term>
     */
    @ApiOperation(value = "약관 내용 조회")
    @GetMapping(value = "/term/{termNo}")
    Response<Term> termContentTest(@ApiParam(value = "약관 번호", required = true, example = "1") @PathVariable long termNo) {

        Term term = termService.getTermContent(termNo);

        return Response.ok(term);
    }
}
