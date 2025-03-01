package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController 
{
	@RequestMapping("home")
	public String getHomePage()
	{
		return "home";
	}
	@RequestMapping("login")
	public String getLoginPage()
	{
		return "login";
	}
	@RequestMapping("cntus")
	public String getContactPage()
	{
		return "cntus";
	}
	@RequestMapping("abtus")
	public String getAboutPage()
	{
		return "abtus";
	}
	@RequestMapping("help")
	public String getHelpPage()
	{
		return "help";
	}
}//end class
