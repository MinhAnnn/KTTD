package doanth;

import java.io.IOException;
import java.util.List;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class page {
    WebDriver driver;

    public page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By by) throws InterruptedException {
        driver.findElement(by).click();
        Thread.sleep(1000);
    }

    public void sendKeys(By by, String text) throws InterruptedException {
        driver.findElement(by).sendKeys(text);
        Thread.sleep(1000);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public By menuDanhMuc = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]");
    public By submenuNganh = By.xpath("//a[contains(normalize-space(),'Ngành')]");
    

    public By btnThemMoi = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]");
    public By inputMaNganh = By.id("id");
    public By inputTenNganh = By.id("name");
    public By inputVietTat = By.id("abbreviation");
    public By dropdownCTDT = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[1]/span[1]");
    public By optionCTDT_TC = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[2]");
    public By optionCTDT_DB = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]");
    public By btnLuu = By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]");

    public By inputSearch = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input");
    public By btnEdit = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]/i");

    public String xpathRow = "//table/tbody/tr[td[3][text()='Kiểm Thử Tự Động']]";
    
    public void xoaNganh() throws InterruptedException {
        Thread.sleep(8000);
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        searchBox.clear();
        searchBox.sendKeys("2422578020101");
        Thread.sleep(4000);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]/i")).click();
        Thread.sleep(1000);//

        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '2422578020101')]"));

        if (searchResults.isEmpty()) {
            System.out.println("Đã xoá thành công ngành học.");
        } else {
            System.out.println("Ngành học vẫn còn sau khi xoá! Số lượng: " + searchResults.size());
        }
        System.out.println("--------------------");

        Assert.assertTrue(searchResults.isEmpty(), "Ngành học vẫn còn sau khi xoá!");
    }

    public void xemTKBCaNhan() throws InterruptedException {
    	Thread.sleep(6000);
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

    public void readFromJson() throws IOException, ParseException, InterruptedException {
        FileReader rd = new FileReader("D:\\KTTD\\dstk.json");
        JSONParser jsonparser = new JSONParser();
        Object obj = jsonparser.parse(rd);
        JSONObject empjsonobj = (JSONObject) obj;

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]")).click();
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

            System.out.println("Thông tin " + i + " là...");
            System.out.println("ID: " + id);
            System.out.println("Tên: " + name);
            System.out.println("ABB: " + abb);
            System.out.println("CTĐT: " + CTĐT);
            System.out.println("--------------------");

            String expectedId = (i == 0) ? "001" : "012345";
            String expectedName = (i == 0) ? "Kiểm Thử Tự Động" : "Công nghệ thông tin";
            String expectedAbb = (i == 0) ? "CNTT" : "KTTĐ";
            String expectedCTĐT = (i == 0) ? "Tiêu chuẩn" : "Đặc biệt";

            Assert.assertEquals(id, expectedId, "ID không khớp tại dòng " + i);
            Assert.assertEquals(name, expectedName, "Tên không khớp tại dòng " + i);
            Assert.assertEquals(abb, expectedAbb, "ABB không khớp tại dòng " + i);
            Assert.assertEquals(CTĐT, expectedCTĐT, "CTĐT không khớp tại dòng " + i);

            WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
            input.clear();
            input.sendKeys(id);
            input.clear();
            input.sendKeys(name);
        }
    }
}
