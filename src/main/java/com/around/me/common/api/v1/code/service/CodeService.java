package com.around.me.common.api.v1.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.around.me.common.api.v1.code.repository.CodeRepository;
import com.around.me.common.api.v1.code.repository.GroupcodeRepository;
import com.around.me.common.api.v1.code.dto.PatchCodeParamDTO;
import com.around.me.common.api.v1.code.dto.PatchGroupcodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostCodeParamDTO;
import com.around.me.common.api.v1.code.dto.PostGroupcodeParamDTO;
import com.around.me.common.core.domain.Code;
import com.around.me.common.core.domain.Groupcode;
import com.around.me.common.core.enums.common.YnEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CodeService {
	
	private final CodeRepository codeRepository;
	
	private final GroupcodeRepository groupcodeRepository;

	/**
     * 공통그룹코드 리스트 조회
     * @return List<Groupcode>
     */
    public List<Groupcode> getGroupcodes() {
    	
    	Optional<List<Groupcode>> groupcodes = groupcodeRepository.findAllByUseYn(YnEnum.Y);

        return groupcodes.orElse(null);
    }
    
    /**
     * 공통그룹코드 생성
     * @param PostGroupcodeParamDTO dto
     * @return Groupcode
     */
    @Transactional
    public Groupcode postGroupcode(PostGroupcodeParamDTO dto) {
    	Assert.notNull(dto, "잘못된 요청입니다.");
    	 
    	Groupcode groupcode = new Groupcode();
    	groupcode.post(dto);
    	
    	Groupcode result = groupcodeRepository.save(groupcode);
    	
    	Assert.notNull(result, "잘못된 요청입니다.");

        return result;
    }
    
    /**
     * 공통그룹코드 수정
     * @param long groupcodeNo, PatchGroupcodeParamDTO dto
     * @return Groupcode
     */
    @Transactional
    public Groupcode patchGroupcode(long groupcodeNo, PatchGroupcodeParamDTO dto) {
    	Assert.notNull(dto, "잘못된 요청입니다.");
        Assert.isTrue(groupcodeNo == 0, "잘못된 요청입니다.");
        
    	Optional<Groupcode> groupcode = groupcodeRepository.findByCommonGroupCodeNo(groupcodeNo);
    	groupcode.get().update(dto);

    	Groupcode result = groupcodeRepository.save(groupcode.get());

    	return result;
    }
    
    /**
     * 공통그룹코드 삭제 
     * @param long groupcodeNo
     * @return Groupcode
     */
    @Transactional
    public Groupcode deleteGroupcode(long groupcodeNo) {
    	Assert.isTrue(groupcodeNo == 0, "잘못된 요청입니다.");

    	Optional<Groupcode> groupcode = groupcodeRepository.findByCommonGroupCodeNo(groupcodeNo);
    	List<Code> codes = groupcode.get().delete();

    	for(Code code:codes) {
    		codeRepository.save(code.delete());
    	}
    	Groupcode result = groupcodeRepository.save(groupcode.get());

        return result;
    }
    
    /**
     * 공통코드 리스트 조회
     * @param String groupcode
     * @return List<Code>
     */
    public List<Code> getCodes(String groupcode) {
    	
        Optional<List<Code>> codes = codeRepository.findByUseYnAndCommonGroupCode(YnEnum.Y,groupcode);

        return codes.orElse(null);
    }
    
    /**
     * 공통코드 조회
     * @param String codeNo
     * @return Code
     */
    public Code getCode(long codeNo) {
    	Assert.isTrue(codeNo == 0, "잘못된 요청입니다.");
    	
        Optional<Code> code = codeRepository.findByUseYnAndCommonCodeNo(YnEnum.Y,codeNo);

        return code.orElse(null);
    }
    
    /**
     * 공통코드 생성
     * @param PostCodeParamDTO dto
     * @return Code
     */
    @Transactional
    public Code postCode(PostCodeParamDTO dto) {
    	Assert.notNull(dto, "잘못된 요청입니다.");
    	
    	Code code = new Code();
    	code.post(dto);
    	
    	Code result = codeRepository.save(code);

    	Assert.notNull(result, "잘못된 요청입니다.");
    	
        return result;
    }
    
    /**
     * 공통코드 수정
     * @param long codeNo, PatchCodeParamDTO dto
     * @return Code
     */
    @Transactional
    public Code patchCode(long codeNo, PatchCodeParamDTO dto) {
    	Assert.notNull(dto, "잘못된 요청입니다.");
        Assert.isTrue(codeNo == 0, "잘못된 요청입니다.");
        
    	Optional<Code> code = codeRepository.findByCommonCodeNo(codeNo);
    	code.get().update(dto);

    	Code result = codeRepository.save(code.get());

    	return result;
    }
    
    /**
     * 공통코드 삭제 
     * @param long codeNo
     * @return Code
     */
    @Transactional
    public Code deleteCode(long codeNo) {
    	Assert.isTrue(codeNo == 0, "잘못된 요청입니다.");
    	
    	Optional<Code> code = codeRepository.findByCommonCodeNo(codeNo);
    	code.get().delete();

    	Code result = codeRepository.save(code.get());

    	return result;
    }
}
