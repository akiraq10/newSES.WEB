# The test environment requirement 
- Java JDK 21.x
- Maven 3.9.5
- Allure report 2.24.1
 
 # Allure reporter
1. install Scoop <br>
   a. Set-ExecutionPolicy RemoteSigned -Scope CurrentUser # Optional: Needed to run a remote script the first time <br>
   b. select 'A' <br>
   c. iex "& {$(irm get.scoop.sh)} -RunAsAdmin"<br>
   <br>
2. Install alure: scoop install allure <br>
   link doc: https://github.com/allure-framework/allure2
   
# Run the test 
1.run test: mvn clean test -Dfile="your test xml direct"<br>
2.Run generate report: allure generate .\allure-results\ --clean<br>

