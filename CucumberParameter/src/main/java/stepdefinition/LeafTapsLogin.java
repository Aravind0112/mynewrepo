package stepdefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeafTapsLogin {
	ChromeDriver driver;
	@Given("Open the chrome browser")
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	@And("Load the application url")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	} 
	@And("Enter the username as {string}")
	public void enterUsername(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	@And("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@When("Click on Login button")
	public void clickLogiButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Homepage should be displayed")
	public void verifyHomepage() {
		String actualResult="Leaftaps - TestLeaf Automation Platform";
		String expectedResult = driver.getTitle();
		if(expectedResult.equals(actualResult)) {
			System.out.println("Homepage Displayed successfully");
		}
		else {
			System.out.println("Homepage not Displayed");
		}


	}
	@But("Error Message should be displayed")
	public void verifyErrorMessage() {
		String text = driver.findElement(By.id("errorDiv")).getText();
		System.out.println(text);
		
	}
}
