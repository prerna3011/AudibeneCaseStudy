## Audibene Task

#### 1. Details

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

#### 2. Objective:

The objective of this automation task is to automate the following test cases

1. Login  test case for https://the-internet.herokuapp.com/login
2. Check test spring by last names and first names for tables in https://the-internet.herokuapp.com/tables
3. Test that click opens a new browser tab or window from https://the-internet.herokuapp.com/tables
4. Check enable/disable input field on

API test:
1. To show that the successful request returns a list of fixed categories containing n-amount of items (https://api.chucknorris.io/jokes/categories )
2. To pick one of the categories from the step before und use it in the freetext search request and make sure that each of the returned items contains the query string in the returned JSON (https://api.chucknorris.io/jokes/search?query={})

#### 3. Pre-requisite:

* Maven (brew install maven)
* Java (jdk1.8)
* Allure (brew install allure)
    

#### 4. How to execute

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

#### 5. Open Reports

 * Allure reporting artifacts are generated in target/allure-results. One can open allure HTML report with following
  command in terminal. It also takes screenshot and attach to report in case test fails anytime.
  
    ```bash
    allure serve target/allure-results  
    ```
* Sample local run is attached as [ReportSample.png](ReportSample.png)
