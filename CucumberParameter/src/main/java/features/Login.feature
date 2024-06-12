Feature: Leaftaps application Login functionality
Scenario Outline: Leaftaps application with valid credentials
Given Open the chrome browser
And Load the application url
And Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then Homepage should be displayed
Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'Democsr'|'crmsfa'|

