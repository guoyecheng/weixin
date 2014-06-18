/* Copyright(c)2010-2014 WUDAOSOFT.COM
 * 
 * Email:changsoul.wu@gmail.com
 * 
 * QQ:275100589
 */ 
 
package com.wudaosoft.weixin.demo.test;

import org.apache.log4j.Logger;

import com.wudaosoft.weixin.GlobalReturnCode;
import com.wudaosoft.weixin.demo.Config;
import com.wudaosoft.weixin.message.send.CustomMsgSender;

/**
 * <p>发送客服消息 </p>
 * @author Changsoul.Wu
 * @date 2014年4月24日 下午1:35:23
 */
public class TestSendMessage {
	
	private static final Logger log = Logger.getLogger(TestMenu.class);
	
	public static void sendTextMessage(){
		GlobalReturnCode code = CustomMsgSender.sendTextMsg("oNbcTtxpwHYQq48qVZQVXxYSdjwU", "你好~");
		
		log.info("result:"+code);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Config.init();
		sendTextMessage();
	}

}
