package com.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageObject {
	
	
	WebDriver driver;
	@FindBy(linkText="Your trips")
	private WebElement yourTripLink;
	@FindBy(id="SignIn")
	private WebElement signInLink;
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;
	public HomepageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public HomepageObject clickOnYourTripLink()
	{
		yourTripLink.click();
		return this;
	}
	public SiginPageObject clickOnsignINLink()
	{
		signInLink.click();
		
		return new SiginPageObject(driver);
	}
	
	public HotelPageObject clickOnHotelLink()
	{
		hotelLink.click();
		return new HotelPageObject(driver);
	}
	
}
