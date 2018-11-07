package com.hb.web.service;

import java.util.Map;
import com.hb.web.bean.Pagination;
import com.hb.web.bean.PrizesAddress;

public interface PrizesAddressService {
	
	public Pagination<Map<String, String>> findPrizesAddress(PrizesAddress prizesAddress);
	
}
