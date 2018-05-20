package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;

public interface IResourceService {

	List<Resource> getAllResourceNonTrust() throws Exception;

	List<String> getAcctAttrByResUuid(String resUuid) throws Exception;
	
	Resource getResourceByPrimarKey(String resUuid) throws Exception;

	Resource getResourceByResId(String resId) throws Exception;

	List<Resource> getResourceByExample(ResourceExample example) throws Exception;

	void cascadeDeleteResource(String resUuid) throws Exception;

}
