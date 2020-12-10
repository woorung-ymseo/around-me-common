package com.around.me.common.api.v1.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.around.me.common.api.v1.code.repository.CodeRepository;
import com.around.me.common.core.domain.Code;
import com.around.me.common.core.enums.code.GroupCodeTypeEnum;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeService {
	
	private final CodeRepository codeRepository;

    /**
     * 공통코드 리스트 조회
     * @param GroupCodeTypeEnum groupcode
     * @return List<Code>
     */
    public List<Code> getCodes(GroupCodeTypeEnum groupcode) {
    	
        Optional<List<Code>> codes = codeRepository.findByUseYnAndCommonGroupCode(YnEnum.Y,groupcode);

        return codes.orElse(null);
    }
    
    /**
     * 공통코드 조회
     * @param String codeNo
     * @return Code
     */
    public Code getCode(long codeNo) {
    	
        Optional<Code> code = codeRepository.findByUseYnAndCommonCodeNo(YnEnum.Y,codeNo);

        return code.orElse(null);
    }
}
