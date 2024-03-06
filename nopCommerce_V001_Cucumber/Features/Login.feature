Feature: Login

Scenario: Successful login with valid credentials
            Given User launch chrome browser
            When  User opens URL "https://admin-demo.nopcommerce.com/login"
            And   User enter email as "admin@yourstore.com" and password as "admin"
            And   Click on login
            Then  Page tittle should be "Dashboard / nopCommerce administration"
            When  User click on logout link
            Then  Page title should be "Your store. Login"
            And   Close browser
            
Scenario Outline: Data driven login
            Given User launch chrome browser
            When  User opens URL "https://admin-demo.nopcommerce.com/login"
            And   User enter email as "<email>" and password as "<password>"
            And   Click on login
            Then  Page tittle should be "Dashboard / nopCommerce administration"
            When  User click on logout link
            Then  Page title should be "Your store. Login"
            And   Close browser    
            
            Examples:
            | email | password |
            | admin@yourstore.com | admin |
            | admin001@yourstore.com | admin123 |       


