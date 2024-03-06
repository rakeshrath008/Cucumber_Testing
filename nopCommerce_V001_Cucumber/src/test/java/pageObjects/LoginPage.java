package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
     public WebDriver driver;
     
     public LoginPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
     
     @FindBy(id = "Email")
     @CacheLookup
     WebElement textEmail;
     
     @FindBy(id = "Password")
     @CacheLookup
     WebElement textPassword;
     
     @FindBy(xpath = "//button[.='Log in']")
     @CacheLookup
     WebElement loginButton;
     
     @FindBy(xpath = "//a[.='Logout']")
     @CacheLookup
     WebElement logoutLink;
     
     public void setUserName(String user)
     {
    	 textEmail.clear();
    	 textEmail.sendKeys(user);
     }
     public void setPassword(String password)
     {
    	 textPassword.clear();
    	 textPassword.sendKeys(password);
     }
     public void clickLogin()
     {
    	 loginButton.click();
     }
     public void clickLogout()
     {
    	 logoutLink.click();
     }
}
