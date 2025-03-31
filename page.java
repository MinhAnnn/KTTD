package doanlt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class page {
    WebDriver driver;

    // Sử dụng @FindBy để xác định các phần tử trên trang thay vì findElement()
    @FindBy(xpath = "//*[@id=\"navbarNav\"]/ul[1]/li[3]") 
    private WebElement menuInfo;

    @FindBy(xpath = "/html/body/nav/div/ul[1]/li[3]/div/a[1]") 
    private WebElement firstOption; // Phần tử của tùy chọn đầu tiên trong menu "Info"

    @FindBy(id = "opBrowseButton2") 
    private WebElement browseButton; // Nút "Browse"

    // Hàm khởi tạo: Khởi tạo Page Object và liên kết với trình duyệt hiện tại
    public page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Khởi tạo các phần tử web với @FindBy
    }

    // Hành động trên trang
    // Mở menu "Info"
    public void openInfoSection() {
        menuInfo.click();
    }

    // Chọn tùy chọn đầu tiên trong menu "Info"
    public void selectFirstOption() throws InterruptedException {
        firstOption.click();
        Thread.sleep(2000); // Hạn chế dùng Thread.sleep, nên thay bằng WebDriverWait
    }
    
    // Nhấn vào nút "Browse"
    public void clickBrowseButton() throws InterruptedException {
        browseButton.click();
        Thread.sleep(2000);
    }
    
    // Locator của Operator
    private By selectedOperator = By.xpath("/html/body/div[10]/div[1]/div[1]/div[4]/ul/li[6]");

    // Phương thức lấy tên Operator
    public String getSelectedOperatorName() throws InterruptedException {
        Thread.sleep(2000); // Đợi phần tử load
        WebElement operatorElement = driver.findElement(selectedOperator);
        return operatorElement.getText();
    }
}
