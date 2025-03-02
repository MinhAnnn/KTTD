package DOAN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
public class demo {

	public String BaseURL = "https://puppiizsunniiz.github.io/AN-EN-Tags/index.html";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.out.println("Chạy trình duyệt Chrome");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

//	@Test(priority = 0)
//	public void Info_Ope_all() throws InterruptedException {
//		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[1]")).click();
//		Thread.sleep(20000);
//		driver.findElement(By.id("opBrowseButton2")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[10]/div[1]/div[1]/div[4]/ul/li[6]")).click();
//		Thread.sleep(2000);
//	}
//	
//	@Test(priority = 0)
//	public void Info_Ope_gr() throws InterruptedException {
//		driver.findElement(By.id("opBrowseButton3")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[10]/div[1]/div[1]/div[4]/ul/li[6]")).click();
//		Thread.sleep(2000);
//	}
//	
//	@Test(priority = 0)
//	public void Info_Ope_filter() throws InterruptedException {	
//		driver.findElement(By.id("opBrowseButton")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[2]/div[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/div[2]/div[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[4]/div[2]/div[3]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[7]/ul/div[2]/li[3]")).click();
//		Thread.sleep(2000);
//	}
//	
	@Test(priority = 0)
	public void Info_EliteMaterials() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[4]")).click();
		Thread.sleep(20000);
		driver.findElement(By.id("opname")).sendKeys("kroos");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[2]/ul/li[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div[4]/p/a")).click();
		
	}

}
