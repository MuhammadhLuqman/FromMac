package seleniumConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandles {
	
	public static void main(String[]args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		op.addArguments("--incognito");
		op.addArguments("--start-maximized");
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		WebElement scrollDown = driver.findElement(By.xpath("//*[contains(text(),'Button5')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		
		WebElement multiTabs = driver.findElement(By.id("newTabsBtn"));
		multiTabs.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		WebElement alertTitle = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
		

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(alertTitle));
		
		if(alertTitle.isDisplayed()) {
			String mytitle = alertTitle.getText();
			System.out.println(mytitle);
			System.out.println("title is present as exepected");
		}else {
			System.out.println("title is NOT present as exepected");
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(driver, 2);
		wb.until(ExpectedConditions.visibilityOf(alertTitle));
		
		Wait wait2 = new FluentWait(driver).withTimeout(30,TimeUnit.NANOSECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(Exception.class);		
		String wd = driver.getWindowHandle();
		String title = driver.switchTo().window(wd).getTitle();
		System.out.println("TItle "+ title );
		
		Set<String> whs = driver.getWindowHandles();
		
		for(String ss: whs) {
			
			WebDriver window = driver.switchTo().window(ss);
		Thread.sleep(5000);
			String title2 = window.getTitle();
			System.out.println("titles: "+title2);
			if(title2.equals(title)) {
				driver.switchTo().window(title);
				break;
			}
		}
		
		
		driver.quit();
		
	}

}
