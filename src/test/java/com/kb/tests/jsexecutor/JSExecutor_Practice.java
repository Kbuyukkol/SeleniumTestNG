package com.kb.tests.jsexecutor;

import com.kb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JSExecutor_Practice {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setupTest() {

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void T01_calculatorJavaScriptTest() {
        driver.navigate().to("http://www.anaesthetist.com/mnm/javascript/calc.htm");
        driver.manage().window().maximize();
        //1-) Click "9"
        driver.findElement(By.name("nine")).click();

        //2-) Click "+"
        driver.findElement(By.name("add")).click();

        //3-) Click "3"
        driver.findElement(By.name("three")).click();

        //4-) Declare JavaScriptExecutor and call "Calculate()" function
        js.executeScript("Calculate();");

        //5-) Assert that result is 12
        WebElement result = driver.findElement(By.name("Display"));
        Assert.assertEquals("12", result.getAttribute("value"));

    }

    @Test
    public void T02_jsExamples() throws InterruptedException {
        driver.navigate().to("https://www.swtestacademy.com");

        //JS alert
        js.executeScript("alert('SW Test Academy!');");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //JS get title
        String title = js.executeScript("return document.title;").toString();
        Assert.assertEquals(title, driver.getTitle());
        Thread.sleep(1000);

        //JS Refresh
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0);");
        Thread.sleep(1000);

        //Goto Blog Page
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//ul//li//a[contains(@href, 'blog')]")).apply(driver).click();

        //JS Scroll
        WebElement secondArticle = driver.findElement(By.cssSelector("article:nth-of-type(2)"));
        WebElement twelfthArticle = driver.findElement(By.xpath("//article[12]"));
        js.executeScript("arguments[0].scrollIntoView(true);", twelfthArticle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", secondArticle);

        //JS Highlight
        js.executeScript("arguments[0].style.border='3px dotted blue'", secondArticle);
        Thread.sleep(1000);

        //JS hide an element
        js.executeScript("document.querySelector('article:nth-of-type(2)').style.display='none'");
        Thread.sleep(1000);

        //JS show an element
        js.executeScript("document.querySelector('article:nth-of-type(2)').style.display='block'");
        Thread.sleep(1000);

        //JS click and type text
        WebElement logo = driver.findElement(By.cssSelector(".header-image.is-logo-image"));
        WebElement searchBox = driver.findElement(By.cssSelector("form > label > input"));
        js.executeScript("arguments[0].scrollIntoView(true);", logo);
        js.executeScript("arguments[0].click();", searchBox);
        js.executeScript("document.querySelector('form > label > input').value = 'SW Test Academy'");
        Thread.sleep(3000);

        //JS Navigate to Other Page
        js.executeScript("window.location = 'https://www.swtestacademy.com/'");
        Thread.sleep(1000);
    }

    @Test
    public void T03_createAnAnonymousFunction() {
        driver.navigate().to("https://www.swtestacademy.com");

        //Create an anonymous function
        //Change title with JavascriptExecutor
        js.executeScript("document.title='Title is changed manually!';");
        Assert.assertEquals("Title is changed manually!", driver.getTitle());

        //Create an anonymous function that will stored and added into the global window
        js.executeScript("window.changeTitle = function(){document.title='Title is changed by function!';};" +
                "window.changeTitle.call();");
        Assert.assertEquals("Title is changed by function!", driver.getTitle());

        //Change title manually
        js.executeScript("document.title='Title is changed manually!';");
        Assert.assertEquals("Title is changed manually!", driver.getTitle());

        //Change title with Function
        js.executeScript("window.changeTitle.call();");
        Assert.assertEquals("Title is changed by function!", driver.getTitle());
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}