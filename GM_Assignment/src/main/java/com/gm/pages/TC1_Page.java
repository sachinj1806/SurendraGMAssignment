package com.gm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC1_Page {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section/article[5]/section[1]/ul/li[1]/a")
	WebElement lnkOntdek_de_collective;

	@FindBy(xpath = "//*[@id='vgm-app']/div/main/section/section[1]/div/h1")
	WebElement lblCollectie;

	public TC1_Page(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String link_Click() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lnkOntdek_de_collective);

		lnkOntdek_de_collective.click();

		Thread.sleep(10000);

		System.out.println("**************" + lblCollectie.getText());

		return lblCollectie.getText();

	}

}
