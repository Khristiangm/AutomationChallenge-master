import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by KH389659 on 13/10/2017.
 */
public class JunitSample {
    protected static WebDriver driver;
    protected static final String sampleBankBaseURL = "http://localhost:8080/samplebank/index";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khristian-PC\\Desktop\\TestAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(sampleBankBaseURL);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        Assert.assertEquals("Welcome, admin (logout)", driver.findElement(By.id("sb-username")).getText());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.close();
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }


    @Test
    public void createAccount() {
        driver.findElement(By.xpath("//a[@href='addAccount']")).click();
        driver.findElement(By.id("ownerCpf")).sendKeys("12345678901");
        driver.findElement(By.xpath("//*[@value='Create Account']")).click();
        Assert.assertEquals("Operation completed with success",driver.findElement(By.id("sb-return-message")).getText());
    }
    @Test
    public void depositAccount(){
        driver.findElement(By.xpath("//a[@href='deposit']")).click();
        Select drpAccount = new Select(driver.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("16179082354");
        driver.findElement(By.id("ammount")).sendKeys("5000");
        driver.findElement(By.className("sb-button")).click();
    }
    @Test
    public void withdrawnAccount(){
        driver.findElement(By.xpath("//a[@href='withdraw']")).click();
        Select drpAccount = new Select(driver.findElement(By.id("targetAccount")));
        drpAccount.selectByVisibleText("16179082354");
        driver.findElement(By.id("ammount")).sendKeys("5000");
        driver.findElement(By.className("sb-button")).click();

    }



}
