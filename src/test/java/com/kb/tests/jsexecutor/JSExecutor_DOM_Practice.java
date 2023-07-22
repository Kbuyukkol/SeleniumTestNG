package com.kb.tests.jsexecutor;

import com.kb.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class JSExecutor_DOM_Practice {

    WebDriver driver = Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;


    @Test
    public void newWindowWithJS() {

        driver.get("https:www.google.com");

        //js.executeScript("window.open('https://www.example2.com','_blank');");
        js.executeScript("window.open('https://www.example2.com');");

    }

    @Test
    public void historyBackWithJS() {

        driver.get("https:www.google.com");

        driver.get("https://www.example2.com");
        js.executeScript("history.back();");

    }

    @Test
    public void locationWithJS() {

        driver.get("https:www.example2.com");

        String origin = (String) js.executeScript("return location.origin;");
        String port = (String) js.executeScript("return location.port;");
        String protocol = (String) js.executeScript("return location.protocol;");

        // Print the screen properties
        System.out.println("Origin: " + origin);
        System.out.println("Port: " + port);
        System.out.println("Protocol: " + protocol);

    }
    @Test
    public void screenWithJS() {

        driver.get("https:www.google.com");

        long screenWidth = (Long) js.executeScript("return window.screen.width;");
        long screenHeight = (Long) js.executeScript("return window.screen.height;");
        long colorDepth = (Long) js.executeScript("return window.screen.colorDepth;");

        // Print the screen properties
        System.out.println("Screen Width: " + screenWidth);
        System.out.println("Screen Height: " + screenHeight);
        System.out.println("Color Depth: " + colorDepth);

    }
    @AfterMethod
    public void tearDown() {
        //Driver.closeDriver();
    }
}

