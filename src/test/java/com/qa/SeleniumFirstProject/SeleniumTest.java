package com.qa.SeleniumFirstProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	static ChromeDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\WRY/chromedriver.exe");
		driver = new ChromeDriver();
        String url = "http://thedemosite.co.uk/";
        driver.manage().window().maximize();
        driver.get(url);
	}
	
	@Test
	public void createUser() {
        String user = "will";
        String pass = "w1ll";
		WebElement addUserLink = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
        addUserLink.sendKeys(Keys.ENTER);
        WebElement userInput = driver.findElement(By.name("username"));
        WebElement passInput = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.name("FormsButton2"));
        userInput.sendKeys(user);
        passInput.sendKeys(pass);
        submitBtn.sendKeys(Keys.ENTER);
        
        WebElement loginLink = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
        loginLink.sendKeys(Keys.ENTER);
        WebElement loginUser = driver.findElement(By.name("username"));
        WebElement loginPass = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
        loginUser.sendKeys(user);
        loginPass.sendKeys(pass);
        loginBtn.sendKeys(Keys.ENTER);
        WebElement successText = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
        assertEquals(successText.getText(), "**Successful Login**");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	

}
