package com.around.me.common.api.v1.code.repository;

import com.around.me.common.core.domain.Code;
import com.around.me.common.core.enums.common.YnEnum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {

	/**
	 * 공통코드 삽입, 수정
	 * @param Code code
	 * @return Code
	 */
	Code save(Code code);
	
	/**
	 * 공통코드 삭제
	 * @param long codeNo
	 * @return Optional<Integer>
	 */
	Optional<Integer> deleteByCommonCodeNo(long codeNo);
	
	/**
	 * 공통코드 리스트 조회
	 * @param YnEnum useYn,String groupCode
	 * @return Optional<List<Code>>
	 */
    Optional<List<Code>> findByUseYnAndCommonGroupCode(YnEnum useYn,String groupcode);
    
    /**
	 * 공통코드 조회
	 * @param long codeNo
	 * @return Optional<Code>
	 */
    Optional<Code> findByCommonCodeNo(long codeNo);
    
    /**
	 * 공통코드 조회
	 * @param YnEnum useYn,long codeNo
	 * @return Optional<Code>
	 */
    Optional<Code> findByUseYnAndCommonCodeNo(YnEnum useYn,long codeNo);
}
