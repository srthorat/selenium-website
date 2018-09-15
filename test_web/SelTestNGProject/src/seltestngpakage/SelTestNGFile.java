package seltestngpakage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SelTestNGFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  TestListenerAdapter testla = new TestListenerAdapter();
			  TestNG testng = new TestNG();
			  testng.setTestClasses(new Class[] {SelTestNGFile.class});
			  testng.run();
			 }
	
	public String baseUrl = "http://192.168.1.101:3001/";
    //String driverPath = "C:\\chromedriver.exe";
    //public WebDriver driver ; 

     
  @Test
  public void verifyHomepageTitle() {
       
      System.out.println("launching Firefox browser"); 
      //System.setProperty("webdriver.chrome.driver", driverPath);
      //driver = new FirefoxDriver();
  	  FirefoxBinary firefoxBinary = new FirefoxBinary();
  	  firefoxBinary.addCommandLineOptions("--headless");
  	  FirefoxOptions firefoxOptions = new FirefoxOptions();
      firefoxOptions.setBinary(firefoxBinary);
      FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
      driver.get(baseUrl);
      String expectedTitle = "Login";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.findElement(By.name("login")).sendKeys("WrongUser");
      driver.findElement(By.name("password")).sendKeys("WrongPassword");
      driver.findElement(By.name("click")).click();
      String pageSource = driver.getPageSource();
      Assert.assertTrue(pageSource.contains("Login Failed!"));
      //System.out.println(pageSource);
      driver.close();
  }
}