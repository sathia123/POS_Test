package com.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ExtentTestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;


    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
    	ExtentSparkReporter spark = new ExtentSparkReporter("QuotationTestReport.html");
    	
    	 spark.config().setReportName("Get Quote - Interview Test");
         spark.config().setTheme(Theme.STANDARD);
     
         
        extent = new ExtentReports();
        
     // Add environment details
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Location", "New Zealand");
        extent.setSystemInfo("Browser", "Chrome");
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Start a new test in the report
        test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Sathia");
    }

    @Override
    public void onTestSuccess(ITestResult result) {	
        // Mark the test as passed in the report
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Mark the test as failed in the report
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Mark the test as skipped in the report
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write the report to file
        extent.flush();
    }
}
