package com.around.me.common.core.domain;

import com.around.me.common.api.v1.term.dto.PatchTermParamDTO;
import com.around.me.common.api.v1.term.dto.PostTermParamDTO;
import com.around.me.common.core.enums.common.YnEnum;
import com.around.me.common.core.enums.term.TermTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

	public void create(PostTermParamDTO dto) {
		this.termName = dto.getTermName();
	    this.termType = dto.getTermType();
	    this.termContent = dto.getTermContent();
	    this.displayYn = dto.getDisplayYn();
	    this.requiredAgreeYn = dto.getRequiredAgreeYn();
	    this.displayDate = dto.getDisplayDate();
	    this.useYn = dto.getUseYn();
	}
	
	public void update(PatchTermParamDTO dto) {
		this.termName = dto.getTermName();
	    this.termType = dto.getTermType();
	    this.termContent = dto.getTermContent();
	    this.displayYn = dto.getDisplayYn();
	    this.requiredAgreeYn = dto.getRequiredAgreeYn();
	    this.displayDate = dto.getDisplayDate();
	    this.useYn = dto.getUseYn();
	}
}
