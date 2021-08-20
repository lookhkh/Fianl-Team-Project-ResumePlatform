package com.green.chodoori.repository.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface SampleMapper {

	@Select("select sysdate from dual")
	public String getTime();
}
