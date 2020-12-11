package com.around.me.common.api.v1.code.repository;

import com.around.me.common.core.domain.Groupcode;
import com.around.me.common.core.enums.common.YnEnum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface GroupcodeRepository extends JpaRepository<Groupcode, Long> {

	/**
	 * 공통그룹코드 리스트 조회
	 * @param YnEnum useYn
	 * @return Optional<List<Groupcode>>
	 */
	Optional<List<Groupcode>> findAllByUseYn(YnEnum useYn);
	
}


