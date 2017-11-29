package com.tests;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest  extends TestConfigurations{

	public HomepageObject h;
	public SiginPageObject sr;
    @BeforeMethod
    public void gotoSignUP()
    {  
    	
    	 h= new  HomepageObject(driver);
    	sr=h.clickOnYourTripLink().clickOnsignINLink();
    
    
    	
    }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	String errors1=sr.swithToFrame()//switching to frame
    	.clickOnSumitButtond()// Click on Sumbit button
    	.getErrorString();//geting error String
    	Assert.assertTrue(errors1.contains("There were errors in your submission"));//Validation
    	
          
    }

   

  

}
