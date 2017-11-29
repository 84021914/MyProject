package com.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility 
{
	public static void waitUntilElementVisible(WebDriver driver, By locator )
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		try {
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public static boolean isElementPresent(By by,WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	public static void selectFromDropDown(List <WebElement> list, String ContentToBeSleted )
	{
		for(WebElement e:list)
		{
			if(e.getText().contains(ContentToBeSleted))
			{
				e.click();
				break;
			}
		}
	}
}
