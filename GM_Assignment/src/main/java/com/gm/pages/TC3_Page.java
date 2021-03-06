package com.gm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC3_Page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section[2]/div[1]/div/div[1]/form/div/input")
	WebElement searchFld;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section[3]/div/div/div[1]/div[1]/a/div/div/div[1]/picture/img")
	WebElement firstImage;

	@FindBy(xpath = "//*[@id='details']/div/section[3]/div[1]/h4/button")
	WebElement ObjectgegevensLbl;

	@FindBy(xpath = "//*[@id='details']/div/section[3]/div[1]/div/section/dl/div[1]/dd")
	WebElement F_nummer;

	@FindBy(xpath = "//*[@id='details']/div/section[3]/div[1]/div/section/dl/div[2]/dd")
	WebElement JH_nummer;

	@FindBy(xpath = "//*[@id='details']/div/section[3]/div[1]/div/section/dl/div[3]/dd")
	WebElement Inventarisnummer;

	boolean flag;

	public TC3_Page(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean imageVeification() throws InterruptedException {

		searchFld.clear();
		searchFld.sendKeys("Het Gele Huis");

		searchFld.sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		firstImage.click();

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ObjectgegevensLbl);

		Thread.sleep(5000);

		ObjectgegevensLbl.click();

		Thread.sleep(5000);

		System.out.println("************" + JH_nummer.getText());

		flag = (F_nummer.getText()).equalsIgnoreCase("F0464") && (JH_nummer.getText()).equalsIgnoreCase("JH1589")
				&& (Inventarisnummer.getText().equalsIgnoreCase("s0032V1962"));

		return flag;

	}

}
