/* Copyright(c)2010-2014 WUDAOSOFT.COM
 * 
 * Email:changsoul.wu@gmail.com
 * 
 * QQ:275100589
 */

package com.wudaosoft.weixin.demo.test;

import org.apache.log4j.Logger;

import com.wudaosoft.weixin.demo.Config;
import com.wudaosoft.weixin.menu.ClickMenu;
import com.wudaosoft.weixin.menu.Menu;
import com.wudaosoft.weixin.menu.MenuApi;
import com.wudaosoft.weixin.menu.SubMenu;
import com.wudaosoft.weixin.menu.ViewMenu;

/**
 * <p> </p>
 * 
 * @author Changsoul.Wu
 * @date 2014年4月24日 下午12:17:53
 */
public class TestMenu {
	
	private static final Logger log = Logger.getLogger(TestMenu.class);

	public static void create() {
		// 左边菜单
		SubMenu sub1 = new SubMenu("菜单1");
		sub1.addSubButton(new ClickMenu("子菜单1", "1"));
		sub1.addSubButton(new ClickMenu("子菜单2", "2"));
		sub1.addSubButton(new ClickMenu("子菜单3", "3"));
		sub1.addSubButton(new ClickMenu("子菜单4", "4"));
		sub1.addSubButton(new ClickMenu("子菜单5", "5"));

		// 中间菜单
		SubMenu sub2 = new SubMenu("我");
		sub2.addSubButton(new ClickMenu("绑定帐号", "BINDING"));
		sub2.addSubButton(new ClickMenu("子菜单2", "5"));
		sub2.addSubButton(new ClickMenu("子菜单3", "7"));
		sub2.addSubButton(new ClickMenu("子菜单4", "8"));
		sub2.addSubButton(new ClickMenu("子菜单5", "9"));

		// 右边菜单
		ViewMenu view3 = new ViewMenu("菜单3", "http://www.wudaosoft.com");

		// 菜单栏
		Menu menu = new Menu();
		menu.addButton(sub1);
		menu.addButton(sub2);
		menu.addButton(view3);

		log.info("create result:"+MenuApi.menuCreate(menu));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Config.init();
		
		create();
	}

}
