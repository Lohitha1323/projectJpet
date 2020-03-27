Feature: TestCases 
	Test case one
	
Background: Below are the common steps for each scenario 
	Given User Launch browser with JpetStorePage 
	
	Scenario Outline: Register and Login 
	When User click on Sign In botton and click on Register Now! 
	And User enters User Id as "<userId>" and  New password as "<password>" and Repeat password as "<password>" 
	And User enters First name as "<firstName>" and Last name as "<lastName>" and Email as "<email>" and Phone as "<phone>" and AddressOne as "<addressOne>" and AddressTwo as "<addressTwo>" and City as "<city>" and State as "<state>" and Zip as "<zip>" and Country as "<country>" 
	And User selects Language Preference as English and Favourite Category as DOGS and Enable MyList and Enable MyBanner 
	And User click on Save Account Information 
	And User click on Sign In botton and enters User Id as "<userId>" and password as "<password>" and click on Login 
	Then Assert for presence of Sign Out 
	
	Examples: 
		| userId | password |password| firstName | lastName | email | phone | addressOne | addressTwo | city | state | zip | country |
	|lohitha@31|lohiii|lohiii|Lohithaa|Agarapu|lohita398@gmail.com|1213567800|Chittoor|bangarupalem|chittoor|Andhra Pradesh|583157|India|
	|lohitha@60|lohitha|lohitha|Lohitha|Agarapu|lohitha989@gmail.com|1224567889|Bangalore|yedhoka uru|Bangalore|Karnataka|613042|India|
	
Scenario Outline: Check Valid Login 
	When User click on Sign In botton and enters User Id as "<userId>" and password as "<password>" and click on Login 
	Then Assert for presence of Sign Out 
	Examples: 
		| userId | password |
	|lohitha@a|lohitha|
	|lohitha@34|lohitha|
	
	Scenario:  Check Invalid login 
	When clickon signin and enter username "batch6" and password as "lohi" 
	Then assert error message
		
Scenario: Search 
	When User Search for "Fish" and click on search 
	Then Assert for presence of GoldFish and close browser 
	
	Scenario: Adding Cat to the cart and proceed to checkout 
	When User fill login details User Id as "lohitha@a" and password as "lohitha" 
	And  buy Cat 
	Then Assert for Suucessful CheckOut and close browser 
	
	Scenario: Navigate front 
	When User fill login details User Id as "lohitha@a" and password as "lohitha"
	And navigate front 
	Then close the browser 
	
Scenario: placing dog and fish combine 
	When User fill login details User Id as "lohitha@a" and password as "lohitha" 
	And selecting two products and checkout 
	Then close the browser 
	
Scenario: Check Signout 
	When User fill login details User Id as "lohitha@a" and password as "lohitha"
	And check signout happens or not 
	Then close the browser 
	

	
#	