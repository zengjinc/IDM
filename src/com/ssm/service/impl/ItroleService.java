package com.ssm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.ItroleAttributeMapper;
import com.ssm.mapper.ItroleMapper;
import com.ssm.service.IItroleService;

@Service
public class ItroleService implements IItroleService{
	private static Logger logger = LoggerFactory.getLogger(ItroleService.class);
	
	@Autowired
	private ItroleMapper itroleMapper;
	
	@Autowired
	private ItroleAttributeMapper itroleAttributeMapper;
}
