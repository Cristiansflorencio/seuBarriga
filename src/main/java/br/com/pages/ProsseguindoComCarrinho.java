package br.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProsseguindoComCarrinho {

	private WebDriver driver;
	private By btnProceed = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
	
	public ProsseguindoComCarrinho(WebDriver driver) {
		this.driver = driver;
	}

	public void SeguindoComCompra() throws InterruptedException {
		// TODO Auto-generated method stub
		new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(btnProceed));
		//prosseguindo
		WebElement proceed = driver.findElement(btnProceed);
		Actions actions= new Actions(driver);
		actions.click(proceed).perform();
	}
}

