import codewars.LoginPage;
import codewars.MainPage;
import codewars.ProfileSettingsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class ProfileSettingsTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfileSettingsPage profileSettings;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://codewars.com");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profileSettings = new ProfileSettingsPage(driver);
    }
    @Test
    public void setNameAndCompanyFieldsTest() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "password2");
        profileSettings.clickProfileSettingsButton();
        profileSettings.setNameSkillsAndCompanyFields("testname", "testcompany", "testskills");
        Assert.assertEquals("You updated your account successfully.\n×",
                profileSettings.getSuccessfullySettingsUpdateText());
        Assert.assertEquals("testname", profileSettings.getNameText());
        Assert.assertEquals("testcompany", profileSettings.getCompanyText());
        Assert.assertEquals("testskills", profileSettings.getSkillsText());
    }   // логинимся --> изменяем поля в профиле --> проверяем появления успешного апдейта --> проверяем соответсвие текста полей
    @Test
    public void clickProfileRadioButtonsTest() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "password2");
        profileSettings.clickProfileSettingsButton();
        profileSettings.clickProfileRadioButtons();
        Assert.assertTrue(profileSettings.isSelectedEmailNotificationsRadioButtons());
        Assert.assertTrue(profileSettings.isSelectedExperienceRadioButton());
        profileSettings.clickConfirmNewUpdates();
        Assert.assertEquals("You updated your account successfully.\n×",
                profileSettings.getSuccessfullySettingsUpdateText());
    }   // логинимся --> кликаем радио баттоны --> проверяем успешно ли --> сохраняем --> проверям успешно ли
    @Test
    public void tryToChangePasswordTest() {
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "password2");
        profileSettings.clickProfileSettingsButton();
        profileSettings.tryToChangePassword("password1", "password1","password2");
        Assert.assertEquals("You updated your account successfully.\n×",
                profileSettings.getSuccessfullySettingsUpdateText());
        profileSettings.clickLogOutButton();
        mainPage.clickSignIn();
        loginPage.tryToLogin("regresamit@gmail.com", "password1");
        Assert.assertTrue(loginPage.checkHomePageHeader());
    }   // логинимся --> вводим новый пароль --> сохраняем --> LogOut --> LogIn с новым паролем --> проверяем наличие шапки профиля
    @After
    public void tearDown() {
        driver.quit();
    }
}
