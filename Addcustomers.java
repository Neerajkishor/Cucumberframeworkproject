package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomers {
	
WebDriver ldriver;
	
	public  Addcustomers(WebDriver rDriver)
	{
		ldriver =rDriver;
		PageFactory.initElements(rDriver,this);
		
	}
	
	//Find web elements on page


	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement ClickOnCustomersMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement ClickonCustomeritem;
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement ClickOnAddNewbtn;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@name='Password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@name='FirstName']")
	WebElement txtFirstname;
	@FindBy(xpath="//input[@name='LastName']")
	WebElement txtLastName;
	
	@FindBy(id="Gender_Male")
	WebElement MaleGender;;
	@FindBy(id= "Gender_Female")
	WebElement FemaleGender;;
	
	@FindBy(id="DateOfBirth")
	WebElement txtDob;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCom;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap]")
	WebElement txtNewLetter;
	
	@FindBy(xpath="//*[@id='VendorId']")
	WebElement txtVendorId;
	
	@FindBy(id="AdminComment")
	WebElement txtAdminComment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnsave;
	
	//Actions Methods for web elements
	
	public String getPageTitle()

	{		
      return ldriver.getTitle();
	}

	public void ClickOnCustomersMenu() {
		ClickOnCustomersMenu.click();
	}
    
	public void ClickonCustomeritem() {
		ClickonCustomeritem.click();
	}
	
	public void ClickOnAddNewbtn() {
		ClickOnAddNewbtn.click();
	}
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void enterFirstname(String firstname) {
		txtFirstname.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	public void enterGender(String gender) throws InterruptedException
	   {
		if(gender.equals("Male"))
		{
			MaleGender.click();
			}
		else if(gender.equals("Female"))
			{
			FemaleGender.click();
			}
		else
		   {
			MaleGender.click();
			}
		Thread.sleep(2000);
	     }
	
	public void enterDateofbirth(String dob) {
		txtDob.sendKeys(dob);
	}
	public void entercompany(String com) {
		
		txtCom.sendKeys(com);
	}
	public void enterNewsLetter(String letter) {
		txtNewLetter.sendKeys(letter);
	}
	
	
	public void entervendorid(String Venderid) {
		txtVendorId.sendKeys(Venderid);
	}
	public void enterAdminContent(String Comment)
	
	
	{
		txtAdminComment.sendKeys(Comment);
	}

  public void clickonsave() {
	  btnsave.click();
  }
	
}
