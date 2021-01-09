package com.around.me.common.api.v1.term.dto;

import java.time.LocalDate;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PostTermParamDTO {

	@ApiModelProperty(value="약관명")
	@NotNull(message = "약관명은 필수 값 입니다.")
	String termName;

	@ApiModelProperty(value="약관타입")
	@NotNull(message = "약관타입은 필수 값 입니다.")
    String termType;

	@ApiModelProperty(value="약관내용")
	@NotNull(message = "약관내용은 필수 값 입니다.")
    String termContent;
	
	@ApiModelProperty(value="전시여부")
	@NotNull(message = "전시여부는 필수 값 입니다.")
    YnEnum displayYn;
	
	@ApiModelProperty(value="필수동의여부")
	@NotNull(message = "필수동의여부는 필수 값 입니다.")
    YnEnum requiredAgreeYn;
	
	@ApiModelProperty(value="전시일자")
	LocalDate displayDate;
	
	@ApiModelProperty(value="사용여부")
	@NotNull(message = "사용여부는 필수 값 입니다.")
    YnEnum useYn;
	
}
