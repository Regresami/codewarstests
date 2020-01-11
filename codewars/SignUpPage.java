package codewars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.xpath("//input[@id='user_email']");
    private By username = By.xpath("//input[@id='user_username']");
    private By password = By.xpath("//input[@id='user_password']");
    private By createAccButton = By.xpath("//button[@class='btn is-red']");
    private By errorEmptyField = By.xpath("//small[contains(text(),'blank')]");
    private By errorUsernameIsAlreadyTaken = By.xpath("//small[text()='is already taken']");
    private By errorInvalidEmail = By.xpath("//small[text()='is invalid']");
    private By errorShortPassword = By.xpath("//small[contains(text(),'too short')]");
    private By errorShortUsername = By.xpath("//small[text()='is too short (minimum is 3 characters)']");

    public SignUpPage emailType(String email) {
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public SignUpPage usernameType(String username) {
        driver.findElement(this.username).sendKeys(username);
        return new SignUpPage(driver);
    }
    public SignUpPage passwordType(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public SignUpPage tryToSignUp(String email, String username, String password) {
        this.emailType(email);
        this.usernameType(username);
        this.passwordType(password);
        return new SignUpPage(driver);
    }
    public SignUpPage createAccountButton() {
        driver.findElement(createAccButton).click();
        return new SignUpPage(driver);
    }
    public String errEmptyField() {
        return driver.findElement(errorEmptyField).getText();
    }
    public String errInvalidEmail() {
        return driver.findElement(errorInvalidEmail).getText();
    }
    public String errUsernameIsAlreadyTaken() {
        return driver.findElement(errorUsernameIsAlreadyTaken).getText();
    }
    public String errShortPassword() { return driver.findElement(errorShortPassword).getText(); }
    public String errShortUsername() {
        return driver.findElement(errorShortUsername).getText();
    }

}
