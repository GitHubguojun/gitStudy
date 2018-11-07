package com.hb.web.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hb.web.bean.Pagination;
import com.hb.web.bean.PrizesAddress;
import com.hb.web.service.PrizesAddressService;

@RestController
@RequestMapping("/prize")
public class PrizesAddressController {
	
	private static Logger logger = LoggerFactory.getLogger(PrizesAddressController.class);
	
	@Autowired
	private PrizesAddressService prizesAddressService;
	
	@RequestMapping("/address")
	public Pagination<Map<String, String>> prize(@RequestBody PrizesAddress prizesAddress){
		return prizesAddressService.findPrizesAddress(prizesAddress);
	}

}
