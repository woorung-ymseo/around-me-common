package com.around.me.common.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.around.me.common.core.enums.common.YnEnum;
import com.around.me.common.core.enums.term.TermTypeEnum;

import lombok.Getter;

@Table(name = "term")
@Entity
@Getter
public class CommonGroupCode {
	private long commonGroupCodeNo;
	private CodeTypeEnum commonGroupCode;
	private String commonGroupName;
	private YnEnum priuseYn;
	private long orderNo;
	private String description;
	private LocalDateTime regDatetime;
	private LocalDateTime modDatetime;
	private Long regUserNo;
	private Long modUserNo;
}
