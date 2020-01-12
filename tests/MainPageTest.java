import codewars.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("http://codewars.com/join");
        mainPage = new MainPage(driver);
    }
    @Test
    public void clojureTest() {
        mainPage.clojureLanguage("valid");
        Assert.assertTrue(mainPage.isPresentAndDisplayedSignUpElement());
    }   // попытка успешного прохождения задачи и получения TRUE значения отображения элемента страницы регистрации
    @Test
    public void cTest() {
        mainPage.cLanguage("invalid");
        Assert.assertFalse(mainPage.isPresentAndDisplayedSignUpElement());
    }   // попытка неправильного прохождения задачи и получения FALSE значения отображения элемента страницы регистрации
    @Test
    public void cPlusTest() {
        mainPage.cPlusLanguage("valid");
        Assert.assertTrue(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @Test
    public void cSharpTest() {
        mainPage.cSharpLanguage("invalid");
        Assert.assertFalse(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @Test
    public void crystalTest() {
        mainPage.crystalLanguage("valid");
        Assert.assertTrue(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @Test
    public void dartTest() {
        mainPage.dartLanguage("invalid");
        Assert.assertFalse(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @Test
    public void elixirTest() {
        mainPage.elixirLanguage("valid");
        Assert.assertTrue(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @Test
    public void fSharpTest() {
        mainPage.fSharpLanguage("invalid");
        Assert.assertFalse(mainPage.isPresentAndDisplayedSignUpElement());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
