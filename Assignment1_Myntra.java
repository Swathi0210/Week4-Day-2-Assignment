package week4.Day2;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Myntra {

	

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement womenFashion = driver.findElement(By.xpath("//a[@data-group='women']"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(womenFashion).perform();
		
		driver.findElement(By.xpath("//a[@href='/women-jackets-coats']")).click();
		String itemCount = driver.findElement(By.className("title-count")).getText().replaceAll("\\D", "");
		System.out.println(itemCount);
		
		List<WebElement> categoriesList = driver.findElements(By.xpath("//span[@class='categories-num']"));
		System.out.println(categoriesList.size());
		
		
		int sum = 0;
		
		for(int i=0; i<categoriesList.size(); i++) {
			String categoriesValue = categoriesList.get(i).getText().replaceAll("\\D", "");
			int categoriesValue1 = Integer.parseInt(categoriesValue);
			System.out.println(categoriesValue1);
			sum = sum+ categoriesValue1;
		}
		System.out.println(sum);
		
		if(sum==Integer.parseInt(itemCount)) {
			System.out.println("Sum of Categories count matches");
		}
		else { System.out.println("Sum of Categories count doesnt match");
	}
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("MANGO");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();
		driver.findElement(By.className("myntraweb-sprite")).click();
		
		String mangoCount = driver.findElement(By.className("title-count")).getText().replaceAll("\\D", "");
		System.out.println(mangoCount);
		
		List<WebElement> mangoList = driver.findElements(By.xpath("(//span[@class='vertical-filters-header'])[2]"));
		System.out.println(mangoList.size());
		
		int lst = 0;
		
		for (int i=0; i<mangoList.size(); i++) {
			String brandCheck = mangoList.get(i).getText();
			if(!brandCheck.equalsIgnoreCase("MANGO")) {
				lst = 1;
			System.out.println("All the items are Mango");
		}	else { System.out.println("All the items are not Mango");
		break;
		}
		}
		
		WebElement sortBy = driver.findElement(By.className("sort-sortBy"));
		Actions builder2 = new Actions(driver);
		
		builder2.moveToElement(sortBy).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		Thread.sleep(2000);
		
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText().replaceAll("//D", "");
		System.out.println("Price : "+ price);
		
		WebElement wishList = driver.findElement(By.xpath("//li[@class='product-base']"));
		WebElement wishElement = driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']"));
		Actions builder3 = new Actions(driver);
		
		builder3.moveToElement(wishList).moveToElement(wishElement).click().perform();
		
		driver.close();
		
		
		
		
}
}