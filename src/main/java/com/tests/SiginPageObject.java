package com.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginPageObject
{
	WebDriver driver;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sumbitButton;
	@FindBy(xpath="//div[@id='errors1']/span")
	private WebElement errorString;
	
	public SiginPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public SiginPageObject swithToFrame()
	{
		driver.switchTo().frame("modal_window");
		return this;
	}
	public SiginPageObject clickOnSumitButtond()
	{
		sumbitButton.click();
		return this;
	}
	public String  getErrorString()
	{
		return errorString.getText();
	}
	
}
