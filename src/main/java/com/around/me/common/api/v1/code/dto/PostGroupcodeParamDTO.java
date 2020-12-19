package com.around.me.common.api.v1.code.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PostGroupcodeParamDTO {
	
	@ApiModelProperty(value="공통그룹코드")
	private String commonGroupCode;
	
	@ApiModelProperty(value="공통그룹코드명")
	private String commonGroupName;
	
	@ApiModelProperty(value="사용여부")
	@Enumerated(EnumType.STRING)
	private YnEnum useYn;
	
	@ApiModelProperty(value="정렬번호")
	private long orderNo;
	
	@ApiModelProperty(value="설명")
	private String description;
	
}
