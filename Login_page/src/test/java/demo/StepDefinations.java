package demo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations 
{
	public WebDriver driver ;
	
//	@And(": Send data to search bar {string}")
//	public void send_data_to_search_bar(String text) {
//		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(text);
//	}
//	@And(": Send data to search bar data")
//	public void send_data_to_search_bar_data(DataTable credentials) {
//		List<List <String>> data = credentials.asLists();
//		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(data.get(0).get(0));
//	}
	
//	@And(": Send data to search bar data")
//	public void send_data_to_search_bar_data(DataTable credentials) {
//		List<Map<String,String>> data = credentials.asMaps(String.class,String.class);
//		driver.findElement(By.id("email")).sendKeys(data.get(0).get("userName"));
//		driver.findElement(By.id("pass")).sendKeys(data.get(0).get("password"));
//	}

	@Given("Open browser")
	public void open_browser() {
		 driver = new ChromeDriver();
		   driver.manage().window().maximize();
	}
	@When("Enter the url {string}")
	public void enter_the_url(String url) {
		 driver.get(url);
	}
	@When("Enter registered username and password")
	public void enter_registered_username_and_password(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> mapData:data) {
		driver.findElement(By.id("email")).sendKeys(mapData.get("userName"));
		driver.findElement(By.id("pass")).sendKeys(mapData.get("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		}
	}
	@Then("Verify the text")
	public void verify_the_text() {
		String orgText ="The password that you've entered is incorrect";
	    String text = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
	    if(text.contains(orgText))
	    {
	    	System.out.println("Pass");
	    }
	    else 
	    {
			Assert.fail();
		}
	    driver.close();
	}
}
