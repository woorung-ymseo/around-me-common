package com.around.me.common.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.around.me.common.api.v1.term.dto.PatchTermParamDTO;
import com.around.me.common.api.v1.term.dto.PostTermParamDTO;
import com.around.me.common.core.enums.common.YnEnum;
import com.around.me.common.core.enums.term.TermTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Table(name = "term")
@Entity
@Getter
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="약관번호")
    @Setter
    private long termNo;

    @ApiModelProperty(value="약관명")
    @Setter
    private String termName;

    @ApiModelProperty(value="약관 타입")
    @Enumerated(EnumType.STRING)
    private TermTypeEnum termType;

    @ApiModelProperty(value="약관내용")
    private String termContent;

    @ApiModelProperty(value="전시여부")
    @Enumerated(EnumType.STRING)
    private YnEnum displayYn;

    @ApiModelProperty(value="필수동의여부")
    @Enumerated(EnumType.STRING)
    private YnEnum requiredAgreeYn;

    @ApiModelProperty(value="전시일자")
    private LocalDate displayDate;

    @ApiModelProperty(value="사용여부")
    @Enumerated(EnumType.STRING)
    private YnEnum useYn;

    @ApiModelProperty(value="등록일시")
    private LocalDateTime regDatetime;

    @ApiModelProperty(value="수정일시")
    private LocalDateTime modDatetime;

    @ApiModelProperty(value="등록자")
    private Long regUserNo;

    @ApiModelProperty(value="수정자")
    private Long modUserNo;

	public void post(PostTermParamDTO dto) {
		this.termName = dto.getTermName();
	    this.termType = dto.getTermType();
	    this.termContent = dto.getTermContent();
	    this.displayYn = dto.getDisplayYn();
	    this.requiredAgreeYn = dto.getRequiredAgreeYn();
	    this.displayDate = dto.getDisplayDate();
	    this.useYn = dto.getUseYn();
	    this.regDatetime = LocalDateTime.now();
	    this.regUserNo = 1L;//수정
	}
	
	public void update(PatchTermParamDTO dto) {
		if(StringUtils.isNotBlank(dto.getTermName())){
			this.termName = dto.getTermName();
		}
		if(dto.getTermType()!=null){
			this.termType = dto.getTermType();
		}
		if(StringUtils.isNotBlank(dto.getTermContent())){
			this.termContent = dto.getTermContent();
		}
		if(dto.getDisplayYn()!=null){
			this.displayYn = dto.getDisplayYn();
		}
		if(dto.getRequiredAgreeYn()!=null){
			this.requiredAgreeYn = dto.getRequiredAgreeYn();
		}
		if(dto.getDisplayDate()!=null){
			this.displayDate = dto.getDisplayDate();
		}
		if(dto.getUseYn()!=null){
			this.useYn = dto.getUseYn();
		}
		this.modDatetime = LocalDateTime.now();
	    this.modUserNo = 1L;//수정
	}
}
