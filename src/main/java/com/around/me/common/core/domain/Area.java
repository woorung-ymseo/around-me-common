package com.around.me.common.core.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Table
@Entity
@Getter
public class Area {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="지역번호")
	private long area_no;
	
	@ApiModelProperty(value="깊이")
	private String depth;
	
	@ApiModelProperty(value="시군구코드")
	private String sigungu_code;
	
	@ApiModelProperty(value="도로명코드")
	private String road_code;
	
	@ApiModelProperty(value="도로명")
	private String road_name;
	
	@ApiModelProperty(value="읍면동일련번호")
	private String dong_serial_no;
	
	@ApiModelProperty(value="시도명")
	private String sido_name;
	
	@ApiModelProperty(value="시군구명")
	private String sigungu_name;
	
	@ApiModelProperty(value="읍면동구분")
	private String dong_sort;
	
	@ApiModelProperty(value="읍면동코드")
	private String dong_code;

	@ApiModelProperty(value="읍면동명")
	private String dong_name;
	
	@ApiModelProperty(value="상위도로코드")
	private String upper_road_code;
	
	@ApiModelProperty(value="상위도로명")
	private String upper_road_name;
}
