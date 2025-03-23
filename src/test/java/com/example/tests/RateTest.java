package com.example.tests;

import com.example.base.BaseTest;

import com.example.pages.RatePage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RateTest extends BaseTest {
	private RatePage ratePage;

	@BeforeMethod
	public void openMainPage() {

		ratePage = new RatePage(driver); // Instantiate LoginPage once before every test
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Pos Malaysia"));
	}


	public void rateFinder(String fromPostcode, String toCountry, String parcelWeight) throws InterruptedException {
		ratePage.enterFromPostCode(fromPostcode);
		ratePage.enterToCountry(toCountry);
		ratePage.enterWeight(parcelWeight);
		ratePage.calculateBtnClick();
		ratePage.quoteDsisplayed();
		
	}
	
	@Test
	public void quotation () throws InterruptedException, IOException {
		rateFinder("35600", "India", "1");
		
		List<WebElement> quotes = ratePage.countQuotes();
		
		// Assert that at least one element is found
		Assert.assertTrue(quotes.size() > 0, "Test Failed: No matching elements found.");
		
		//Print count for debugging
        System.out.println("Test Passed: Found " + quotes.size() + " quotes.");
        
		
	}
	

}
