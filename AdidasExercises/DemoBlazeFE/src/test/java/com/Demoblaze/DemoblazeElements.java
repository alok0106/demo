package com.Demoblaze;

import org.openqa.selenium.By;

public class DemoblazeElements {

	int i,j;
	By phones = By.linkText("Phones");
	By laptops = By.linkText("Laptops");
	By monitors = By.linkText("Monitors");
	By sonyVaioI5Laptop = By.linkText("Sony vaio i5");
	By addToCart = By.linkText("Add to cart");
	By dellI78GbLaptop = By.linkText("Dell i7 8gb");
	By cartLink = By.linkText("Cart");
	By homeLink = By.xpath("/html/body/nav/div/div/ul/li[1]/a");
	By dellDelete = By.linkText("Delete");
	By listOfLaptops = By.xpath("//*[@id='tbodyid']/tr");
	//By nameOfLaptops = By.xpath()
	By placeOrderButton = By.xpath("//button[text()=('Place Order')]");
	By nameTxtbox = By.id("name");
	By countryTxtbox = By.id("country");
	By cityTxtbox = By.id("city");
	By creditcardTxtbox = By.id("card");
	By monthTxtbox = By.id("month");
	By yearTxtbox = By.id("year");
	By purchaseButton = By.xpath("//button[text()=('Purchase')]");
	By expectedAmount = By.id("totalp");
	By purchaseDetails = By.xpath("/html/body/div[10]/p");
	By actualAmount = By.xpath("/html/body/div[10]/p/br[1]");
	By okButton = By.xpath("//button[text()=('OK')]");
	String dellXpath;
	String dellDeleteXpath;
	
	public By getDellXpath() {
		
		return By.xpath(dellXpath);
	}
	public By getDellDeletexpath() {
		
		return By.xpath(dellDeleteXpath);
	}
	public void setDellXpath(int i) {
		this.dellXpath = "//*[@id='tbodyid']/tr["+i+"]/td[2]";
	}
	public void setDellDeleteXpath(int i) {
		this.dellDeleteXpath = "//*[@id='tbodyid']/tr["+i+"]/td[4]/a";
	}
	

	
}
