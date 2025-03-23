# Selenium TestNG Java Project

## Introduction
This project is a Selenium-based test automation framework using TestNG for executing test cases. It provides an organized structure for running UI automation tests for web applications.

## Prerequisites
Ensure you have the following installed before setting up the project:
- Java Development Kit (JDK 11 or later)
- Apache Maven
- IntelliJ IDEA / Eclipse (or any preferred IDE)
- Google Chrome / Firefox (or any supported browser)
- WebDriver for the chosen browser

## Project Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/POS_Test.git
   ```
2. Navigate to the project directory:
   ```sh
   cd POS_Test
   ```
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```

## Running Tests
### Using Maven
To run all tests:
```sh
mvn test
```

To run specific test suite:
```sh
mvn clean test -DsuiteXmlFile=testng.xml
```

### Using TestNG in IDE
1. Open `testng.xml`
2. Right-click and select `Run As 'testng.xml'`

## Reports
After test execution, ExtentReports report is generated in the `Selenium
POS/QuotationTestReport.html`

## Notes
Uploaded test execution video for reference, refer 
```sh
TestExecutionVideo.gif
```

