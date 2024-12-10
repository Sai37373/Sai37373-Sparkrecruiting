package com.GoogleSearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleHomePage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.name("q"); // The main search box
    private By suggestionList = By.cssSelector("ul[role='listbox'] li");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigating to Google homepage
    public void navigateToHomePage() {
        driver.get("https://www.google.com");
    }

    // Entering search query
    public void enterSearchQuery(String query) {
        WebElement inputField = driver.findElement(searchBox);
        inputField.clear();
        inputField.sendKeys(query);
    }

    // Checking if suggestions are displayed
    public boolean areSuggestionsDisplayed() {
        List<WebElement> suggestions = driver.findElements(suggestionList);
        return suggestions.size() > 0;
    }

    // Getting the size of suggestions
    public int getSuggestionsCount() {
        List<WebElement> suggestions = driver.findElements(suggestionList);
        return suggestions.size();
    }
}