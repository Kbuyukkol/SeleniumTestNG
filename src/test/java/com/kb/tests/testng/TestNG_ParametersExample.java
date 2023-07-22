package com.kb.tests.testng;

import com.kb.utilities.BrowserUtils;
import com.kb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_ParametersExample {


        @Parameters({"firstSampleParameter"})
        @Test(enabled = true)
        public void firstTestForOneParameter(String firstSampleParameter) {
            Driver.getDriver().get(firstSampleParameter);

            WebElement allElement = Driver.getDriver().findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));

            allElement.click();

            //WebElement arrowElement1 = Driver.getDriver().findElement(By.xpath("//i[@class='nav-sprite hmenu-arrow-next'][1]"));

            WebElement arrowElement1 = Driver.getDriver().findElement(By.xpath("(//a[@class='hmenu-item'])[1]"));
            arrowElement1.click();

            BrowserUtils.sleep(3);
            WebElement headerElement = Driver.getDriver().findElement(By.xpath("//div[.='stream music']"));

            Assert.assertTrue(headerElement.isDisplayed());
        }

    }

