package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Itrole;

public interface IItroleService {
	Map<String,List<Itrole>> getItroleByResourceUuid(String resUuid, String acctUuid) throws Exception;
}
