package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class UsersPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'List of Users')]")
	WebElement usersLabel;
	
	@FindBy(id="editUserPanel_firstNameField")
	WebElement firstName;
	
	@FindBy(id="createUserPanel_lastNameField")
	WebElement lastName;
	
	@FindBy(id="createUserPanel_emailField")
	WebElement mail;
	
	@FindBy(xpath = "//div[contains(text(),'Save & Send Invitation')]")
	WebElement saveBtn;

	@FindBy(xpath = "//div[contains(text(),'New User')]")
	WebElement btnNewUser;
	
	
	
	// Initializing the Page Objects:
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyUsersLabel(){
		return usersLabel.isDisplayed();
	}
	
	
	public void selectUsersByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewUser(String ftName, String ltName, String email){
		//Select select = new Select(driver.findElement(By.name("title")));
		//select.selectByVisibleText(title);

		btnNewUser.click();

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		mail.sendKeys(email);
		saveBtn.click();
		
	}
	
	
	

}
