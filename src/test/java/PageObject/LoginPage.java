package PageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{

	WebDriver driver;
	String texto = "You logged into a secure area!";

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	By userNameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By btnLogin = By.className("radius");

	By mensajelogin = By.xpath("//div[@id='flash']"); 
	By btnLogout = By.xpath("//a[@href='/logout']");

	//By mensajeFallido = By.cssSelector("div[class='flash error']"); //"div[class='flash success']"

	
	
	
	//abrimos el browser
	public void openBrowser() {
		
		driver.get("http://the-internet.herokuapp.com/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	
    
	//metodo de registar usuario
	public void introducirUserAndPassword(String userName, String password) {

		if (driver.findElement(userNameLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys(userName);
			driver.findElement(passwordLocator).sendKeys(password);
		}

	}

	//hacer click login
	public void hacerClickBtnLogin() {

		if (driver.findElement(btnLogin).isDisplayed()) {
			driver.findElement(btnLogin).click();
			espera5seg();
		}
		
	}
	
	//hacer click logOut
		public void hacerClickBtnLogOut() {

			if (driver.findElement(btnLogout).isDisplayed()) {
				mensajeValido();
				driver.findElement(btnLogout).click();
				espera5seg();
			}
			
		}

	public void mensajeValido() {

		if (driver.findElement(mensajelogin).isDisplayed()) {
			System.out.println(driver.findElement(mensajelogin).getText());
			
			//assertSame(driver.findElement(mensajelogin).getText(), texto);
			assertEquals(driver.findElement(mensajelogin).getText().replace("×", "").trim(), texto);
			espera5seg();
		}
		
	}
	
	public void mensajeErrorUser() {

		if (driver.findElement(mensajelogin).isDisplayed()) {
			assertEquals("Your username is invalid!", driver.findElement(mensajelogin).getText().replace("×", "").trim());
			espera5seg();
		}
		
	}
	
	public void mensajeErrorPass() {

		if (driver.findElement(mensajelogin).isDisplayed()) {
			assertEquals("Your username or password is incorrect!", driver.findElement(mensajelogin).getText().replace("×", "").trim());
			espera5seg();
		}
		
	}
	
	
	//metodo espera explicita
	public void esperar(int duracion, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duracion));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	//metodo espera implicita
	public void espera5seg() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
