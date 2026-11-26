package StepsDefinition;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

	private WebDriver driver;
	LoginPage loginPage;
	
	@Before
	public void hookSetUp() {
		System.out.println("Estoy aqui Robinson");
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe"); //el webDriverManager se encarga de esto.
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//String window = driver.getWindowHandle();
		
	}

	
	@After
	public void hookTearDown(Scenario escenario) {
		
		String nombreEscenario = escenario.getName().replaceAll(" ", "_");
		
		if (escenario.isFailed()) {
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			escenario.attach(screenShot, "image/png", nombreEscenario);
			
		} else {
			
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			escenario.attach(screenShot, "image/png", nombreEscenario+"_exitoso");
		}
		
		driver.close();
		driver.quit();
		
	}
	

	@Given("user is on login page")
	public void paginaLogin() {
		loginPage = new LoginPage(driver);
		loginPage.openBrowser();
	}
	@When("^user enters (.*) and (.*)$")
	public void user_enters_user_name_and_password(String user, String pass) {
		loginPage.introducirUserAndPassword(user, pass);
	}

	@And("click on login botton")
	public void click_on_login_botton() {
		loginPage.hacerClickBtnLogin();
	}

	@Then("verify user is on dashboard logout")
	public void verify_dashboard() {
		loginPage.hacerClickBtnLogOut();
	}
	
	@Then("verify invalid credentials")
	public void verify_Invalid() {
		loginPage.mensajeErrorUser();
	}
	
	@Then("verify only with password")
	public void verify_withPassword() {
		loginPage.mensajeErrorPass();
	}
	
}
