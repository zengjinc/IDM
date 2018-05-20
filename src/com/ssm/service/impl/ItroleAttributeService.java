package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.ItroleAttributeMapper;
import com.ssm.pojo.ItroleAttributeExample;
import com.ssm.service.IItroleAttributeService;

@Service
public class ItroleAttributeService implements IItroleAttributeService {

	@Autowired
	private ItroleAttributeMapper itroleAttrMapper;
	
	@Override
	public boolean deleteByItroleUuid(String itroleUuid) throws Exception {
		
		ItroleAttributeExample example = new ItroleAttributeExample();
		
		example.createCriteria().andItroleAttrItroleUuidEqualTo(itroleUuid);
		
		if(itroleAttrMapper.deleteByExample(example) > 0){
			return true;
		}
		
		return false;
	}

}
