package com.ITlearn3.pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage 
{
	WebDriver driver ;
	public PaymentPage(WebDriver d ) 
	{
		driver =d  ; 
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath = "//label[@for='payment_method_stripe']")WebElement payWithStripe_radio ;
	@FindBy(xpath = "//input[@class='button alt onpayment']")WebElement placeOrder  ;
	
	@FindBy(xpath = "//input[@name='cardnumber']")WebElement card_Number ;
	@FindBy(xpath = "//input[@name='exp-date']")WebElement card_ExpireDate;
	@FindBy(xpath = "//input[@name='cvc']")WebElement card_CVC;
	@FindBy(xpath = "//*[@id='card-element']/div/iframe")WebElement frameElement ;
	
	@FindBy(id = "payment-button")WebElement pay_now;
	
	public void paymentPortal(String cardNumber,String expiryDate , String cvc)
	{
		payWithStripe_radio.click();
		placeOrder.submit();
		
		driver.switchTo().frame(frameElement);
		
		card_Number.sendKeys(cardNumber);
		card_ExpireDate.sendKeys(expiryDate);
		card_CVC.sendKeys(cvc);
		
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pay_now.click();
		
		
		
		
	}
	
	
}
