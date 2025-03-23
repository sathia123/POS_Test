package com.example.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RatePage {
    WebDriver driver;

    
    private By fromPostcodeField = By.xpath("//div[@class='d-flex mt-4']//input[@placeholder='Postcode']");
    private By toCountryField = By.xpath("//input[@id='mat-input-0']");
    private By toCountryList = By.xpath("//small[contains(text(),'India - IN')]");
    private By weightField = By.xpath("//input[@placeholder='eg. 0.1kg']");
    private By calculateBtn = By.xpath("//a[contains(text(),'Calculate')]");
    private By displayQuaote = By.xpath("//h1[contains(text(),'Your Quote')]");
    


    public RatePage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterFromPostCode(String fromPostcode) {
        driver.findElement(fromPostcodeField).sendKeys(fromPostcode);
    }
    
    public void enterToCountry(String toCountry) throws InterruptedException {
    	driver.findElement(toCountryField).clear();
        driver.findElement(toCountryField).sendKeys(toCountry);   
        Thread.sleep(1000);
        driver.findElement(toCountryList).click();
        
    }
    
    public void enterWeight(String parcelWeight)  {
    	 
        driver.findElement(weightField).sendKeys(parcelWeight);
    
    }
    
    public void calculateBtnClick()  {
   	 
        driver.findElement(calculateBtn).click();
    
    }
    
    public void quoteDsisplayed()  {
      	 
        driver.findElement(displayQuaote).isDisplayed();
    
    }
    
    public List<WebElement> countQuotes() {
    	// Locate the 'Service Type' elements
        List<WebElement> serviceTypeElements =  driver.findElements(By.xpath("//dt[text()='Service Type']"));
        
        return serviceTypeElements;
    }
}
