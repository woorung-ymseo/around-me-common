package com.around.me.common.api.v1.code.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PostCodeParamDTO {
	
	@ApiModelProperty(value="공통그룹코드")
	private String commonGroupCode;
	
	@ApiModelProperty(value="공통코드")
	private String commonCode;
	
	@ApiModelProperty(value="공통코드명")
	private String commonCodeName;
	
	@ApiModelProperty(value="사용여부")
	@Enumerated(EnumType.STRING)
	private YnEnum useYn;
	
	@ApiModelProperty(value="정렬번호")
	private int orderNo;
	
	@ApiModelProperty(value="설명")
	private String description;
	
	@ApiModelProperty(value="필터1")
	private String filter1;
	
	@ApiModelProperty(value="필터2")
	private String filter2;
	
	@ApiModelProperty(value="필터3")
	private String filter3;
	
}
