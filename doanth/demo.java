package doanth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo {
    public String BaseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Login";
    public WebDriver driver;
    public page page;

    @BeforeTest
    public void launchBrowser() throws InterruptedException {
        System.out.println("Chạy trình duyệt Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new page(driver);
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
        page.clickElement(page.menuDanhMuc);
        page.clickElement(page.submenuNganh);
        
     // Lấy tiêu đề của trang "Danh sách ngành" để kiểm tra
        String actualText = page.getText(By.xpath("//a[contains(normalize-space(),'Ngành')]")); // giả sử thẻ h1 là tiêu đề "Danh sách ngành"
        String expectedText = "Ngành";

        // In kết quả thực tế và mong đợi
        System.out.println("Kết quả thực tế: " + actualText);
        System.out.println("Kết quả mong đợi: " + expectedText);
        
     // Assert kiểm tra và in ra thành công hoặc thất bại
        if (actualText.equals(expectedText)) {
            System.out.println("Xem danh sách ngành: Thành công");
        } else {
            System.out.println("Xem danh sách ngành: Không thành công");
        }
        System.out.println("--------------------");
    }

    @Test(priority = 1)
    public void taonganh() throws InterruptedException {
        page.clickElement(page.btnThemMoi);

        page.sendKeys(page.inputMaNganh, "2422578020101");
        page.sendKeys(page.inputTenNganh, "Kiểm Thử Tự Động");
        page.sendKeys(page.inputVietTat, "KTTĐ");
        page.clickElement(page.dropdownCTDT);
        page.clickElement(page.optionCTDT_TC);
        Thread.sleep(3000);
        page.clickElement(page.btnLuu);

        String actualTenNganh = page.getText(By.xpath(page.xpathRow + "/td[3]"));
        String actualTenVietTat = page.getText(By.xpath(page.xpathRow + "/td[4]"));
        String actualCTDT = page.getText(By.xpath(page.xpathRow + "/td[5]"));
        String expectedText = "Kiểm Thử Tự Động";
        String expectedText1 = "KTTĐ";
        String expectedText2 = "Tiêu chuẩn";

        System.out.println("Tên ngành mong đợi: " + expectedText);
        System.out.println("Tên viết tắt mong đợi: " + expectedText1);
        System.out.println("CTĐT mong đợi: " + expectedText2);
        System.out.println("Tên ngành thực tế: " + actualTenNganh);
        System.out.println("Tên viết tắt thực tế: " + actualTenVietTat);
        System.out.println("CTĐT thực tế: " + actualCTDT);
        System.out.println("--------------------");

        Assert.assertEquals(actualTenNganh, "Kiểm Thử Tự Động", "Tên ngành không đúng!");
        Assert.assertEquals(actualTenVietTat, "KTTĐ", "Tên viết tắt không đúng!");
        Assert.assertEquals(actualCTDT, "Tiêu chuẩn", "CTĐT không đúng!");
    }

    @Test(priority = 2)
    public void capnhatnganh() throws InterruptedException {
        page.sendKeys(page.inputSearch, "2422578020101");
        Thread.sleep(2000);
        page.clickElement(page.btnEdit);
        Thread.sleep(3000);

        page.clickElement(page.dropdownCTDT);
        page.clickElement(page.optionCTDT_DB);
        page.clickElement(page.btnLuu);

        String actualMaNganh = page.getText(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[2]"));
        String actualCTDT = page.getText(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[5]"));
        String expectedText = "2422578020101";
        String expectedText1 = "Đặc biệt";
        
        System.out.println("Mã ngành mong đợi:" + expectedText);
        System.out.println("CTĐT mong đợi:" + expectedText1);
        System.out.println("Mã ngành thực tế: " + actualMaNganh);
        System.out.println("CTĐT thực tế: " + actualCTDT);
        System.out.println("--------------------");

        Assert.assertEquals(actualMaNganh.trim(), "2422578020101", "Mã ngành không đúng sau khi cập nhật!");
        Assert.assertEquals(actualCTDT.trim(), "Đặc biệt", "CTĐT không đúng sau khi cập nhật!");
    }
    
    @Test(priority = 3)
    public void xoanganh() throws InterruptedException {
        page.xoaNganh();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void xemTKBcanhan() throws InterruptedException {
        page.xemTKBCaNhan();
    }

    @Test(priority = 5)
    public void readFromJson() throws IOException, ParseException, InterruptedException {
        page.readFromJson();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
