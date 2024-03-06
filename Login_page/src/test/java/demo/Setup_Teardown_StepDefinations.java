package demo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Setup_Teardown_StepDefinations 
{
	@Before
	public void setup()
	{
		System.out.println("Chrome launched");
		System.out.println("Entered URL of application");
		System.out.print(" ");
	}
	
	@After
	public void teardown()
	{
		System.out.println("Closed browser");
		System.out.print(" ");
	}
	
	@Given("User is on customer page")
    public void userIsOnCustomerPage() {
		System.out.println("User is on customer page");
    }

    @When("User fills the customer details")
    public void userFillsCustomerDetails() {
    	System.out.println("User fills the customer details");
    }

    @Then("Customer is added")
    public void customerIsAdded() {
    	System.out.println("Customer is added");
    }

    @Given("User is on edit customer page")
    public void userIsOnEditCustomerPage() {
    	System.out.println("User is on edit customer page");
    }

    @When("User edit contact details")
    public void userEditsContactDetails() {
    	System.out.println("User edit contact details");
    }

    @Then("Contact details updated")
    public void contactDetailsUpdated() {
    	System.out.println("Contact details updated");
    }

    @Given("User is on delete customer page")
    public void userIsOnDeleteCustomerPage() {
    	System.out.println("User is on delete customer page");
    }

    @When("User delete customer")
    public void userDeletesCustomer() {
    	System.out.println("User delete customer");
    }

    @Then("Customer deleted")
    public void customerIsDeleted() {
    	System.out.println("Customer deleted");
    }
}
