/**
 * 
 */
package br.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author rslo
 *
 */
public class AcessarBlouses {
	
	private WebDriver driver;
	private By txtBlouse =  By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"); 
	private By btnAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
	private By btnProceed = By.xpath("//span[contains(text(),'Proceed to checkout')]");
	
	public AcessarBlouses(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SelecionarBlouses() throws InterruptedException {
		// TODO Auto-generated method stub
		//Selecionar Blouse
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(txtBlouse));
		WebElement blouse = driver.findElement(txtBlouse);
		Actions actions1= new Actions(driver);
		actions1.moveToElement(blouse).perform();
		
		//Colocar no Carrinho
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		WebElement addtocart = driver.findElement(btnAddToCart);
		Actions actions2= new Actions(driver);
		actions2.click(addtocart).perform();
		
		//Prosseguindo com o Carrinho
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnProceed));
		WebElement proceed = driver.findElement(btnProceed);
		Actions actions4= new Actions(driver);
		actions4.click(proceed).perform();
	}
}
