## Web selenium test automation details

#### Details

```text
   Website under test: https://the-internet.herokuapp.com/
   Tool: Selenium Webdriver
   Language: JAVA
   Reporting: Allure
   Test Runner: TestNG
   Logging: Log4j2 - See logs/debug.log
   Target Machine: Local
   Test Data: Faker Library & properties file
   Assertion: AssertJ library
```
#### Pre-requisite:

* Maven (brew install maven)
* Java
* Allure (brew install allure)
    
#### How to execute

 * We will use maven commands to trigger our tests. All the Tests will run on Chrome & Opera in parallel.
 Also no need to configure driver executable, framework will detect your browser version and download compatible
  driver to run the tests
 
    ```bash
    mvn clean test 
    ```
   
 * To run only certain group tests, use following command
    ```bash
    mvn clean test -Dgroups="smoke"
    mvn clean test -Dgroups="checkout"
    ``` 
 * Tests are run in parallel as per the classes with thread-count: 4  

#### Open Reports

 * Allure reporting artifacts are generated in target/allure-results. One can open allure HTML report with following
  command in terminal. It also takes screenshot and attach to report in case test fails anytime.
  
    ```bash
    allure serve target/allure-results  
    ```
* Sample local run is attached as [ReportSample.png](ReportSample.png)
