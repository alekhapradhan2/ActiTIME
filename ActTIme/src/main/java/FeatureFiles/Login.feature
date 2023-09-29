Feature: Login Function


Scenario: Validate Login With Valid Input
Given Hera i Open the applicaation
When i give valid username "admin" and valid password "manager"
And i click to Login button
Then i should see ActTimeHomePgae
When i click logout
Then i should see ActiTime LoginPage
Then i close browser

Scenario Outline: validation login function with invalid inputs
Given Hera i Open the applicaation
When i give invalid username "<username>" and invalid password "<password>"
And i click to Login button
Then i should see approprate Error Message
Then i close browser

Examples:
|username|password|
|Admin|managek|
|hgfjsh|manager|
|sjgfhsd|vhsagdfs|


