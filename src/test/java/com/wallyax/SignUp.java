package com.wallyax;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import pageobject.WallyaxPage;


public class SignUp {
	
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.edge.driver", "C:\\Users\\M\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        
        WebDriver driver = new EdgeDriver();
        
        driver.manage().window().maximize();
        
        WallyaxPage signUpPage = new WallyaxPage(driver);
        
        driver.get("https://app-next.wallyax.com/get-started");
        
        signUpPage.enterText("sabemigoje@rungel.net");
        signUpPage.clickSubmit();
        
        Thread.sleep(5000);
        
        signUpPage.enterEmail("sabemigoje@rungel.net");
        signUpPage.enterPassword("Assessment@12");
        signUpPage.clickSubmit();
        
        Thread.sleep(5000);
        
        String actualText = signUpPage.getDomainText();
        String expectedText = "https://www.domain.com";
        assertEquals(expectedText, actualText);
        
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String screenshotPath = "C:\\Users\\M\\Downloads\\screenshot.png";

        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save the screenshot.");
        }
        
        driver.quit();
		
	}
	

}
