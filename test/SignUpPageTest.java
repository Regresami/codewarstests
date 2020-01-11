import codewars.MainPage;
import codewars.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://codewars.com/join");
        mainPage = new MainPage(driver);
        signUpPage = new SignUpPage(driver);
    }
    @Test
    public void signUpWithEmptyFieldsTest() {
        mainPage.clojureLanguage("valid");
        signUpPage.tryToSignUp("","","");
        signUpPage.createAccountButton();
        Assert.assertEquals("can't be blank", signUpPage.errEmptyField());
    }
    @Test
    public void signUpWithInvalidEmailTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("invalid_email", "validUsername", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is invalid", signUpPage.errInvalidEmail());
    }
    @Test
    public void signUpWithShortUsernameTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "qa", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is too short (minimum is 3 characters)", signUpPage.errShortUsername());
    }
    @Test
    public void signUpWithShortPasswordTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "validUsername", "pass");
        signUpPage.createAccountButton();
        Assert.assertEquals("is too short (minimum is 6 characters)", signUpPage.errShortPassword());
    }
    @Test
    public void signUpWithAlreadyTakenUsernameTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "qwerty", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is already taken", signUpPage.errUsernameIsAlreadyTaken());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
