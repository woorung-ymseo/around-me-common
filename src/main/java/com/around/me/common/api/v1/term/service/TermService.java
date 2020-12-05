package com.around.me.common.api.v1.term.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.around.me.common.api.v1.term.repository.TermRepository;
import com.around.me.common.core.domain.Term;
import com.around.me.common.core.dto.TermDTO;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TermService {

    private final TermRepository termRepository;

    /**
     * 약관 생성
     * @return integer
     */
    @Transactional
    public Integer postTermInfo(TermDTO.PostTermDTO termDTO) {
    	
    	Optional<Integer> result = termRepository.save(termDTO);

        return result.orElse(null);
    }
    
    /**
     * 약관 수정 
     * @return integer
     */
    @Transactional
    public Integer patchTermInfo(long termNo, TermDTO.PatchTermDTO termDTO) {
    		
    	Optional<Integer> result = termRepository.save(termDTO);

        return result.orElse(null);
    }
    
    /**
     * 약관 삭제 
     * @return integer
     */
    @Transactional
    public Integer deleteTermInfo(long termNo) {
    	
    	Optional<Integer> result = termRepository.deleteById(termNo);

        return result.orElse(null);
    }
    
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
