package com.ssm.utils.properties;

/**
 * Usage : 
 * 	ConfigEmailUtil.getInstance().getValueByKey(key)
 * 	ConfigEmailUtil.getInstance().setValueByKey(key,value)
 * 	ConfigEmailUtil.getInstance().save()
 *
 */
public class ConfigEmailUtil extends BasePropertiesUtil{

	/*
	 * Specify the properties path. 
	 */
//	private static String propertiesFilePath="config.properties";
	private static String propertiesFilePath="classpath:config.properties";
	
	/*
	 * Singleton Mode
	 */
	private static ConfigEmailUtil instance = null;
	public static ConfigEmailUtil getInstance() {  
		if( instance==null ){
			instance=new ConfigEmailUtil();
		}
		return instance;
	}
	
	/*
	 * private constructor
	 */
	private ConfigEmailUtil(){
		super(propertiesFilePath);
	}
	

}
