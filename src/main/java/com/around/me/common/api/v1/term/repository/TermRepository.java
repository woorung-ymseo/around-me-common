package com.around.me.common.api.v1.term.repository;

import com.around.me.common.core.domain.Term;
import com.around.me.common.core.enums.common.YnEnum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface TermRepository extends JpaRepository<Term, Long> {

	/**
	 * 약관 리스트 조회
	 * @param YnEnum displayYn
	 * @return Optional<List<Term>>
	 */
	Optional<List<Term>> findAllByDisplayYn(YnEnum displayYn);

	/**
	 * 약관 내용 조회
	 * @param long termNo
	 * @return Optional<Term>
	 */
    Optional<Term> findByTermNo(long termNo);
}


