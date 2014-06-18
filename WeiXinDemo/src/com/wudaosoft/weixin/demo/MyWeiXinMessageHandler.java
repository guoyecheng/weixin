/* Copyright(c)2010-2014 WUDAOSOFT.COM
 * 
 * Email:changsoul.wu@gmail.com
 * 
 * QQ:275100589
 */ 
 
package com.wudaosoft.weixin.demo;

import com.wudaosoft.weixin.CommonApi;
import com.wudaosoft.weixin.handler.WeiXinMessageHandler;
import com.wudaosoft.weixin.message.receive.ReceiveEventMsg;
import com.wudaosoft.weixin.message.receive.ReceiveImageMsg;
import com.wudaosoft.weixin.message.receive.ReceiveLinkMsg;
import com.wudaosoft.weixin.message.receive.ReceiveLocationMsg;
import com.wudaosoft.weixin.message.receive.ReceiveTextMsg;
import com.wudaosoft.weixin.message.receive.ReceiveVideoMsg;
import com.wudaosoft.weixin.message.receive.ReceiveVoiceMsg;
import com.wudaosoft.weixin.message.response.ResponseMsgBuilder;
import com.wudaosoft.weixin.oauth2.Oauth2Api;
import com.wudaosoft.weixin.usermanage.UserApi;

/**
 * <p> </p>
 * @author Changsoul.Wu
 * @date 2014年4月18日 下午12:21:16
 */
public class MyWeiXinMessageHandler implements WeiXinMessageHandler {
	
	private static final String LINE = "\r\n";
	
	private static WeiXinMessageHandler handler = new MyWeiXinMessageHandler();
	
	public static WeiXinMessageHandler getInstance() {
		return handler;
	}
	
	//禁止new
	private MyWeiXinMessageHandler(){}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processClickEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processClickEvent(ReceiveEventMsg arg0) {
		//绑定帐号事件值BINDING,
		if("BINDING".equals(arg0.getEventKey())){
			//返回绑定帐号Oauth2授权连接
			String redirectUri = "http://www.wudaosoft.com";
			String content = "感谢您使用本产品!"+LINE+Oauth2Api.buildUserinfoOauth2Link("请点出这里绑定", redirectUri, "");
			return ResponseMsgBuilder.buildTextMsg(arg0.getFromUserName(), CommonApi.WEI_XIN_ACCOUNT, content);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processImageMsg(com.wudaosoft.weixin.message.receive.ReceiveImageMsg)
	 */
	@Override
	public String processImageMsg(ReceiveImageMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processLinkMsg(com.wudaosoft.weixin.message.receive.ReceiveLinkMsg)
	 */
	@Override
	public String processLinkMsg(ReceiveLinkMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processLocationEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processLocationEvent(ReceiveEventMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processLocationMsg(com.wudaosoft.weixin.message.receive.ReceiveLocationMsg)
	 */
	@Override
	public String processLocationMsg(ReceiveLocationMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processScanEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processScanEvent(ReceiveEventMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processSubscribeEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processSubscribeEvent(ReceiveEventMsg arg0) {
		String redirectUri = "http://www.wudaosoft.com";
		
		String content = "欢迎"+UserApi.userInfo(arg0.getFromUserName(), "zh_CN").getNickname()+","+LINE+Oauth2Api.buildUserinfoOauth2Link("请点出这里绑定", redirectUri, "");
		return ResponseMsgBuilder.buildTextMsg(arg0.getFromUserName(), CommonApi.WEI_XIN_ACCOUNT, content);
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processTextMsg(com.wudaosoft.weixin.message.receive.ReceiveTextMsg)
	 */
	@Override
	public String processTextMsg(ReceiveTextMsg arg0) {
		String content = "来自无道软件工作室的回复:"+arg0.getContent();
		return ResponseMsgBuilder.buildTextMsg(arg0.getFromUserName(), CommonApi.WEI_XIN_ACCOUNT, content);
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processUnsubscribeEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processUnsubscribeEvent(ReceiveEventMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processVideoMsg(com.wudaosoft.weixin.message.receive.ReceiveVideoMsg)
	 */
	@Override
	public String processVideoMsg(ReceiveVideoMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processViewEvent(com.wudaosoft.weixin.message.receive.ReceiveEventMsg)
	 */
	@Override
	public String processViewEvent(ReceiveEventMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wudaosoft.weixin.handler.WeiXinMessageHandler#processVoiceMsg(com.wudaosoft.weixin.message.receive.ReceiveVoiceMsg)
	 */
	@Override
	public String processVoiceMsg(ReceiveVoiceMsg arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
