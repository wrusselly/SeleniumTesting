package com.qa.SeleniumFirstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\WRY/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.get(url);
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
        searchBar.sendKeys("what is the meaning of life");
        searchBar.sendKeys(Keys.ENTER);
        //searchButton.submit();
        WebElement result = driver.findElement(By.xpath("//*[@id=\"rhs_block\"]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/span"));
        if(result.getText().equals("Meaning of life")) {
        	System.out.println("results match");
        }
        
    }
}
