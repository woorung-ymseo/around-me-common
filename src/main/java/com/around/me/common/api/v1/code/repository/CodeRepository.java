package com.around.me.common.api.v1.code.repository;

import com.around.me.common.core.domain.Code;
import com.around.me.common.core.enums.code.GroupcodeTypeEnum;
import com.around.me.common.core.enums.common.YnEnum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {

	/**
	 * 공통코드 리스트 조회
	 * @param YnEnum useYn,GroupcodeTypeEnum groupCode
	 * @return Optional<List<Code>>
	 */
    Optional<List<Code>> findByUseYnAndCommonGroupCode(YnEnum useYn,GroupcodeTypeEnum groupcode);
    
    /**
	 * 공통코드 조회
	 * @param YnEnum useYn,long codeNo
	 * @return Optional<Code>
	 */
    Optional<Code> findByUseYnAndCommonCodeNo(YnEnum useYn,long codeNo);
}


