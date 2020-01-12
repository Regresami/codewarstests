package codewars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.xpath("//input[@id='user_email']");
    private By password = By.xpath("//input[@id='user_password']");
    private By loginSubmitButton = By.xpath("//button[@type='submit']");
    private By errorInvalidEmailOrPassword = By.xpath("//div[text()='Invalid Email or password.']");
    private By headerAfterValidLogin = By.xpath("//header[@id='main_header']");

    public LoginPage emailType (String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public LoginPage passwordType (String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public LoginPage tryToLogin(String email, String password) {
        // метод, с помощью которого тестировщик вводит нужные ему данные для логина
        this.emailType(email);
        this.passwordType(password);
        driver.findElement(loginSubmitButton).click();
        return new LoginPage(driver);
    }
    public boolean checkHomePageHeader() {
        return driver.findElement(headerAfterValidLogin).isDisplayed();
    }
    public String ErrInvalidEmailOrPassword() {
        return driver.findElement(errorInvalidEmailOrPassword).getText();
    }
}   // boolean - проверяем методом isDisplayed наличие элемента шапки профиля
    // String - запрашиваем текст ошибки, которая говорит нам об ошибке емеила или пароля
