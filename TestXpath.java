package seleniumConcepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD
//do da dai
=======
//do it man
>>>>>>> her-branch

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestXpath {
	//comment
	public static void main(String args[] ) throws AWTException{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://cosmocode.io/automation-practice-webtable/");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	WebElement down= driver.findElement(By.xpath("//*[contains(text(),'Austria')]"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", down);
	
	//to fetch all data which belongs to 
	
	List<WebElement> allEle =driver.findElements(By.xpath("//*[contains(text(),'Austria')]/ancestor::tr//following-sibling::td"));
	
	for(WebElement eachElement : allEle) {
		
		String name =eachElement.getText();
		System.out.println("Name "+name);
	}
	
	Actions ac  = new Actions(driver);
	ac.contextClick(down).perform();
	
	
	ac.keyDown(Keys.DOWN).perform();
	ac.keyUp(Keys.DOWN).perform();

	ac.keyDown(Keys.ENTER);
	ac.keyUp(Keys.ENTER);
	ac.perform();
	
	}
}
