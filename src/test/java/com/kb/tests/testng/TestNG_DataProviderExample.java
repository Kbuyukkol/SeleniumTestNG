package com.kb.tests.testng;

import com.kb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProviderExample {

    WebDriver driver;

    @Test(dataProvider = "searchData")
    public void test1(String keyword, String expectedTitle) {
        driver = Driver.getDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword + Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), expectedTitle);


    }

    @DataProvider(name = "searchData")
    public Object[][] testData() {


        return new Object[][]{
                {"selenium", "selenium - Google Search"},
                {"java", "java - Google Search"},
                {"job", "job - Google Search"},
        };
    }
}
