package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddcustomerPage 
{
	public WebDriver driver;

	public AddcustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	By customerDropdownLink = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By CustomersLink = By.xpath("//p[.=' Customers']");
	By addNewButton = By.xpath("//a[@href='/Admin/Customer/Create']");
	By emailLink = By.id("Email");
	By passwordLink = By.id("Password");
	By firstNameLink = By.id("FirstName");
	By lastNameLink = By.id("LastName");
	By maleRadioButton = By.id("Gender_Male");
	By calenderLink = By.xpath("//span[@class='k-icon k-i-calendar']");
	By prevLink = By.xpath("//a[@aria-label='Previous']");
	By dateLink = By.xpath("//a[.='20']");
	By compNameLink = By.id("Company");
	By saveButton = By.xpath("//button[@name='save']");

	// Actions methods

	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickOnDropdown() {
		WebElement drpdwn = driver.findElement(customerDropdownLink);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", drpdwn);
	}
	public void clickOnCustomers() {
		driver.findElement(CustomersLink).click();
	}
	public void clickOnAddNew() {
		driver.findElement(addNewButton).click();
	}
	public void setEmail(String email) {
		driver.findElement(emailLink).sendKeys(email);
	}
	public void setPassword(String password) {
		driver.findElement(passwordLink).sendKeys(password);
	}
	public void setFirstName(String firstName) {
		driver.findElement(firstNameLink).sendKeys(firstName);
	}
	public void setLastName(String lastName) {
		driver.findElement(lastNameLink).sendKeys(lastName);
	}
	public void setGender() {
		driver.findElement(maleRadioButton).click();
	}
	public void clickOnCalender() {
		driver.findElement(calenderLink).click();
	}
	public void clickOnPrevLink() throws InterruptedException {
		for(int i=0; ;i++)
		{
			String monthYear = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			if(monthYear.contains("May 2017"))
			{
				Thread.sleep(1000);
				driver.findElement(dateLink).click();
				break;
			}
			else
				driver.findElement(prevLink).click();
		}
	}
	public void setCompanyName(String compName) {
		driver.findElement(compNameLink).sendKeys(compName);
	}
	public void clickOnSave() {
		driver.findElement(saveButton).click();
	}
}
