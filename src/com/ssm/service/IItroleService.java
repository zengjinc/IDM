package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Itrole;

public interface IItroleService {
	Map<String,List<Itrole>> getItroleByResourceUuid(String resUuid, String acctUuid) throws Exception;

	List<Itrole> getItroleByResUuid(String resUuid) throws Exception;

	Itrole getItroleByItroleUuid(String itroleUuid) throws Exception;
}
