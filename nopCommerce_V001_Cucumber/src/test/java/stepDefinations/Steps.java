package stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.searchCustomerPage;

public class Steps extends BaseClass
{
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() 
	{
//		ChromeOptions options = new ChromeOptions();
//		options.setBinary("D:\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

		logger=Logger.getLogger("nopCommerce_V001_Cucumber");
		PropertyConfigurator.configure("log4j.properties");   // Added logger

		driver = new EdgeDriver();

		logger.info("*********Launching browser*************");

		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		logger.info("*********Opening URL*************");
		driver.get(url);
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) 
	{
		logger.info("*********Providing login details*************");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on login")
	public void click_on_login() 
	{
		logger.info("*********Started login*************");
		lp.clickLogin();
	}

	@Then("Page tittle should be {string}")
	public void page_tittle_should_be(String title) 
	{
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
		logger.info("*********Login passed*************");
		Assert.assertTrue(false);
		}
		else {
			logger.info("*********Login failed*************");
			Assert.assertEquals(title,driver.getTitle());
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() 
	{
		logger.info("*********Click on logout link*************");
		lp.clickLogout();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
		logger.info("*********Login passed*************");
		Assert.assertTrue(false);
		}
		else {
			logger.info("*********Login failed*************");
			Assert.assertEquals(title,driver.getTitle());
			}
	}

	@Then("Close browser")
	public void close_browser() 
	{
		logger.info("*********Closing browser*************");
		driver.quit();
	}

	//Customer features stepDefinations ..........................

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}
	@When("User click on customers Menu Item")
	public void user_click_on_customers_menu_item() throws InterruptedException {
		addCust.clickOnDropdown();
		Thread.sleep(1000);
		addCust.clickOnCustomers();
	}
	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnAddNew();
	}
	@Then("User can view add new customore page")
	public void user_can_view_add_new_customore_page() throws InterruptedException {

		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
		Thread.sleep(2000);
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("**********Adding new customer*************");
		logger.info("**********Providing customer details*************");
		String email = randomString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("Test123");
		addCust.setFirstName("Rakesh");
		addCust.setLastName("Rath");
		addCust.setGender();
		addCust.clickOnCalender();
		addCust.clickOnPrevLink();
		addCust.setCompanyName("Quotus");
	}
	@When("Click on save button")
	public void click_on_save_button() {
		logger.info("**********Saving customer data*************");
		addCust.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String text) throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
		Thread.sleep(2000);
	}

	//Steps for searching a customer using Email ID

	@And("Enter customer Email")
	public void enter_customer_email() {
		logger.info("**********Searching customer by email id*************");
		searchCust = new searchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	//Steps for searching a customer using FirstName and LastName

	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		logger.info("**********Searching customer by name*************");
		searchCust = new searchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		searchCust.setLastName("Terces");
	}
	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
}
