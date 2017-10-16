Meta:

Narrative:
In order to make loan
As an admin
I want to fill the input, submit the form and check the return message

Scenario: Open Loans Page
Given User on loan Page

Scenario: Success Loan Case
When User clicks on menu Make Loan <"//a[@href='loan']">
And User clicks on targetAccount <id = targetAccount>
And User select his accountNumber<id = targetAccount == 0>
And User fills the amount <id = ammount>
And User Score > 0
And User Balance >= 2000
And Amount <= Balance * .3

Then The return message for Make Loan is <message>
Examples:
|amount   	                |message 						  |
|amount <= Balance * .3     |Operation completed with success |
|score > 0                  |Operation completed with success |
|user Balance >= 2000$      |Operation completed with success |


Scenario: Fail Loan with negative Score
When User Score < 0
Then The return message for Make Loan is <message>
Examples:
|score   	                |message 						          |
|score <0                   |There is a pending loan for this account |

Scenario: Fail Loan with no minumum Balance Required
When User Balance < 2000$
Then The return message for Make Loan is <message>
Examples:
|balance  	                |message 						          |
|balance < 2000$            |There is a pending loan for this account |

Scenario: Fail Loan with exceeded Amount
When User Balance < 2000$
Then The return message for Make Loan is <message>
Examples:
|amount  	                |message 						          |
|amount > 30% total Balance |There is a pending loan for this account |







