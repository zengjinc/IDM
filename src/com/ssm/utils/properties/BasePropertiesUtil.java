package com.ssm.utils.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

/**
 * Base properties Util for extends. 
 * @author root
 *
 */
public class BasePropertiesUtil {

	private static Logger logger = LogManager.getLogger(BasePropertiesUtil.class);

	Properties prop = new Properties();
	
	//Properities file path. It is from son class. 

	String fileName ;
	
	/**
	 * load Resource
	 * @throws FileNotFoundException 
	 */
	public BasePropertiesUtil(String fileName) {
		this.fileName=fileName;
		
		//Goding to load prop object. 
		try {
			logger.debug("Going to load properties file : "+fileName);
			prop.load(new FileInputStream(ResourceUtils.getFile(fileName)));
			
			File file = new File(fileName);
//			prop.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
//			logger.debug("config.properties file absolute path : " + file.getAbsolutePath());
			logger.debug("load properties "+fileName+" successful. " );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}
	/**
	 * get Value By Key
	 */
	public String getValueByKey(String key) {
		return prop.getProperty(key);
	}
	/**
	 * set Value By Key
	 */
	public void setValueByKey(String key, String value) {
		prop.setProperty(key, value);
	}
	
	/**
	 * get Key By Value in prop
	 */
	public String getKeyByValue(String value){
		Set<Object> keySet = prop.keySet();
		for(Object key : keySet){
			// Ignore case comparison
			if(getValueByKey(key.toString()).equalsIgnoreCase(value)){
				logger.debug("get key: "+key.toString()+" by value: "+value);
				return key.toString();
			}
		}
		return null;
	}
	

	/**
	 * Going to store properties file. 
	 */
	public void save() {
		try {
			logger.debug("Going to store properties file : "+fileName);
			OutputStream fos = new FileOutputStream(
					ResourceUtils.getFile(fileName));
			prop.store(fos, null);
			
			File file = new File(fileName);
			file.getAbsolutePath();
			logger.debug("file absolute path : " + file.getAbsolutePath());
			logger.debug("Store properties file "+fileName+" successful. ");
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
