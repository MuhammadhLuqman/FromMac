package seleniumConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksPractice {
	
	
	public static void main(String[]args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Set<String> se = new HashSet<>();
		List<WebElement> li =driver.findElements(By.tagName("a"));
		
		System.out.println(li.size());
		try {
		for(WebElement link: li) {
			String idLink = link.getAttribute("href");
			//System.out.println(idLink);
			
			if(idLink== null) {
				System.out.println("null is pointed");
			}else {
			URL url = new URL(idLink);
			HttpURLConnection huc = (HttpURLConnection)url.openConnection();
			huc.setConnectTimeout(5000);
			huc.connect();
//			if(huc.getResponseCode() ==200) {
//				System.out.println("the link is not broke "+idLink+" "+ huc.getResponseMessage());
//			}else {
//				
//				System.err.println("the link is broken "+huc.getResponseMessage());
//			}
//			}
			
			if(huc.getResponseCode() !=200) {
				System.err.println("the link is broke "+idLink+" "+huc.getResponseCode()+ huc.getResponseMessage());
			}
//			}
			}
		}
		}catch(Exception e){
			//e.printStackTrace();
			
		}
		driver.quit();
		
	}

}
