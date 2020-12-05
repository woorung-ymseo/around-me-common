package com.around.me.common.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.around.me.common.core.enums.common.YnEnum;
import com.around.me.common.core.enums.term.TermTypeEnum;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TermDTO {
	
	public static class PostTermDTO {
		String termName;
	    TermTypeEnum termType;
	    String termContent;
	    YnEnum displayYn;
	    YnEnum requiredAgreeYn;
	    LocalDate displayDate;
	    YnEnum useYn;
	    LocalDateTime regDatetime;
	    Long regUserNo;
	}
	
	public static class PatchTermDTO {
		Long termNo;
	    String termName;
	    TermTypeEnum termType;
	    String termContent;
	    YnEnum displayYn;
	    YnEnum requiredAgreeYn;
	    LocalDate displayDate;
	    YnEnum useYn;
	    LocalDateTime modDatetime;
	    Long modUserNo;
	}
	
}
