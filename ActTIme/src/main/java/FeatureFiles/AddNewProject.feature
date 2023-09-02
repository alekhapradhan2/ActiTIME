Feature: Add New Project


Scenario Outline: Create New Project by giving all mandatory fields

Given i open the Application
When i login in application
When i click to Tasks
When i click Add new button
And i click New Project
When i Enter Project name as "<NewProjectName>"
When i Select existing customer name in dorpdown as at project box "<ExitCust>"
Then i give task name "<taskName>"
Then i set deadline "<date>"
When i click new project button
Then i should see that particular project name as "<NewProjectName>" in Task list page
Then i should see particular task name "<taskName>" in task list page
Then i should see correct deadline in tasklist "<date>"
When i logout the app
Then i close the browser

Examples:
|NewProjectName|ExitCust|taskName|date|
|Maruti Suzuki|Rajesh427|Make Wheel|31/January 2025|

