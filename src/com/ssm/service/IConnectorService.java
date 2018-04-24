package com.ssm.service;

import com.ssm.connector.IConnector;

public interface IConnectorService {

	IConnector getConnectorByResUuid(String resUuid) throws Exception;
}
