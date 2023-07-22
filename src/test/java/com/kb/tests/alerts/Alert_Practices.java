package com.kb.tests.alerts;

import com.kb.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = Driver.getDriver();

        //2. Go to website: https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    public void alert_test1() throws InterruptedException {
        //3. Click to “Click me” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));


        informationAlertButton.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();




    }
    @Test
    public void alert_test2() throws InterruptedException {
        //3. Click to “Click me” button
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));


        confirmationAlertButton.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You selected Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//span[@id='confirmResult']"));

        //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String expectedText = "You selected Ok";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is not as expected!!!");



    }
    @Test
    public void alert_test3() throws InterruptedException {
        //3. Click to “Click me” button
        WebElement promptAlertButton = driver.findElement(By.xpath("(//button[@type='button'])[5]"));

        driver.wait(2000);
        promptAlertButton.click();


        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.sendKeys("hello");
        alert.accept();

        //5. Verify “You entered:” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("promptResult"));

        //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String expectedText = "You entered hello";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is not as expected!!!");



    }
}
