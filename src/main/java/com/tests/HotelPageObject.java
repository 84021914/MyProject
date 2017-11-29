package com.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPageObject {
	WebDriver driver;
    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    private By locator=By.xpath("//body/ul[@id='ui-id-1']");
    @FindBy(xpath="//body/ul[@id='ui-id-1']/li/a")
	private List <WebElement> locationList;
    public HotelPageObject(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public  HotelPageObject  clicOnLocality(String location)
    {
    	localityTextBox.clear();
    	localityTextBox.sendKeys(location);
    	CommonUtility.waitUntilElementVisible(driver,locator);
    	CommonUtility.selectFromDropDown(locationList,location);
    	
    	return this;
    }
    public HotelPageObject selectDate(String month,String date)
    {
    	FlightPageObject f= new FlightPageObject(driver);
    	f.selectDate(month, date);
    	return this;
    }
    public  HotelPageObject  ClickOnSearchbutton()
    {
    	searchButton.click();
    	return this;
    }
}
