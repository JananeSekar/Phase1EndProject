import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		
		WebElement searchText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchText.sendKeys("samsung mobile");
		
		WebElement submit = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		submit.click();
				
				
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));		
		System.out.println("Number of results found are " + searchResult.size());
		
		List<WebElement> price = driver .findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		System.out.println("Number of results found are " + price.size());
		//div[@class='a-section']//span[@class='a-price-whole']
		
		List<WebElement> priceSymbol = driver .findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-symbol']"));
		System.out.println("Number of results found are " + priceSymbol.size());
	
		for (int i = 0; i < searchResult.size(); i++) {

			System.out.println(
					(searchResult.get(i)).getText() + " " + priceSymbol.get(i).getText() + (price.get(i).getText()));

		}
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		driver.close();
		
	}

}
