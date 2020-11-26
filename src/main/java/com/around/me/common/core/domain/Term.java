package com.around.me.common.core.domain;

import com.around.me.common.core.enums.common.YnEnum;
import com.around.me.common.core.enums.term.TermTypeEnum;
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
    @GeneratedValue
    @Setter
    private long termNo;

    @Setter
    private String termName;

    @Enumerated(EnumType.STRING)
    private TermTypeEnum termType;

    private String termContent;

    @Enumerated(EnumType.STRING)
    private YnEnum displayYn;

    @Enumerated(EnumType.STRING)
    private YnEnum requiredAgreeYn;

    private LocalDate displayDate;

    @Enumerated(EnumType.STRING)
    private YnEnum userYn;

    private LocalDateTime regDatetime;

    private LocalDateTime modDatetime;

    private Long regUserNo;

    private Long modUserNo;
}
