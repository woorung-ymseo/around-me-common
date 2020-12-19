package com.around.me.common.api.v1.term.dto;

import java.time.LocalDate;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PatchTermParamDTO {
	@ApiModelProperty(value="약관명")
    String termName;
	
	@ApiModelProperty(value="약관타입")
    String termType;
	
	@ApiModelProperty(value="약관내용")
    String termContent;
	
	@ApiModelProperty(value="전시여부")
    YnEnum displayYn;
	
	@ApiModelProperty(value="필수동의여부")
    YnEnum requiredAgreeYn;
	
	@ApiModelProperty(value="전시일자")
	LocalDate displayDate;
	
	@ApiModelProperty(value="사용여부")
    YnEnum useYn;
    
}
