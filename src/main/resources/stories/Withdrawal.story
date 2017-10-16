Meta:

Narrative:
In order to withdraw
As an admin
I want to fill the input, submit the form and check the return message

Scenario: User on Withdraw Page
Given User on Withdraw Page

Scenario: Success Withdraw Case
When User clicks on menu Withdraw <"//a[@href='withdraw']">
And User clicks on targetAccount <id = targetAccount>
And User select his accountNumber<id = targetAccount == 0>
And User fills the amount <id = ammount>
And User Balance >= Withdraw


Then The return message for Withdrawn is <message>
Examples:
|withdraw  	                |message 						  |
|Balance >= Withdraw        |Operation completed with success |

Scenario:
When User Balance < Withdraw
Then The return message for Withdrawn is <message>
Examples:
|withdraw 	         |message 						                                  |
|Balance < Withdraw  |Operation not completed, your balance is less than your withdraw|
