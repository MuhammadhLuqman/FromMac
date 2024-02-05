package seleniumConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceHYR {
//try da 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		try {
		
		WebElement whp =driver.findElement(By.xpath("//*[@class='post-title entry-title']"));
		
		WebDriverWait wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(whp));
		
		String title =whp.getText();
		
		if(title.equals("Window Handles Practice")) {
			System.out.println("Title is matching as expected ");
			
		}else {
			System.out.println("Title not matching the expected");
		}
		
		WebElement nwb =driver.findElement(By.id("newWindowBtn"));
		
		String homeWindow = driver.getWindowHandle();
		String homeTitle = driver.switchTo().window(homeWindow).getTitle();
		
		System.out.println("homeTitle "+homeTitle);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		nwb.click();
		driver.manage().window().maximize();
		
		Set<String> windowsAll =driver.getWindowHandles();
		
		for(String eachWindow: windowsAll) {
		String secTitle = driver.switchTo().window(eachWindow).getTitle();
		System.out.println("all titles " + secTitle);
		
		if(secTitle.equals("Basic Controls - H Y R Tutorials")) {
			driver.switchTo().window(eachWindow);
			break;
			
		}else {
			System.out.println("not switched");
		}
		
		}
		
		driver.manage().window().maximize();
		
		
		WebElement firstName =driver.findElement(By.id("firstName"));
		WebElement lastName =driver.findElement(By.id("lastName"));
		WebElement email =driver.findElement(By.id("email"));
		WebElement password =driver.findElement(By.id("password"));
		WebElement radioBtn =driver.findElement(By.id("femalerb"));
		WebElement checkBox =driver.findElement(By.id("englishchbx"));
		WebElement regisButton =driver.findElement(By.id("registerbtn"));
		
		
		
		js.executeScript("arguments[0].scrollIntoView(true);", firstName);
		
		firstName.sendKeys("Luqman");
		lastName.sendKeys("Naciba");
	
		
		js.executeScript("arguments[0].click();", radioBtn);
		
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//js.executeScript("arguments[0].click();", checkBox);
		checkBox.click();
		
		
		email.sendKeys("email@gmail.com");
		firstName.sendKeys("password@");
		
		regisButton.click();
		
		
		
		
		
		WebElement success =driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));
		wait.until(ExpectedConditions.visibilityOf(success));
		if(success.isDisplayed()) {
			System.out.println("BaNNER IS DISPLAYED");
		}else {
			System.out.println("Not displayed");
		}
		
		driver.switchTo().window(homeWindow);
		
		WebElement pageTitle = driver.findElement(By.xpath("//*[@class='post-title entry-title']"));
		
		wait.until(ExpectedConditions.visibilityOf(pageTitle));
		
		//*[@id="name"]
		WebElement txtBox = driver.findElement(By.xpath("//*[@id='name']"));
		txtBox.sendKeys("Legend is the name ");
		
		WebElement manyTabs = driver.findElement(By.xpath("//*[@id='newTabsWindowsBtn']"));
		manyTabs.click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		Set<String> allwindows =driver.getWindowHandles();
		
		for(String eachWindow: allwindows) {
			String title2 = driver.switchTo().window(eachWindow).getTitle();
			
			System.out.println("EachTitle "+title2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		}catch(Exception ne){
			ne.printStackTrace();
		}
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
