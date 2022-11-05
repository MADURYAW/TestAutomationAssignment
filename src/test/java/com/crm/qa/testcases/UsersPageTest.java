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

public class UsersPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public UsersPageTest(){
			super();
			
	}
	
	//This is a @BeforeMethod
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority=1,enabled = false)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2,enabled = false)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3,enabled = false)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData",enabled = false)
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
