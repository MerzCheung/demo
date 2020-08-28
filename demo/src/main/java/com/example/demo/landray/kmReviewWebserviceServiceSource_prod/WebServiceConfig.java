package com.example.demo.landray.kmReviewWebserviceServiceSource_prod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 解析配置文件
 * 
 */
public class WebServiceConfig {

	// Web服务的URL
	private String address;
	
	// Web服务接口
	private Class serviceClass;
	
	// Web服务标识
	private String serviceBean;
	
	// 用户
	private String user;
	
	// 密码
	private String password;

	private WebServiceConfig() {
		loadCfg("user");
	}

	private WebServiceConfig(String pre) {
		loadCfg(pre);
	}

	public static WebServiceConfig getInstance(String pre) {
		return new WebServiceConfig(pre);
	}

	public static WebServiceConfig getInstance() {
		return new WebServiceConfig();
	}

	/**
	 * 解析配置文件
	 */
	private void loadCfg(String pre) {
		Properties prop = new Properties();
		InputStream confStream = this.getClass().getClassLoader().getResourceAsStream(
				"client_" + pre + ".properties");

		try {
			prop.load(confStream);
			this.address = prop.getProperty("address");
			String serviceClassName = prop.getProperty("service_class");
			this.serviceClass = Class.forName(serviceClassName);
			this.serviceBean = prop.getProperty("service_bean");
			if ("user".equals(pre)) {
				this.user = prop.getProperty("user");
				this.password = prop.getProperty("password");
			}
		} catch (Exception e) {
			// TODO 自动生成的catch块
			e.printStackTrace();
		} finally {
			try {
				confStream.close();
			} catch (IOException e) {
				// TODO 自动生成的catch块
				e.printStackTrace();
			}
		}

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Class getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(Class serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getServiceBean() {
		return serviceBean;
	}

	public void setServiceBean(String serviceBean) {
		this.serviceBean = serviceBean;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
