package com.around.me.common.api.v1.code.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class PostCodeParamDTO {
	
	@ApiModelProperty(value="공통그룹코드")
	@NotNull(message = "공통그룹코드는 필수 값 입니다.")
	private String commonGroupCode;
	
	@ApiModelProperty(value="공통코드")
	@NotNull(message = "공통코드는 필수 값 입니다.")
	private String commonCode;
	
	@ApiModelProperty(value="공통코드명")
	@NotNull(message = "공통코드명은 필수 값 입니다.")
	private String commonCodeName;
	
	@ApiModelProperty(value="사용여부")
	@NotNull(message = "사용여부는 필수 값 입니다.")
	@Enumerated(EnumType.STRING)
	private YnEnum useYn;
	
	@ApiModelProperty(value="정렬번호")
	@NotNull(message = "정렬번호는 필수 값 입니다.")
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
