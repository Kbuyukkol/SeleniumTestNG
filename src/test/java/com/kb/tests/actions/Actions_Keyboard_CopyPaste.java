package com.kb.tests.actions;

import com.kb.utilities.BrowserUtils;
import com.kb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions_Keyboard_CopyPaste {


    @Test
    public void copyPaste() {
        Driver.getDriver().get("https://www.google.com/account/about/");

        WebElement element = Driver.getDriver().findElement(By.xpath("//*[text() = 'Create an account']"));

        element.click();
        //Driver.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        WebElement firstName = Driver.getDriver().findElement(By.id("firstName"));
        WebElement userName = Driver.getDriver().findElement(By.id("lastName"));

        firstName.sendKeys("kamuran");

        Actions actions = new Actions(Driver.getDriver());

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        BrowserUtils.sleep(2);

        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        BrowserUtils.sleep(2);

        userName.click();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        BrowserUtils.sleep(2);

        Driver.getDriver().close();
    }
    @Test
    public void copyAndPaste() {
        Driver.getDriver().get("https://www.selenium.dev/selenium/web/single_text_input.html");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        WebElement textField = Driver.getDriver().findElement(By.id("textInput"));
        new Actions(Driver.getDriver())
                .sendKeys(textField, "Selenium!")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xvv")
                .keyUp(cmdCtrl)
                .perform();

        Assert.assertEquals("SeleniumSelenium!", textField.getAttribute("value"));
    }
}

