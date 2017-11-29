package com.tests;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest extends TestConfigurations {

	public HomepageObject h;
	public HotelPageObject hotelreferance;
    @BeforeMethod
    public void gotoSignUP()
    {  
    	
    	 h= new  HomepageObject(driver);
    	 hotelreferance=h.clickOnHotelLink();
    
    
    	
    }
    

    @Test
    public void shouldBeAbleToSearchForHotels() 
    {
    	hotelreferance.clicOnLocality("Indiranagar, Bangalore")//Entering the Location
    	.selectDate("January", "25"); //Selecting from date
    	CommonUtility.waitUntilElementVisible(driver,By.className("ui-datepicker-month"));//wait for to calander view
    	hotelreferance.selectDate("February", "25")// selecting to date
    	.ClickOnSearchbutton();//click on search button
    	Assert.assertTrue(CommonUtility.isElementPresent(By.className("searchSummary"),driver));   //validating Results 	    	

    	
        

    }

    
    

}
