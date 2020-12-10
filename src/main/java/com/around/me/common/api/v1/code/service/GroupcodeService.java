package com.around.me.common.api.v1.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.around.me.common.api.v1.code.repository.GroupCodeRepository;
import com.around.me.common.core.domain.Groupcode;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GroupcodeService {
	
	private final GroupCodeRepository groupCodeRepository;
	
	/**
     * 공통그룹코드 리스트 조회
     * @return List<Groupcode>
     */
    public List<Groupcode> getGroupcodes() {
    	
    	Optional<List<Groupcode>> groupcodes = groupCodeRepository.findAllByUseYn(YnEnum.Y);

        return groupcodes.orElse(null);
    }
}
