package com.sinosoft.demo.controller;

import com.sinosoft.demo.model.UserInfo;
import com.sinosoft.demo.services.UserServices;
import com.sinosoft.demo.util.EncryptUtil;
import com.sinosoft.demo.util.Md5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Controller
public class ApplicationController {
	@Resource
	private UserServices userServices;

	private static String secretKey = "9ba45bfd500642328ec03ad8ef1b6e75";

	@RequestMapping("/")
	public String index( Model model) throws Exception {

		List<UserInfo> us = userServices.getUsers();
		for(UserInfo u:us){
			EncryptUtil des = new EncryptUtil(secretKey, "utf-8");
			userServices.updatePsw(u.getUserId(),des.encode(u.getPassword()));
		}
		return "数据库密码加密成功啦";


	}

	/*@RequestMapping("/")
	public String index( Model model) {
		UserInfo user=new UserInfo();
		user.setUserName("admin");
		model.addAttribute("data", user);
		return "index";
	}*/



}
