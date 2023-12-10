Feature: Login Functionality

		In order to do internet banking 
		As a valid Para Bank customer 
		I want to login successfully 

@Login		
Scenario Outline: Login successful

Given I am in the login page of the para bank application
When  I enter valid with <username> and <password> with <userFullName>
Then  I should be taken to the Overview page 

Examples: 
|username|password|userFullName|
|"Hany_Tester"|"1729"|"Ashraf"|


		