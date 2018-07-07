package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
//CacheLookUp: ----instead of going to or hitting to the browser and search for the element it will go to the cas=che for the address of the element so that performance is faster
public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	//Initialization of page object
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
		
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fName,String lName,String cName){
		Select sel= new Select(titleDropdown);
		sel.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		companyName.sendKeys(cName);
		saveButton.click();
	}
	
	
	
}
