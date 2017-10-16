import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by KH389659 on 13/10/2017.
 */
public class Login {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kh389659\\Desktop\\Trainings\\Test Automation Training\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/samplebank/index");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@value='Login']")).click();

        Assert.assertEquals("Welcome, admin (logout)", driver.findElement(By.id("sb-username")).getText());

        driver.findElement(By.xpath("//a[@href='addAccount']")).click();
        driver.findElement(By.id("ownerCpf")).sendKeys("12345678901");
        driver.findElement(By.xpath("//*[@value='Create Account']")).click();

        driver.findElement(By.xpath("//a[@href='deposit']")).click();
        Select drpAccount = new Select(driver.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("16179082354");
        driver.findElement(By.id("ammount")).sendKeys("5000");
        driver.findElement(By.className("sb-button")).click();

        driver.close();
        driver.quit();
    }
}
