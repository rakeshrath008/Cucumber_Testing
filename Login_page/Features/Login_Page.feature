Feature: Login page features
Descriprtion : This feature will test a login functionality

# Simple data send and verifying
#Scenario: Login with valid username and password
#Given : Open browser
#When : Enter the url "https://www.google.com"
#And : Send data to search bar " Quotus "
#And : Click on the enter button

# Multiple data sending....
#Scenario Outline: Login with valid username and password
#Given : Open browser
#When : Enter the url "https://www.google.com"
#And : Send data to search bar "<Datas> "
#And : Click on the enter button

#Examples:
#|Datas|
#|Quotus|
#|Rakesh|
#|Atish|

# Using data table with single input
#Scenario: Login with valid username and password
#Given : Open browser
#When : Enter the url "https://www.google.com"
#And : Send data to search bar data
#|Quotus|
#And : Click on the enter button

#Using data table with multiple data sending
Scenario Outline: Login with valid username and password
Given  Open browser
When  Enter the url "https://www.facebook.com/"
And  Enter registered username and password
|userName|password|
|Rakesh|Rakesh@123|
|Divya|Divya@123|
|Atish|Atish@123|
Then Verify the text