package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class makeLoanPage extends AbstractPage {

    protected static WebDriver driver;


    Select drpAccount = new Select(driver.findElement(By.id("targetAccount")));
    drpAccount.selectByVisibleText("16179082354")

    @FindBy(id = "ammount")
    private WebElement amountInput;

    @FindBy(xpath = "//*[@value='Get Loan!']")
    private WebElement makeLoanButton;

    @FindBy(id = "sb-return-message")
    private WebElement returnMsg;

    public makeLoanPage amount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
        return this;
    }

    public makeLoanPage clickMakeLoanButton() {
        makeLoanButton.click();
        return this;
    }

    public String getReturnMsg() {
        return returnMsg.getText();
    }
}

