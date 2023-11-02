# The test environment requirement 
- Java JDK 21.x
- Maven 3.9.5
- Allure report 2.24.1
 
 # Allure reporter
1. <space>Install Scoop <space>
   a.  <space> Set-ExecutionPolicy RemoteSigned -Scope CurrentUser # Optional: Needed to run a remote script the first time  <space>
   b.  <space> Select 'A'  <space>
   c. iex "& {$(irm get.scoop.sh)} -RunAsAdmin"
   d. scoop install allure
   link doc: https://github.com/allure-framework/allure2
   
# Run the test 
1.run test: mvn clean test -Dfile="your test xml direct"
2.Run generate report: allure generate .\allure-results\ --clean

