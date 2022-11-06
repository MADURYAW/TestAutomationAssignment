package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1,enabled = true)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		log.debug("title : "+title);
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test(priority=2,enabled = true)
	public void logoImageTest(){
		boolean flag = loginPage.validateLogoImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3,enabled = true)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=4,enabled = true)
	public void adminLoginTest(){
		homePage = loginPage.login(prop.getProperty("adminName"), prop.getProperty("adminPassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
