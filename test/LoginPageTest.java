import codewars.LoginPage;
import codewars.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://codewars.com");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void logInValidTest() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "orired13");
        Assert.assertTrue(loginPage.checkHomePageHeader());
    }
    @Test
    public void logInWithIncorrectPassword() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "incorrect_password");
        Assert.assertEquals("Invalid Email or password.", loginPage.ErrInvalidEmailOrPassword());
    }
    @Test
    public void logInWithoutPasswordTest() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "");
        Assert.assertEquals("Invalid Email or password.", loginPage.ErrInvalidEmailOrPassword());
    }
}