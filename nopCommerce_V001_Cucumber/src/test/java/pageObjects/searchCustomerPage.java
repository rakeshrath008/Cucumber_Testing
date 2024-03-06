package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helper;

public class searchCustomerPage
{
    public WebDriver driver;
    Helper helper;
    public searchCustomerPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    	helper = new Helper(driver);
    }
    @FindBy(how = How.ID , using = "SearchEmail")
    @CacheLookup
    private WebElement txtEmail;
    
    @FindBy(xpath = "//input[@id='SearchFirstName']")
    @CacheLookup
    private WebElement txtFirstName;
    
    @FindBy(xpath = "//input[@id='SearchLastName']")
    @CacheLookup
    private WebElement txtLastName;
    
    @FindBy(how = How.ID , using = "SearchMonthOfBirth")
    @CacheLookup
    private WebElement drpDobMonth;
    
    @FindBy(how = How.ID , using = "SearchDayOfBirth")
    @CacheLookup
    private WebElement drpDobYear;
    
    @FindBy(how = How.ID , using = "SearchCompany")
    @CacheLookup
    private WebElement txtCompany;
    
    @FindBy(how = How.XPATH , using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    private WebElement txtCustomoreRoles;
    
    @FindBy(how = How.ID , using = "search-customers")
    @CacheLookup
    private WebElement searchButton;
    
    @FindBy(how = How.XPATH , using = "//table[@aria-describedby='customers-grid_info']")
    @CacheLookup
    private WebElement table;
    
    @FindBy(how = How.XPATH , using = "//table[@id='customers-grid']//tbody//tr")
    @CacheLookup
    private List<WebElement> tableRows;
    
    @FindBy(how = How.XPATH , using = "//table[@id='customers-grid']//tbody//tr//td")
    @CacheLookup
    private List<WebElement> tableColumns;
    
    public void setEmail(String email)
    {
    	helper.waitForElement(txtEmail);
    	txtEmail.clear();
    	txtEmail.sendKeys(email);
    }
    public void setFirstName(String FirstName)
    {
    	helper.waitForElement(txtFirstName);
    	txtFirstName.clear();
    	txtFirstName.sendKeys(FirstName);
    }
    public void setLastName(String LastName)
    {
    	helper.waitForElement(txtLastName);
    	txtLastName.clear();
    	txtLastName.sendKeys(LastName);
    }
    public void clickSearch()
    {
    	helper.waitForElement(searchButton);
    	searchButton.click();
    }
    public int noOfRows()
    {
    	return(tableRows.size());
    }
    public int noOfColumns()
    {
    	return(tableColumns.size());
    }
    public boolean searchCustomerByEmail(String email) throws InterruptedException
    {
    	boolean flag = false;
    	for(int i=0;i<tableColumns.size();i++)
    	{
    		if(tableColumns.get(i).getText().contains(email))
    		{
    			flag=true;
    		}
    	}
    	return flag;
    }
    public boolean searchCustomerByName(String name) throws InterruptedException
    {
    	boolean flag = false;
    	
    	for(int i=0;i<tableColumns.size();i++)
    	{
    		if(tableColumns.get(i).getText().contains(name))
    		{
    			flag=true;
    		}
    	}
    	return flag;
    }
}
