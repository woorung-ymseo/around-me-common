package com.around.me.common.api.v1.term.service;

import java.util.List;
import java.util.Optional;

import com.around.me.common.api.v1.code.service.CodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.around.me.common.api.v1.term.dto.PatchTermParamDTO;
import com.around.me.common.api.v1.term.dto.PostTermParamDTO;
import com.around.me.common.api.v1.term.repository.TermRepository;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class TermService {

    private final TermRepository termRepository;

    /**
     * 약관 생성
     * @param PostTermParamDTO dto
     * @return Term
     */
    @Transactional
    public Term postTerm(PostTermParamDTO dto) {
        Assert.notNull(dto, "잘못된 요청입니다.");

        Term term = new Term();
        term.post(dto);

        Term result = termRepository.save(term);

        Assert.notNull(result, "잘못된 요청입니다.");

        return result;
    }

    /**
     * 약관 수정
     * @param long termNo, PatchTermParamDTO dto
     * @return Term
     */
    @Transactional
    public Term patchTerm(long termNo, PatchTermParamDTO dto) {
        Assert.notNull(dto, "잘못된 요청입니다.");
        Assert.isTrue(termNo == 0, "잘못된 요청입니다.");

        Optional<Term> term = termRepository.findByTermNo(termNo);

        term.get().update(dto);

        Term result = termRepository.save(term.get());

        return result;
    }

    /**
     * 약관 삭제
     * @param long termNo
     * @return Term
     */
    @Transactional
    public Term deleteTerm(long termNo) {
    	Assert.isTrue(termNo == 0, "잘못된 요청입니다.");
    	
        Optional<Term> term = termRepository.findByTermNo(termNo);
        
        term.get().delete();

        Term result = termRepository.save(term.get());

        return result;
    }

    /**
     * 약관 리스트 조회
     * @return List<Term>
     */
    public List<Term> getTerms() {

        Optional<List<Term>> terms = termRepository.findAllByDisplayYnAndUseYn(YnEnum.Y,YnEnum.Y);

        return terms.orElse(null);
    }

    /**
     * 약관 내용 조회
     * @param long termNo
     * @return Term
     */
    public Term getTerm(long termNo) {
    	Assert.isTrue(termNo == 0, "잘못된 요청입니다.");
    	
        Optional<Term> term = termRepository.findByTermNo(termNo);

        return term.orElse(null);
    }
}
