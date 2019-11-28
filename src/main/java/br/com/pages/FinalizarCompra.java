package br.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalizarCompra {

	private WebDriver driver;
	private By btnProceedPag = By.name("processAddress");
	private By checkBox = By.name("cgv");
	private By btnProceedCheckOut = By.name("processCarrier");
	private By btnSelectPay = By.xpath("//a[@class='cheque']");
	private By btnConfirmOrder = By.xpath("//button[@class='button btn btn-default button-medium']");
	
	
	public FinalizarCompra(WebDriver driver) {
		this.driver = driver;
	}
	
	public void finalizar() {
		// TODO Auto-generated method stub
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnProceedPag));

		WebElement proceedPag = driver.findElement(btnProceedPag);
		Actions actions1= new Actions(driver);
		actions1.click(proceedPag).perform();

		WebElement checkbox = driver.findElement(checkBox);
		Actions actions2= new Actions(driver);
		actions2.click(checkbox).perform();

		WebElement proceedCheckOut = driver.findElement(btnProceedCheckOut);
		Actions actions3= new Actions(driver);
		actions3.click(proceedCheckOut).perform();
		
		WebElement selectionPay = driver.findElement(btnSelectPay);
		Actions actions4= new Actions(driver);
		actions4.click(selectionPay).perform();
		
		WebElement confirmOrder = driver.findElement(btnConfirmOrder);
		Actions actions5= new Actions(driver);
		actions5.click(confirmOrder).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
}
