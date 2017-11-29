package com.tests;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends TestConfigurations {
	FlightPageObject f1;
	@BeforeMethod
	public void m()
	{
		f1= new  FlightPageObject(driver);
	}
    


    @Test
    public void testThatResultsAppearForAOneWayJourney() {

      f1.enterBoadringStation("Bangalore")//Entering from Station
      .enterDropStation("Delhi")//Entering to station
      .selectDate("December", "25") //selecting date
      .clickONSearchbutton();// click on Search button
      Assert.assertTrue(CommonUtility.isElementPresent(By.className("searchSummary"),driver));// Validation
      
       
      

    }
   

   
}
