package com.hb.web.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.hb.web.bean.PrizesAddress;

@Mapper
@Repository
public interface PrizesAddressDao {
	
	public List<Map<String, String>> findPrizesAddress(@Param("prizes") PrizesAddress prizes);
	
}
