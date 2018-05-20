package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.ItroleAttributeMapper;
import com.ssm.mapper.ItroleMapper;
import com.ssm.mapper.PrivilegeMapper;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.ItroleExample;
import com.ssm.pojo.Privilege;
import com.ssm.pojo.PrivilegeExample;
import com.ssm.service.IItroleService;

@Service
public class ItroleService implements IItroleService{
	private static Logger logger = LoggerFactory.getLogger(ItroleService.class);
	
	@Autowired
	private ItroleMapper itroleMapper;
	
	@Autowired
	private ItroleAttributeMapper itroleAttributeMapper;
	
	@Autowired
	private PrivilegeMapper privilegeMapper;

	@Override
	public Map<String,List<Itrole>> getItroleByResourceUuid(String resUuid, String acctUuid) throws Exception {
//		ItroleExample example = new ItroleExample();
//		example.createCriteria().andItroleResUuidEqualTo(resUuid);
//		example.setOrderByClause("itrole_id");
		List<Itrole> assignableItrole = getItroleByResUuid(resUuid);
		
		PrivilegeExample example1 = new PrivilegeExample();
		example1.createCriteria().andPvgAcctUuidEqualTo(acctUuid);
		List<Privilege> privilegeList = privilegeMapper.selectByExample(example1);
		List<Itrole> assignedItrole = new ArrayList<>();
		for(Privilege p : privilegeList){
			assignedItrole.add(itroleMapper.selectByPrimaryKey(p.getPvgItroleUuid()));
		}
		
		for(Itrole itrole : assignedItrole){
			Iterator<Itrole> it = assignableItrole.iterator();
			while(it.hasNext()){
				Itrole itrole2 = it.next();
				if(itrole2.getItroleUuid().equals(itrole.getItroleUuid())){
					it.remove();
				}
			}
		}
		
		Map<String,List<Itrole>> result = new HashMap<>();
		result.put("assigned", assignedItrole);
		result.put("assignable", assignableItrole);
		
		return result;
	}

	@Override
	public List<Itrole> getItroleByResUuid(String resUuid) throws Exception{
		
		ItroleExample example = new ItroleExample();
		example.createCriteria().andItroleResUuidEqualTo(resUuid);
		example.setOrderByClause("itrole_id");
		
		List<Itrole> assignableItrole = itroleMapper.selectByExample(example);
		
		return assignableItrole;
	}
	
	@Override
	public Itrole getItroleByItroleUuid(String itroleUuid) throws Exception{
		return itroleMapper.selectByPrimaryKey(itroleUuid);
	}

	@Override
	public boolean deleteByPrimaryKey(String itroleUuid) throws Exception {
		
		if(itroleMapper.deleteByPrimaryKey(itroleUuid) > 0){
			return true;
		}
		
		return false;
	}
}
