package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.UsersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import static java.lang.Thread.sleep;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminName"), prop.getProperty("adminPassword"));
	}
	
	
	@Test(priority=1,enabled = true)
	public void verifyHomePageTitleTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("homePageTitle : "+homePageTitle);
		Assert.assertEquals(homePageTitle, "actiTIME -  Enter Time-Track","Home page title not matched");
	}
	
	@Test(priority=2,enabled = true)
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3, enabled = true)
	public void verifyUsersLinkTest(){
		//testUtil.switchToFrame();
		usersPage = homePage.clickOnUsersLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
