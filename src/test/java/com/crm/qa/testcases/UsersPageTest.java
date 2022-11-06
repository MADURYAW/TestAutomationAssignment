/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.UsersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import static java.lang.Thread.sleep;

public class UsersPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	
	String sheetName = "users";
	
	   
	public UsersPageTest(){
			super();
			
	}
	
	//This is a @BeforeMethod
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminName"), prop.getProperty("adminPassword"));
		sleep(1000);
		Assert.assertTrue(homePage.verifyCorrectUserName());
		//testUtil.switchToFrame();
		usersPage = homePage.clickOnUsersLink();
		sleep(2000);
		usersPage.verifyUsersLabel();
	}
	
	@Test(priority=1,enabled = true)
	public void verifyUsersPageLabel(){
		log.debug("title : "+driver.getTitle());
		Assert.assertTrue(usersPage.verifyUsersLabel(), "List of Users, label is missing on the page");
	}
	
	@Test(priority=2,enabled = false)
	public void selectSingleUserTest(){
		usersPage.selectUsersByName("test2 test2");
	}
	
	@Test(priority=3,enabled = false)
	public void selectMultipleUsersTest(){
		usersPage.selectUsersByName("user1 user2");
		usersPage.selectUsersByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData",enabled = true)
	public void validateCreateNewContact(String firstName, String lastName, String email){
		usersPage.createNewUser(firstName, lastName, email);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
