## Converting the existing project to maven and running the test cases from terminal

## Task1:Converting existing project to maven
Done

## Task2:Pass the browser from mvn command to execute the tests

Unit tests: 
- AddingToCartTest
- CreateAccountTest

Integration tests: 
- IntegrationTestIT

If we don't give the browser in command the default browser is chrome

For unit tests the commands used are:
- mvn -Dtest=<AddingToCartTest/CreateAccountTest> -Dbrowser=<chrome/firefox> test (To run specific unit test using specific browser)
- mvn -Dbrowser=<chrome/firefox> test (To run all the unit tests with specific browser)
- mvn -Dtest=<AddingToCartTest/CreateAccountTest> test(it will run specific test with default browser as chrome)

## Task3:Creating profiles(testing and staging) with property has url

Profiles:
- testing          
- staging

The commands used to run the profiles are:
- mvn -P<staging/testing> -Dtest=<AddingToCartTest/CreateAccountTest> -Dbrowser=<chrome/firefox> test 

## If we want run the integration tests
The command used is
- mvn failsafe:integration-test failsafe:verify
