package com.around.me.common.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.around.me.common.api.v1.code.dto.PatchGroupcodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostGroupcodeParamDTO;
import com.around.me.common.core.enums.common.YnEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Table(name = "common_group_code")
@Entity
@Getter
public class Groupcode {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="공통그룹코드번호")
	private long commonGroupCodeNo;
	
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
	
	@OneToMany(mappedBy = "commonGroupCode")
	private List<Code> codes = new ArrayList<>();
	
	public void post(PostGroupcodeParamDTO dto) {
		this.commonGroupCode = dto.getCommonGroupCode();
	    this.commonGroupName = dto.getCommonGroupName();
	    this.useYn = dto.getUseYn();
	    this.orderNo = dto.getOrderNo();
	    this.description = dto.getDescription();
	    this.regDatetime = LocalDateTime.now();
	    this.regUserNo = 1L;//수정
	}
	
	public void update(PatchGroupcodeParamDTO dto) {
		if(this.commonGroupCode != dto.getCommonGroupCode()){
			this.commonGroupCode = dto.getCommonGroupCode();
		}
		if(this.commonGroupName != dto.getCommonGroupName()){
			this.commonGroupName = dto.getCommonGroupName();
		}
		if(this.useYn != dto.getUseYn()){
			this.useYn = dto.getUseYn();
		}
		if(this.orderNo != dto.getOrderNo()){
			this.orderNo = dto.getOrderNo();
		}
		if(this.description != dto.getDescription()){
			this.description = dto.getDescription();
		}
		this.modDatetime = LocalDateTime.now();
	    this.modUserNo = 1L;//수정
	}
	
	public List<Code> delete() {
		this.useYn = YnEnum.N;
		
		return this.codes;
	}
}
