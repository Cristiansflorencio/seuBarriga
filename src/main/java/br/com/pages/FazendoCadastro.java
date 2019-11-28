package br.com.pages;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class FazendoCadastro {

	private WebDriver driver;
	private By txtEmailCreate = By.id("email_create");
	private By btnCreate = By.id("SubmitCreate");
	private By btntitle = By.id("id_gender1"); 
	
	private By btnName = By.id("customer_firstname");
	private By btnLastName = By.id("customer_lastname");
	private By btnPassword = By.id("passwd");
	
	private By inputDay = By.id("days");
	private By inputMonth = By.id("months");
	private By inputYear = By.id("years");
	
	private By txtAndress = By.id("address1");
	private By txtCity = By.id("city");
	private By inputState = By.id("id_state");
	private By txtPostCode = By.id("postcode");
	
	private By txtPhoneNumber = By.id("phone_mobile");
	
	private By btnRegister = By.id("submitAccount");
		
	public FazendoCadastro (WebDriver driver){
		this.driver = driver;
	}
	

	public void fazendoConta() throws InterruptedException{
		// TODO Auto-generated method stub
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(txtEmailCreate));
		 //faker criando informações em pt-br
		 Faker faker = new Faker(new Locale("pt-BR"));
		 //informações
		 String firstName = faker.name().firstName();
	     String lastName = faker.name().lastName();
		 String email = firstName + lastName + faker.numerify("###") + "@test.com";
		 email = email.replaceAll("\\s", "").toLowerCase();
	     driver.findElement(txtEmailCreate).sendKeys(email);
	     String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
	     String password = RandomStringUtils.random(10, characters);
	     Random randomGenerator = new Random();
	     String streetAddress = faker.address().streetAddress();
	     String city = faker.address().city();
	     String phoneNumber = faker.numerify("+55 9####-####");
	     
		 Faker faker1 = new Faker(new Locale("en-US"));
	     String zipCode = faker1.address().zipCode();
	     
	     int state = randomGenerator.nextInt(50) + 1;
	     int day = randomGenerator.nextInt(31) + 1;
	     int month = randomGenerator.nextInt(12) + 1;
	     int year = randomGenerator.nextInt(82) + 1;

	     WebElement proceed = driver.findElement(btnCreate);
		 Actions actions= new Actions(driver);
		 actions.click(proceed).perform();
		 
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 
		 WebElement select = driver.findElement(btntitle);
		 Actions actions1= new Actions(driver);
		 actions1.click(select).perform();
		 
		 driver.findElement(btnName).sendKeys(firstName);
		 driver.findElement(btnLastName).sendKeys(lastName);
		 driver.findElement(btnPassword).sendKeys(password);
		 
		 Select actions2 = new Select(driver.findElement(inputDay));
		 actions2.selectByIndex(day);
		 Select actions3 = new Select(driver.findElement(inputMonth));
		 actions3.selectByIndex(month);
		 Select actions4 = new Select(driver.findElement(inputYear));
		 actions4.selectByIndex(year);
		 
		 driver.findElement(txtAndress).sendKeys(streetAddress);
		 driver.findElement(txtCity).sendKeys(city);
		 Select actions5= new Select(driver.findElement(inputState));
		 actions5.selectByIndex(state);
		 driver.findElement(txtPostCode).sendKeys(zipCode);
		 driver.findElement(txtPhoneNumber).sendKeys(phoneNumber);
		 
	     WebElement register = driver.findElement(btnRegister);
		 Actions actions6= new Actions(driver);
		 actions6.click(register).perform();
		
	}
		
}