package com.hb.web.service.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hb.web.bean.Pagination;
import com.hb.web.bean.PrizesAddress;
import com.hb.web.dao.PrizesAddressDao;
import com.hb.web.service.PrizesAddressService;

@Service
public class PrizesAddressServiceImpl implements PrizesAddressService{
	
	private static Logger logger = LoggerFactory.getLogger(PrizesAddressServiceImpl.class);
	
	@Autowired
	private PrizesAddressDao prizesAddressDao;
	
	@Override
	public Pagination<Map<String, String>> findPrizesAddress(PrizesAddress prizes) {
		List<Map<String, String>> prizesAddress = null;
		try {
			if(prizes.getPageNum() != null && prizes.getPageSize() != null) {
				PageHelper.startPage(prizes.getPageNum(), prizes.getPageSize());
			}
			prizesAddress = prizesAddressDao.findPrizesAddress(prizes);
		} catch (Exception e) {
			logger.info("异常信息--" + e);
			e.printStackTrace();
		}
		Pagination<Map<String, String>> page = new Pagination<Map<String, String>>();
		PageInfo pageInfo = new PageInfo(prizesAddress);
		page.setPageNum(pageInfo.getPageNum());
		page.setPageSize(pageInfo.getPageSize());
		page.setTotal(pageInfo.getTotal());
		page.setRows(prizesAddress);
		return page;
	}

}
