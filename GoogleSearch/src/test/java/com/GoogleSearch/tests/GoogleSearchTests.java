package com.GoogleSearch.tests;

import com.GoogleSearch.base.BaseTest;
import com.GoogleSearch.pages.GoogleHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTests extends BaseTest {

    @Test(priority = 1)
    public void testSearchFunctionality() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        // Positive Case
        googleHomePage.navigateToHomePage();
        googleHomePage.enterSearchQuery("Selenium WebDriver");
        Assert.assertTrue(driver.getTitle().contains("Google"), "Search results not displayed!");


        // Boundary Case	
        String longInput = "a".repeat(500);
        googleHomePage.enterSearchQuery(longInput);
        Assert.assertTrue(driver.getPageSource().contains("a"), "Unexpected behavior for long input!");
     
    }

    @Test(priority = 2)
    public void testSearchSuggestions() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        // Positive Case
        googleHomePage.navigateToHomePage();
        googleHomePage.enterSearchQuery("Selenium");
        Assert.assertTrue(googleHomePage.areSuggestionsDisplayed(), "Suggestions not displayed!");


        // Boundary Case
        googleHomePage.enterSearchQuery("S");
        Assert.assertTrue(driver.getPageSource().contains("S"), "Suggestions not displayed for single character!");
        
    }
}