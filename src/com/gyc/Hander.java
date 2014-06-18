package com.gyc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class Hander {

	@RequestMapping(params="hander", method = RequestMethod.GET)
	public void hander(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String echostr = request.getParameter("echostr");
		response.getWriter().print(echostr);
	}
}
