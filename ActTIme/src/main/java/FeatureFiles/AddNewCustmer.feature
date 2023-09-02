Feature: Add New Customer
Scenario Outline: Create New Customer by giving all mandatory fields

Given i open the Application
When i login in application
When i click to Tasks
Then i should see Task list page
When i click Add new button
And i click New Customer
When i Enter Customer name as "<NewCustName>"
And i click create customer button
Then i should see that particular customer name as "<NewCustName>" in Task list page
When i search for this custumer name "<NewCustName>"
Then my application should show the appropreate customername "<NewCustName>"
When i click Add new button
And i click New Customer
When i Enter Customer name as a "<NewCustmer1>"
When i Select existing customer name in dorpdown as "<NewCustName>"
And i click create customer button
Then i should see that particular customer name as a "<NewCustmer1>" in Task list page
When i search for this custumer name as a "<NewCustmer1>"
Then my application should show the appropreate customername as a "<NewCustmer1>"
When i logout the app
Then i close the browser
Examples:
|NewCustName|NewCustmer1|
|Rajesh|Rajesh|








