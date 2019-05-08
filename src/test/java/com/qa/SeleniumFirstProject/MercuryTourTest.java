package com.qa.SeleniumFirstProject;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MercuryTourTest {
	static ChromeDriver driver;
	static String url;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\WRY/chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	
	@Test
	public void signupAndLogin() {
		url = "http://www.newtours.demoaut.com/";
		driver.get(url);
		String username = "userwill"; 
		String password = "123password";
		WebElement registerLink = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
		registerLink.sendKeys(Keys.ENTER);
		WebElement userInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		userInput.sendKeys(username);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys(password).perform();
		action.sendKeys(Keys.TAB).sendKeys(password).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		url = "http://newtours.demoaut.com/mercurysignon.php";
		driver.get(url);
		WebElement userSignin = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input"));
		userSignin.sendKeys(username);
		action.sendKeys(Keys.TAB).sendKeys(password).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		WebElement passengerInput = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select"));
		passengerInput.sendKeys(Keys.ENTER);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();	
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		WebElement we = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input"));
		we.sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		WebElement name1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input"));
		name1.sendKeys("will");
		action.sendKeys(Keys.TAB).sendKeys("lastname").perform();
		action.sendKeys(Keys.TAB, Keys.TAB).sendKeys("name2").perform();
		action.sendKeys(Keys.TAB).sendKeys("lastname2").perform();
		action.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).sendKeys("1234567890987654").perform();
		WebElement purchase = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[24]/td/input"));
		purchase.sendKeys(Keys.ENTER);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
