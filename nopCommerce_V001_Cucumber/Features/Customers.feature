Feature: Customers

Background: Below are the common steps for each scenario
            Given User launch chrome browser
            When  User opens URL "https://admin-demo.nopcommerce.com/login"
            And   User enter email as "admin@yourstore.com" and password as "admin"
            And   Click on login
            Then  User can view Dashboard
            
Scenario: Add a new customore
            When  User click on customers Menu Item
            And   Click on add new button
            Then  User can view add new customore page
            When  User enter customer info
            And   Click on save button
            Then  User can view confirmation message "The new customer has been added successfully."
            And   Close browser
            
Scenario: Search customer by EmailId     
            When  User click on customers Menu Item  
            And   Enter customer Email
            When Click on search button   
            Then User should found Email in the search table
            And   Close browser
            
Scenario: Search customer by EmailId     
            When  User click on customers Menu Item  
            And   Enter customer FirstName
            And   Enter customer LastName
            When Click on search button   
            Then User should found Name in the search table
            And   Close browser            