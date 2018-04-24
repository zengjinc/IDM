package com.ssm.pojo.to;

import java.util.List;

import com.ssm.pojo.Account;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.Privilege;
import com.ssm.pojo.Resource;

public class PrivilegeTo extends Privilege {
	private Account account;
	
	private Resource resource;
	
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
