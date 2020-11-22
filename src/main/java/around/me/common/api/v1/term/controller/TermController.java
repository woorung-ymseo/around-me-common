package around.me.common.api.v1.term.controller;

import around.me.common.api.v1.term.service.TermService;
import around.me.common.core.annoitation.version.RestMappingV1;
import around.me.common.core.domain.Term;
import around.me.common.core.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * User 관련 API Controller
 */
@Api(tags = "약")
@Slf4j
@RequiredArgsConstructor
@RestMappingV1
public class TermController {

    private final TermService termService;

    @ApiOperation(value = "약관정 조회 test")
    @GetMapping(value = "/term")
    Response<String> termInfoTest(/*@RequestHeader(name = "Authorization", required = true) String authorization,*/
                              /*@ApiIgnore Errors errors*/) {

//        Term term = termService.findUserId();

        return Response.ok("AAA");
    }
}
