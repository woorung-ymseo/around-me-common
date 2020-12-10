package com.around.me.common.core.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.around.me.common.core.enums.code.CodeTypeEnum;
import com.around.me.common.core.enums.code.GroupCodeTypeEnum;
import com.around.me.common.core.enums.common.YnEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Table(name = "common_code")
@Entity
@Getter
public class Code {

	@Id
    @GeneratedValue
    @ApiModelProperty(value="공통코드번호")
	private long commonCodeNo;
	
	@ApiModelProperty(value="공통그룹코드")
	@Enumerated(EnumType.STRING)
	private GroupCodeTypeEnum commonGroupCode;
	
	@ApiModelProperty(value="공통코드")
	@Enumerated(EnumType.STRING)
	private CodeTypeEnum commonCode;
	
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
	
	@ApiModelProperty(value="등록일시")
	private LocalDateTime regDatetime;
	
	@ApiModelProperty(value="수정일시")
	private LocalDateTime modDatetime;
	
	@ApiModelProperty(value="등록자")
	private long regUserNo;
	
	@ApiModelProperty(value="수정자")
	private long modUserNo;
}
