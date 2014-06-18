/* Copyright(c)2010-2014 WUDAOSOFT.COM
 * 
 * Email:changsoul.wu@gmail.com
 * 
 * QQ:275100589
 */ 
 
package com.wudaosoft.weixin.demo;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.wudaosoft.weixin.WeiXinConfig;
import com.wudaosoft.weixin.WeiXinMessageProcess;

/**
 * <p> </p>
 * @author Changsoul.Wu
 * @date 2014年4月24日 下午1:11:45
 */
public class Config {
	
	private static final Logger log = Logger.getLogger(Config.class);
	
	public static void init() {
		String classPath = Config.class.getResource("/").getPath();
		String log4jDir = classPath.substring(0, classPath.indexOf("classes")) + "logs";

		System.setProperty("log4jDir", log4jDir);

		String log4jPath = classPath + "log4j.xml";

		//配置log4j
		DOMConfigurator.configure(log4jPath);

		Properties prop = new Properties();
		try {
			prop.load(Config.class.getResource("/weixin_config.properties").openStream());

			// 配置公众平台帐号信息
			WeiXinConfig config = new WeiXinConfig()
					.setAccount(prop.getProperty("WEI_XIN_ACCOUNT"))
					.setAppId(prop.getProperty("APP_ID"))
					.setAppsecret(prop.getProperty("APPSECRET"))
					.setToken(prop.getProperty("TOKEN"));
			
			// 设置配置信息
			WeiXinMessageProcess.setWeixinConfig(config);
			// 设置消息处理Handler
			WeiXinMessageProcess.setMessageHandler(MyWeiXinMessageHandler.getInstance());
			
			log.info("Weixin initialize...");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
