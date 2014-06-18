/* Copyright(c)2010-2014 WUDAOSOFT.COM
 * 
 * Email:changsoul.wu@gmail.com
 * 
 * QQ:275100589
 */ 
 
package com.wudaosoft.weixin.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wudaosoft.weixin.oauth2.Oauth2AccessToken;
import com.wudaosoft.weixin.oauth2.Oauth2Api;
import com.wudaosoft.weixin.oauth2.Oauth2UserInfo;

/**
 * <p>Oauth2授权回调 </p>
 * @author Changsoul.Wu
 * @date 2014年4月24日 下午2:32:59
 */
public class Oauth2Servlet extends HttpServlet {
	
	private static final long serialVersionUID = -5892487501072968706L;
	
	private static final Logger log = Logger.getLogger(Oauth2Servlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		
		log.info("code:"+code+"--state:"+state);
		
		Oauth2AccessToken token  = Oauth2Api.getOauth2AccessToken(code);
		
		log.info("oauth2AccessToken:"+token);
		
		Oauth2UserInfo user = Oauth2Api.oauth2UserInfo(token.getAccess_token(), token.getOpenid(), "zh_CN");
		
		log.info("oauth2UserInfo:"+user);
		
		//TODO 在这里做绑定帐号操作
		
		resp.sendRedirect("/success.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}
