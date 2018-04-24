package com.ssm.service;

public interface IJavaMailSenderService {

	void entitlementFinishEmail(String sendTo, String userName, String resourceId, String loginId, String password) throws Exception;

	void entitlementCancelEmail(String sendTo, String userName, String resourceId, String loginId) throws Exception;

	void entitlementEnableEmail(String sendTo, String userName, String resourceId, String loginId) throws Exception;

	void entitlementDisableEmail(String sendTo, String userName, String resourceId, String loginId) throws Exception;

	void changePasswordEmail(String sendTo, String userName, String resourceId, String loginId, String password) throws Exception;

}
