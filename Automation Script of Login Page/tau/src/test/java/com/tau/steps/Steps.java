package com.tau.steps;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tau.base.BaseUtil;

import gherkin.ast.DataTable;
import gherkin.ast.TableRow;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseUtil{
	
	private WebDriver driver; 
	BaseUtil baseutil;
	public Steps(BaseUtil util) {
		this.baseutil = util;
	}
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}

	@Given("I am in the login page of the para bank application")
	public void i_am_in_the_login_page_of_the_para_bank_application() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");		
	}

	@When("I enter valid with {string} and {string} with {string}")
	public void i_enter_valid_credentials(String username, String password, String userFullName) {
		
		baseutil.userFullname = userFullName;
       	driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector(".button[value='Log In']")).click();;
	}

	@Then("I should be taken to the Overview page")
	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
			
		Thread.sleep(5000);
		String actauluserFullName = driver.findElement(By.className("smallText")).getText().toString();
		System.out.println(baseutil.userFullname.toString() +  " ForTest");
		
		assertTrue(actauluserFullName,actauluserFullName.contains(baseutil.userFullname));
		/*
		 * driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/h1")).
		 * isDisplayed();
		 * driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
		 */
		Thread.sleep(1000);
		
	}
	@After
	public void close() {
		driver.quit();
	}

}
