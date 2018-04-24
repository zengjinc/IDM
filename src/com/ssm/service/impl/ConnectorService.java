package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.connector.IConnector;
import com.ssm.pojo.Resource;
import com.ssm.service.IConnectorService;
import com.ssm.service.IResourceService;
import com.ssm.utils.BeanUtil;

@Service
public class ConnectorService implements IConnectorService {

	@Autowired
	private IResourceService resourceService;
	
	@Override
	public IConnector getConnectorByResUuid(String resUuid) throws Exception {
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
		connector.setResource(resource);
		return connector;
	}

}
