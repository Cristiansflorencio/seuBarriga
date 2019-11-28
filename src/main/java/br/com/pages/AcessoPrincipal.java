package br.com.pages;

//import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.github.javafaker.Faker;


public class AcessoPrincipal {
	private WebDriver driver;
	private By txtWoman =  By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");
	private By txtBlouses = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Blouses')]");

	public AcessoPrincipal(WebDriver driver) {
		this.driver = driver;
	}
	public void selecionarMenu() throws InterruptedException {
		// TODO Auto-generated method stub
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(txtWoman));
		//Entrar no Women
		WebElement woman = driver.findElement(txtWoman);
		Actions actions= new Actions(driver);
		actions.moveToElement(woman).perform();
		//Clicando em Blouses(Blusa)
		WebElement tshirts = driver.findElement(txtBlouses);
		Actions actions1= new Actions(driver);
		actions1.click(tshirts).perform();
	}
	

}
