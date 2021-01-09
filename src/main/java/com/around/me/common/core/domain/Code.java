package com.around.me.common.core.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.around.me.common.api.v1.code.dto.PatchCodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostCodeParamDTO;
import com.around.me.common.core.enums.common.YnEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Table(name = "common_code")
@Entity
@Getter
public class Code {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="공통코드번호")
	private long commonCodeNo;
	
	//@ApiModelProperty(value="공통그룹코드")
	//private String commonGroupCode;
	
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
	
	@ApiModelProperty(value="등록일시")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul") 
	private LocalDateTime regDatetime;
	
	@ApiModelProperty(value="수정일시")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul") 
	private LocalDateTime modDatetime;
	
	@ApiModelProperty(value="등록자")
	private long regUserNo;
	
	@ApiModelProperty(value="수정자")
	private long modUserNo;
	
	@ManyToOne
    @JoinColumn(name="common_group_code")
	private Groupcode commonGroupCode;
	
	public void post(PostCodeParamDTO dto) {
		//this.commonGroupCode = dto.getCommonGroupCode();
	    this.commonCode = dto.getCommonCode();
	    this.commonCodeName = dto.getCommonCodeName();
	    this.useYn = dto.getUseYn();
	    this.orderNo = dto.getOrderNo();
	    this.description = dto.getDescription();
	    this.filter1 = dto.getFilter1();
	    this.filter2 = dto.getFilter2();
	    this.filter3 = dto.getFilter3();
	    this.regDatetime = LocalDateTime.now();
	    this.regUserNo = 1L;//수정
	}
	
	public void update(PatchCodeParamDTO dto) {
		//if(this.commonGroupCode != dto.getCommonGroupCode()) {
		//	this.commonGroupCode = dto.getCommonGroupCode();
		//}
		if(!StringUtils.equals(this.commonCode, dto.getCommonCode())) {
			this.commonCode = dto.getCommonCode();
		}
		if(!StringUtils.equals(this.commonCodeName, dto.getCommonCodeName())){
			this.commonCodeName = dto.getCommonCodeName();
		}
		if(this.useYn != dto.getUseYn()) {
			this.useYn = dto.getUseYn();
		}
		if(this.useYn != dto.getUseYn()) {
			this.useYn = dto.getUseYn();
		}
		if(this.orderNo != dto.getOrderNo()){
			this.orderNo = dto.getOrderNo();
		}
	    if(!StringUtils.equals(this.description, dto.getDescription())){
			this.description = dto.getDescription();
		}
	    if(!StringUtils.equals(this.filter1, dto.getFilter1())){
			this.filter1 = dto.getFilter1();
		}
	    if(!StringUtils.equals(this.filter2, dto.getFilter2())){
			this.filter2 = dto.getFilter2();
		}
	    if(!StringUtils.equals(this.filter3, dto.getFilter3())){
			this.filter3 = dto.getFilter3();
		}
		this.modDatetime = LocalDateTime.now();
	    this.modUserNo = 1L;//수정
	}
	
	public Code delete() {
		this.useYn = YnEnum.N;
		
		return this;
	}
}
