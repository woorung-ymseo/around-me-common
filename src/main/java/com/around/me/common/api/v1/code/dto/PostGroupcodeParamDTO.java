package com.around.me.common.api.v1.code.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PostGroupcodeParamDTO {
	
	@ApiModelProperty(value="공통그룹코드")
	@NotNull(message = "공통그룹코드는 필수 값 입니다.")
	private String commonGroupCode;
	
	@ApiModelProperty(value="공통그룹코드명")
	@NotNull(message = "공통그룹코드명은 필수 값 입니다.")
	private String commonGroupName;
	
	@ApiModelProperty(value="사용여부")
	@NotNull(message = "사용여부는 필수 값 입니다.")
	@Enumerated(EnumType.STRING)
	private YnEnum useYn;
	
	@ApiModelProperty(value="정렬번호")
	@NotNull(message = "정렬번호는 필수 값 입니다.")
	private long orderNo;
	
	@ApiModelProperty(value="설명")
	private String description;
	
}
