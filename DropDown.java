package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	public static void main(String[]args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
				ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);

		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
//		driver.findElement(By.linkText("Selenium Practice")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Dropdowns")).click();
		Thread.sleep(5000);
		WebElement dd= driver.findElement(By.xpath("//select[@id='course']"));
		//dd.click();
		
		Select s = new Select(dd);
		s.selectByIndex(2);
		WebElement es = s.getFirstSelectedOption();
		System.out.println("this is "+es.getText());
		
		driver.quit();
		
		
		
	}

}
