package com.around.me.common.api.v1.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.around.me.common.api.v1.code.service.CodeService;
import com.around.me.common.api.v1.term.controller.TermController;
import com.around.me.common.api.v1.term.service.TermService;
import com.around.me.common.core.annoitation.version.RestMappingV1;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Code 관련 API Controller
 */
@Api(tags = "코드")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class CodeController {
	
	private final CodeService codeService;
	
	/**
     * 공통코드 그룹 목록 조회
     * @return Response<List<Code>>
     */
    @ApiOperation(value = "약관 리스트 조회")
    @GetMapping(value = "/terms")
    Response<List<GroupCode>> getCodeGroups() {

        List<GroupCode> groupCodes = code.getGroupCodes();

        return Response.ok(groupCodes);
    }
}
