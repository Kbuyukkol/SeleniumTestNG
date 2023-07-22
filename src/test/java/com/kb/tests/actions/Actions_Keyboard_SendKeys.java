package com.kb.tests.actions;

import com.kb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Actions_Keyboard_SendKeys {


    @Test
    public void keyboardTest() {
        Driver.getDriver().get("https://www.selenium.dev/selenium/web/single_text_input.html");

        Actions actions = new Actions(Driver.getDriver());
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .perform();

        WebElement textField = Driver.getDriver().findElement(By.id("textInput"));
        Assert.assertEquals("Ab", textField.getAttribute("value"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

