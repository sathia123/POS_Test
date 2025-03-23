package com.example.base;
import com.example.utils.ConfigReader;
import com.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    private ConfigReader configReader;

    @BeforeMethod
    public void setup() {
    	configReader = new ConfigReader();
        String browser = configReader.getProperty("browser");  // Get the browser from the config file
        driver = WebDriverFactory.getDriver(browser);  // Initialize the WebDriver dynamically
        driver.get("https://pos.com.my/send/ratecalculator");  
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
