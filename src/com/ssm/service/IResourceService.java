package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Resource;

public interface IResourceService {

	List<Resource> getAllResourceNonTrust() throws Exception;

	List<String> getAcctAttrByResUuid(String resUuid) throws Exception;
	
	Resource getResourceByPrimarKey(String resUuid) throws Exception;

}
