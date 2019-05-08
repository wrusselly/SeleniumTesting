package com.qa.SeleniumFirstProject;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingWebTest {
static ChromeDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\WRY/chromedriver.exe");
		driver = new ChromeDriver();
        String url = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(url);
	}
	
	@Test
	public void searchClothing() {
		String searchItem = "dress";
		WebElement search = driver.findElement(By.name("search_query"));
		search.sendKeys(searchItem);
		search.sendKeys(Keys.ENTER);
		WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]"));
		assertEquals('"'+searchItem.toUpperCase()+'"', result.getText());
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
