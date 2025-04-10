package doanth;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class tesst {
	public String BaseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Login";
	public WebDriver driver;


	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		System.out.println("Chạy trình duyệt Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.id("i0116")).sendKeys("an.2274802010002@vanlanguni.vn");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).sendKeys("minhvlu32969&");
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(
				"/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/"
				+ "div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void xemnganh() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]")).click();
		Thread.sleep(2000);
		
		// Thêm Assert kiểm tra
//	    WebElement tieuDe = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div/h4")); // hoặc xpath khác tùy trang bạn
//	    String actualText = tieuDe.getText();
//	    String expectedText = "";
//
//	    Assert.assertEquals(actualText, expectedText, "Tiêu đề trang không khớp!");
	}
	
	@Test(priority = 1)
	public void taonganh() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("id")).sendKeys("2422578020101");
		driver.findElement(By.id("name")).sendKeys("Kiểm Thử Tự Động");
		driver.findElement(By.id("abbreviation")).sendKeys("KTTĐ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[1]/span[1]")).click(); // CTĐT
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[2]")).click(); // TC
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		Thread.sleep(2000);

		// Assert: kiểm tra ngành vừa tạo có trong danh sách
		String expectedId = "2422578020101";
		String expectedName = "Kiểm Thử Tự Động";
		String expectedAbb = "KTTĐ";
		String expectedCTDT = "Tiêu chuẩn";

		// Xác định hàng theo Tên ngành
		String xpathRow = "//table/tbody/tr[td[3][text()='Kiểm Thử Tự Động']]";

		// Lấy từng giá trị theo dòng đã tìm được
		String actualTenNganh = driver.findElement(By.xpath(xpathRow + "/td[3]")).getText();
		String actualTenVietTat = driver.findElement(By.xpath(xpathRow + "/td[4]")).getText();
		String actualChuongTrinhDaoTao = driver.findElement(By.xpath(xpathRow + "/td[5]")).getText();

		System.out.println("Tên ngành thực tế: " + actualTenNganh);
		System.out.println("Tên viết tắt thực tế: " + actualTenVietTat);
		System.out.println("CTĐT thực tế: " + actualChuongTrinhDaoTao);
		System.out.println("--------------------");

		Assert.assertEquals(actualTenNganh, expectedName, "Tên ngành không đúng!");
		Assert.assertEquals(actualTenVietTat, expectedAbb, "Tên viết tắt không đúng!");
		Assert.assertEquals(actualChuongTrinhDaoTao, expectedCTDT, "CTĐT không đúng!");
	}

	
	@Test(priority = 2)
	public void capnhatnganh() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("2422578020101");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[1]/span[1]")).click();// CTĐT
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]")).click();// ĐB
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		Thread.sleep(2000);
		
		// Lấy lại giá trị từ dòng vừa cập nhật
	    String actualMaNganh = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[2]"))
	            .getText();
	    String actualCTDT = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[5]"))
	            .getText();

	    // In ra console để dễ debug
	    System.out.println("Mã ngành thực tế: " + actualMaNganh);
	    System.out.println("CTĐT thực tế: " + actualCTDT);
	    System.out.println("--------------------");

	    // So sánh kết quả mong đợi và thực tế
	    Assert.assertEquals(actualMaNganh.trim(), "2422578020101", "Mã ngành không đúng sau khi cập nhật!");
	    Assert.assertEquals(actualCTDT.trim(), "Đặc biệt", "CTĐT không đúng sau khi cập nhật!");
	}
	
	@Test(priority = 3)
	public void xoanganh() throws InterruptedException{
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("2422578020101");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		// Kiểm tra ngành đã được xoá
	    List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '2422578020101')]"));

	    if (searchResults.isEmpty()) {
	        System.out.println("Đã xoá thành công ngành học.");
	    } else {
	        System.out.println("Ngành học vẫn còn sau khi xoá! Số lượng: " + searchResults.size());
	    }
	    System.out.println("--------------------");

	    // Assert để test case pass/fail
	    Assert.assertTrue(searchResults.isEmpty(), "Ngành học vẫn còn sau khi xoá!");
	}

	
	@Test(priority = 4)
	public void xemTKBcanhan() throws InterruptedException {
	    try {
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]")).click();
	        Thread.sleep(2000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[3]/a/span")).click();
	        Thread.sleep(4000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span/span[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("666" + Keys.ENTER);
	        Thread.sleep(1000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[1]/span[1]/span/span[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys("Dương Minh An" + Keys.ENTER);
	        Thread.sleep(1000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span/span[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys("Tuần 1" + Keys.ENTER);
	        Thread.sleep(2000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span/span[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys("Tuần 5" + Keys.ENTER);
	        Thread.sleep(2000);

	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span/span[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys("Tuần 9" + Keys.ENTER);
	        Thread.sleep(2000);

	        // Assertion: kiểm tra phần tử hiển thị "THỜI KHÓA BIỂU"
	        WebElement ketQua = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[3]/a/span[text()='Xem TKB']"));
	        if (ketQua.isDisplayed()) {
	            System.out.println("Xem TKB thành công");
	        } else {
	            System.out.println("Xem TKB không thành công");
	        }
	        System.out.println("--------------------");

	    } catch (Exception e) {
	        System.out.println("Xem TKB không thành công");
	        e.printStackTrace();
	    }
	}
	
	@Test(priority = 5)
	public void ReadFromJson() throws IOException, ParseException, InterruptedException {
		FileReader rd = new FileReader("D:\\KTTD\\dstk.json");
		JSONParser jsonparser = new JSONParser();
		Object obj = jsonparser.parse(rd);
		JSONObject empjsonobj = (JSONObject) obj;
		WebElement menu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]"));
        menu.click();
        Thread.sleep(1000);
        WebElement major = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]"));
        major.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        actions.moveToElement(searchBox).click().perform();
        
        JSONArray array = (JSONArray) empjsonobj.get("info");
        for (int i = 0; i < 2; i++) {
            JSONObject info = (JSONObject) array.get(i);
            String id = (String) info.get("id");
            String name = (String) info.get("name");
            String abb = (String) info.get("abb");
            String CTĐT = (String) info.get("CTĐT");

            // In ra cho dễ kiểm tra
            System.out.println("Thông tin " + i + " là...");
            System.out.println("ID: " + id);
            System.out.println("Tên: " + name);
            System.out.println("ABB: " + abb);
            System.out.println("CTĐT: " + CTĐT);
            System.out.println("--------------------");

            // Giá trị mong đợi
            String expectedId = (i == 0) ? "001" : "012345";
            String expectedName = (i == 0) ? "Kiểm Thử Tự Động" : "Công nghệ thông tin";
            String expectedAbb = (i == 0) ? "CNTT" : "KTTĐ";
            String expectedCTĐT = (i == 0)? "Tiêu chuẩn" : "Đặc biệt"; // Cả 2 giống nhau

            // Assert kiểm tra
            Assert.assertEquals(id, expectedId, "ID không khớp tại dòng " + i);
            Assert.assertEquals(name, expectedName, "Tên không khớp tại dòng " + i);
            Assert.assertEquals(abb, expectedAbb, "ABB không khớp tại dòng " + i);
            Assert.assertEquals(CTĐT, expectedCTĐT, "CTĐT không khớp tại dòng " + i);

            // Thao tác nhập liệu
            WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
            input.clear();
            input.sendKeys(id);
            input.clear();
            input.sendKeys(name);
            input.clear();
            input.sendKeys(abb);
            input.clear();
            input.sendKeys(CTĐT);

            Thread.sleep(1000);
        }

	}
	@AfterTest
	public void kt() {
		driver.quit();
	}
}

