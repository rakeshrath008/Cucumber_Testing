Feature: Hooks in cucumber

Scenario: Add new customer
Given User is on customer page
When User fills the customer details
Then Customer is added

Scenario: Edit customer
Given User is on edit customer page
When User edit contact details
Then Contact details updated

Scenario: Delete customer
Given User is on delete customer page
When User delete customer
Then Customer deleted