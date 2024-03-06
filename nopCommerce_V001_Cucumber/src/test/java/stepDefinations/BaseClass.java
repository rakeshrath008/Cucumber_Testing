package stepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.searchCustomerPage;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public searchCustomerPage searchCust;
	public static Logger logger;

	// Random unique string

	public static String randomString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
}
