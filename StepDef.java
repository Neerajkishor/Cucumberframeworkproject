package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.Addcustomers;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {
	
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webDriver.chrome.driver",System.getProperty("user")+"//Drivers.chromedriver.exe");
		driver= new ChromeDriver();
		loginpg =new LoginPage(driver);	
		Addcust = new Addcustomers(driver);
		Searchbyemail = new SearchCustomerByEmail(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String pwd) {
	
		 loginpg.enterEmail(Email);
	      loginpg.password(pwd);
	
	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickonLoginButton();   
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String Expectedtitle) {
		
		String actualtite=driver.getTitle();
		if (actualtite.equals(Expectedtitle))
		{
		Assert.assertTrue(true);	
		}else
		{		
			Assert.assertTrue(false);	
		}	    
	   }

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws Throwable
	  {	
		loginpg.clickonLogOutButton();	
		Thread.sleep(2000);
	  }
	@Then("close browser")
	public void close_browser() 
	   {		
		driver.close();
		driver.quit();	  
	   }
	
	
	//////////Add New Customers //////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualtitle=Addcust.getPageTitle();
		String Expectedtitle="Dashboard / nopCommerce administration";
		if(actualtitle.equals(Expectedtitle)) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}			   
	    }

	@When("Click on Customer menu")
	public void click_on_customer_menu() 
	     {
		Addcust.ClickOnCustomersMenu();	    
	      }

	@When("Click on Customer item")
	public void click_on_customer_item() {
		Addcust.ClickonCustomeritem();	    
	}

	@When("Click on AddNew button")
	public void click_on_add_new_button() {
		Addcust.ClickOnAddNewbtn();
	}

	@Then("User can view Add New customer page")
	public void user_can_view_add_new_customer_page()
	   {
		String actualtitle=Addcust.getPageTitle();
		String Expectedtitle="Add a new customer / nopCommerce administration";
		if(actualtitle.equals(Expectedtitle)) {
			Assert.assertTrue(true);
		        }else
		    {
			Assert.assertTrue(false);
		    }	   
	    }

	@When("user enter the customer info")
	public void user_enter_the_customer_info() throws InterruptedException {
		Addcust.enterEmail(generateEmailId() +"gmail.com");
		
		//// Addcust.enterEmail("test4@gmail.com");
		
		Addcust.enterPassword("12456");
		Addcust.enterFirstname("Meera");
		Addcust.enterLastname("kr");
		Addcust.enterGender("Female");
		Addcust.enterDateofbirth("6/13/1988");
		Addcust.entercompany("Decimal");
		//Addcust.enterNewsLetter("Test store 2");
		Addcust.entervendorid("Vendor 1");
		Addcust.enterAdminContent("Admin1576");
	}

	@When("click on save button")
	public void click_on_save_button() {
		Addcust.clickonsave();   
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String Expectedconfirmationmessage)
	 {
		String bodytag= driver.findElement(By.tagName("Body")).getText();
		if (bodytag.contains(Expectedconfirmationmessage)){
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}    
	 }
	
	
	////////////CustomersSearchBy email///////////
	
	
	@When("enter customer Email")
	public void enter_customer_email() {
		Searchbyemail.emailsearch("admin@yourStore.com");
	}

	@When("click on serach button")
	public void click_on_serach_button() throws InterruptedException {
		Searchbyemail.clickonSearchbutton();
		Thread.sleep(3000);
	    
	}

	@Then("user should find the details")
	public void user_should_find_the_details() {
	    String expectedEmail= "admin@yourStore.com" ;
	    Assert.assertTrue(Searchbyemail.searchcustomerByEmailresult(expectedEmail));
	    
	}
	
	@Then("close the browser.")
	public void close_the_browser() {
		 {		
				driver.close();
				driver.quit();	  
			   }
	    
	}
	
	//////Search customer by firstname & astname//////////
	
	@When("enter customer Firstname")
	public void enter_customer_firstname() {
		Searchbyemail.enterfirstname("John") ; 
	}

	@When("enter customer Lastname")
	public void enter_customer_lastname() {
		Searchbyemail.enterlastname("Smith") ; 
 
	}

	@Then("user should find the name in table.")
	public void user_should_find_the_name_in_table() {
		
		String Expectedname= "John Smith";
		if (Searchbyemail.searchcustomerByName(Expectedname)==true)
		{
			Assert.assertTrue(true);
		} else
		{
			Assert.assertTrue(false);
		}
	    
	}
}
