package com.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPageObject 
{
	WebDriver driver;
	
	@FindBy(id="FromTag")
	private WebElement from;
	@FindBy(id="ToTag")
	private WebElement to;
	@FindBy(id="ui-id-34")
	private WebElement bootstrapdropDown;
	@FindBy(xpath="//body/ul[@id='ui-id-1']/li/a")
	private List <WebElement> fromList;
	@FindBy(xpath="//body/ul[@id='ui-id-2']/li/a")
	private List <WebElement> toList;
	private By fromLocator=By.xpath("//body/ul[@id='ui-id-1']");
	private By toLocator=By.xpath("//body/ul[@id='ui-id-2']");
	@FindBy(className="ui-datepicker-month")
	private WebElement month;
	@FindBy(className="nextMonth ")
	private WebElement nextMonth;
	@FindBy(xpath="//table[@class='calendar']/tbody/tr/td")
	private List <WebElement> dateList;
	@FindBy(id="SearchBtn")
	private WebElement searchButton;
	
	public FlightPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public  FlightPageObject enterBoadringStation(String boadingPoint)
	{
		from.clear();
		from.sendKeys(boadingPoint);
		CommonUtility.waitUntilElementVisible(driver,fromLocator);
		CommonUtility.selectFromDropDown(fromList,boadingPoint);
		return this;
	}
	public  FlightPageObject enterDropStation(String dropPoint)
	{
		to.clear();
		to.sendKeys(dropPoint);
		CommonUtility.waitUntilElementVisible(driver,toLocator);
		CommonUtility.selectFromDropDown(toList,dropPoint);
		return this;
	}
	public  FlightPageObject selectDate(String mont,String date)
	{
		do {
			if(month.getText().equals(mont))
			{for(WebElement e:dateList)
			{
				if(e.getText().equals(date))
				{
					e.click();
					break;
				}
				
			}
			break;
			}
			nextMonth.click();
		}while(true);
		return this;
	}
	public void clickONSearchbutton()
	{
		searchButton.click();
	}
}
