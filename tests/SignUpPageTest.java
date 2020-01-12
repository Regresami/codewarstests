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
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("","","");
        signUpPage.createAccountButton();
        Assert.assertEquals("can't be blank", signUpPage.errEmptyField());
    }   // пытаемся зарегистрироваться не вводя никаких данных --> проверяем появление ошибки пустого поля
    @Test
    public void signUpWithInvalidEmailTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("invalid_email", "validUsername", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is invalid", signUpPage.errInvalidEmail());
    }   //  пытаемся зарегистрироваться с некорректным емейлом --> проверяем появление ошибки невалидного емейла
    @Test
    public void signUpWithShortUsernameTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "qa", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is too short (minimum is 3 characters)", signUpPage.errShortUsername());
    }   // пытаемся зарегистрироваться с коротким юзернеймом --> проверяем появление ошибки
    @Test
    public void signUpWithShortPasswordTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "validUsername", "pass");
        signUpPage.createAccountButton();
        Assert.assertEquals("is too short (minimum is 6 characters)", signUpPage.errShortPassword());
    }   // пытаемся зарегистрироваться с коротким паролем -->   проверяем появление ошибки
    @Test
    public void signUpWithAlreadyTakenUsernameTest() {
        mainPage.fSharpLanguage("valid");
        signUpPage.tryToSignUp("validEmail@gmail.com", "qwerty", "valid_password");
        signUpPage.createAccountButton();
        Assert.assertEquals("is already taken", signUpPage.errUsernameIsAlreadyTaken());
    }   // пытаемся зарегистрироваться с занятым юзернеймом -->   проверяем появление ошибки
    @After
    public void tearDown() {
        driver.quit();
    }
}
