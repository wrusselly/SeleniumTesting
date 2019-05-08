package com.qa.SeleniumFirstProject;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FTSE100Test {
	static ChromeDriver driver;
	static String url;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\WRY/chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	
	@Test
	public void findRiser() {
		url = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers";
		driver.get(url);
		WebElement riserTable = driver.findElement(By.tagName("tbody"));
		WebElement topRow = riserTable.findElement(By.tagName("tr"));
		WebElement highRiser = topRow.findElement(By.tagName("td"));
		String name = highRiser.getText(); 
		assertEquals(name, "INF");
	}
	
	@Test
	public void findFaller() {
		url = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/fallers";
		driver.get(url);
		WebElement fallerTable = driver.findElement(By.tagName("tbody"));
		WebElement topRow = fallerTable.findElement(By.tagName("tr"));
		WebElement highFaller = topRow.findElement(By.tagName("td"));
		String name = highFaller.getText(); 
		assertEquals(name, "IMB");
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
