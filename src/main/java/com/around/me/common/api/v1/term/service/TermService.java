package com.around.me.common.api.v1.term.service;

import com.around.me.common.api.v1.term.repository.TermRepository;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TermService {

    private final TermRepository termRepository;

    /**
     * 약관 리스트 조회
     * @return List<Term>
     */
    public List<Term> getTermInfo() {
    	Optional<List<Term>> terms = termRepository.findAllByDisplayYn(YnEnum.Y);

        return terms.orElse(null);
    }

    /**
     * 약관 내용 조회
     * @param long termNo
     * @return Term
     */
    public Term getTermContent(long termNo) {
        Optional<Term> term = termRepository.findByTermNo(termNo);

        return term.orElse(null);
    }
}
