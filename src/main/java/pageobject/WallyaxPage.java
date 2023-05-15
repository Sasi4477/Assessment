package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallyaxPage {
	
	
	 WebDriver driver;
	    
	    public WallyaxPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//input[@type='text']")
	    WebElement textbox;
	    
	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement submitButton;
	    
	    @FindBy(xpath = "//input[@type='email']")
	    WebElement email;
	    
	    @FindBy(xpath = "//input[@type='password']")
	    WebElement password;
	    
	    @FindBy(xpath = "//p[contains(text(),'https://www.domain.com')]")
	    WebElement domainText;
	    
	    public void enterText(String text) {
	        textbox.sendKeys(text);
	    }
	    
	    public void clickSubmit() {
	        submitButton.click();
	    }
	    
	    public void enterEmail(String emailText) {
	        email.sendKeys(emailText);
	    }
	    
	    public void enterPassword(String passwordText) {
	        password.sendKeys(passwordText);
	    }
	    
	    public String getDomainText() {
	        return domainText.getText();
	    }
	    
	}
