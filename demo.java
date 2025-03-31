package doanlt;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
public class demo {
	public String BaseURL = "https://puppiizsunniiz.github.io/AN-EN-Tags/index.html";
//	String driverPath = ;
	public WebDriver driver;
	page page;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.out.println("Chạy trình duyệt Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		page = new page(driver);
	}
	
	@Test(priority = 0)
	public void ReadFromJson() throws IOException, ParseException, InterruptedException {
		FileReader rd = new FileReader("D:\\KTTD\\ds.json");
		JSONParser jsonparser = new JSONParser();
		Object obj = jsonparser.parse(rd);
		JSONObject empjsonobj = (JSONObject) obj;
		WebElement info_menu = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]"));
        info_menu.click();
        WebElement ope = driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[1]"));
        ope.click();
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("opname"));
        actions.moveToElement(searchBox).click().perform();
        
        JSONArray array = (JSONArray) empjsonobj.get("info");
        for (int i = 0; i < array.size(); i++) {
            JSONObject info = (JSONObject) array.get(i);
            String ten = (String) info.get("name");
            System.out.println("Thông tin " + i + " là...");
            System.out.println("Tên: " + ten);
            System.out.println("--------------------");
            //
            driver.findElement(By.id("opname")).clear();
            driver.findElement(By.id("opname")).sendKeys(ten);
            Thread.sleep(1000);
        }
	}

	@Test(priority = 1)
	public void Info_Ope_all() throws InterruptedException {
		page.openInfoSection();
		page.selectFirstOption();
		page.clickBrowseButton();
 
		// Lấy kết quả thực tế từ Page Object
		String actualResult = page.getSelectedOperatorName();
		String expectedResult = "SilverAsh"; // Giá trị mong đợi
		
		// In kết quả ra console
		System.out.println("Kết quả thực tế: " + actualResult);
		System.out.println("Kết quả mong đợi: " + expectedResult);
		
		// Kiểm tra kết quả
		Assert.assertEquals(actualResult, expectedResult, "Tên Operator không khớp!");
	}

	@Test(priority = 2)
	public void Info_Ope_gr() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("opBrowseButton3")).click();
		Thread.sleep(2000);
		
	    // Lấy kết quả thực tế sau khi chọn operator
	    WebElement selectedGroup = driver.findElement(By.xpath("/html/body/div[10]/div[1]/div[1]/div[4]/ul/li[14]")); // Giả sử đây là ID của tiêu đề operator
	    Thread.sleep(2000);
	    String actualResult = selectedGroup.getText();
	    String expectedResult = "Hellagur"; // Kết quả mong đợi

	    // In kết quả ra console
	    System.out.println("Kết quả thực tế: " + actualResult);
	    System.out.println("Kết quả mong đợi: " + expectedResult);

	    // Kiểm tra kết quả
	    Assert.assertEquals(actualResult, expectedResult, "Tên Operator không khớp!");
	    selectedGroup.click();
	}
	
	@Test(priority = 3)
	public void Info_Ope_filter() throws InterruptedException {	
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("opBrowseButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[2]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/div[2]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[4]/div[2]/div[3]")).click();
		Thread.sleep(2000);
		
	    // Lấy kết quả thực tế sau khi chọn operator
	    WebElement selectedFilter = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[7]/ul/div[2]/li[3]")); // Giả sử đây là ID của tiêu đề operator
	    Thread.sleep(2000);
	    String actualResult = selectedFilter.getText();
	    String expectedResult = "Sharp"; // Kết quả mong đợi

	    // In kết quả ra console
	    System.out.println("Kết quả thực tế: " + actualResult);
	    System.out.println("Kết quả mong đợi: " + expectedResult);

	    // Kiểm tra kết quả
	    Assert.assertEquals(actualResult, expectedResult, "Tên Operator không khớp!");
		selectedFilter.click();
	}
	
	@Test(priority = 4)
	public void Info_EliteMaterials() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[4]")).click();
		Thread.sleep(2000);

	    // Lấy kết quả thực tế sau khi chọn operator
		WebElement selectedEM_name = driver.findElement(By.id("opname"));
		selectedEM_name.sendKeys("Kroos");
	    WebElement selectedEM_show = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[2]/ul/li[2]")); // Giả sử đây là ID của tiêu đề operator
	    Thread.sleep(2000);
	    WebElement selectedEM_check = driver.findElement(By.id("akevolve"));
	    String actualResult = selectedEM_show.getText();
	    String expectedResult = "Kroos (克洛丝)"; // Kết quả mong đợi

	    // In kết quả ra console
	    System.out.println("Kết quả thực tế: " + actualResult);
	    System.out.println("Kết quả mong đợi: " + expectedResult);

	    // Kiểm tra kết quả
	    Assert.assertEquals(actualResult, expectedResult, "Tên Operator không khớp!");
	    selectedEM_show.click();
	    selectedEM_check.click();
		driver.navigate().refresh();
		Thread.sleep(3000); // Đợi trang load lại
		
	}
	
	@Test(priority = 5)
	public void Info_Stage() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul[1]/li[3]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[3]/div/a[6]")).click(); // test priority 4
		Thread.sleep(2000);
//		map1
		driver.findElement(By.id("BrowseStage")).click(); // chọn map
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[2]/a")).click();// daily
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[2]/ul/li[3]/a/div/img")).click();//unstoppable charge
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/ul/li[1]/a")).click();//PR-C-1
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/button")).click();// chọn x
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/button")).click();// toggle perspective
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/button")).click();
		Thread.sleep(2000);
		
//		map2
		driver.findElement(By.id("BrowseStage")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[2]/ul/li[3]/a/div/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/ul/li[2]/a")).click();//PR-C-2
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/button")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void test() {
		driver.quit();
	}


}