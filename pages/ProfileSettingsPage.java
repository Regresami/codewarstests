package codewars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProfileSettingsPage {
    private WebDriver driver;
    private Actions action;

    public ProfileSettingsPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    private By profileBar = By.xpath("//div[@class='profile-points']");
    private By profileSettings = By.xpath("(//i[@class='icon-moon-settings '])[1]");
    private By logOutButton = By.xpath("//a[@data-method='delete']");
    private By profileName = By.xpath("//input[@id='user_name']");
    private By profileCompany = By.xpath("//input[@id='user_company']");
    private By profileSkills = By.xpath("//input[@id='user_skills_text']");
    private By ExperienceRadioButton = By.xpath("//input[@id='user_experience_learning']");
    private By EmailNotificationsRadioButton = By.xpath("//input[@id='user_notification_preference_web_only']");
    private By newPassword = By.xpath("//input[@name='user[password]']");
    private By newPasswordConfirmation = By.xpath("//input[@name='user[password_confirmation]']");
    private By currentPassword = By.xpath("//input[@name='user[current_password]']");
    private By confirmNewUpdates = By.xpath("//input[@type='submit']");
    private By successfullyUpdate = By.xpath("//div[@class='alert-box flash-msg notice']");

    public ProfileSettingsPage clickProfileSettingsButton () {
        // ������� ������ Profile Settings ����� �� ����������� �����, �� ������� �� ������ ��������� � ������� moveToElement
        action.moveToElement(driver.findElement(profileBar)).perform();
        driver.findElement(profileSettings).click();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage clickConfirmNewUpdates() { // ������ ������������� ��������� ������ � �������.
        driver.findElement(confirmNewUpdates).click();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage setNameSkillsAndCompanyFields (String name, String company, String skills) {
        // ������� �����, � ������� �������� ����������� ������ �����, ������� �� ��������� ��������� � ����� �������
        driver.findElement(this.profileName).sendKeys(name);
        driver.findElement(this.profileCompany).sendKeys(company);
        driver.findElement(this.profileSkills).sendKeys(skills);
        clickConfirmNewUpdates();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage clickProfileRadioButtons() {
        // ������������ ����� �������
        driver.findElement(ExperienceRadioButton).click();
        driver.findElement(EmailNotificationsRadioButton).click();
        clickConfirmNewUpdates();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage tryToChangePassword (String password, String confirmPassword, String currentPassword) {
        // �����, ������� �� �������� �������� ������ �������
        driver.findElement(this.newPassword).sendKeys(password);
        driver.findElement(this.newPasswordConfirmation).sendKeys(confirmPassword);
        driver.findElement(this.currentPassword).sendKeys(currentPassword);
        clickConfirmNewUpdates();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage clickLogOutButton() {
        // ����� ��� �������� ��������� ��������� ������ �������. LogOut --> LogIn
        action.moveToElement(driver.findElement(profileBar)).perform();
        driver.findElement(logOutButton).click();
        driver.findElement(By.xpath("//div[@class='logo-square']")).click();
        return new ProfileSettingsPage(driver);
    }
    public String getSuccessfullySettingsUpdateText() {
        return driver.findElement(successfullyUpdate).getText(); // ����������� ����� ������������ �������� �� �������� ������������� �������
    }
    public String getNameText() {
        return driver.findElement(profileName).getAttribute("value");// input �� ��������� ��� �������� ����� getText �������
    }                                                                   // ����������� ������� 'value' � ����� ��� ��������
    public String getCompanyText() {
        return driver.findElement(profileCompany).getAttribute("value");
    }
    public String getSkillsText() {
        return driver.findElement(profileSkills).getAttribute("value");
    }
    public boolean isSelectedExperienceRadioButton() {
        return driver.findElement(ExperienceRadioButton).isDisplayed(); // boolean, ������� ���������� ��� TRUE/FALSE ��������� ����� �������
    }
    public boolean isSelectedEmailNotificationsRadioButtons() {
        return driver.findElement(EmailNotificationsRadioButton).isDisplayed();
    }
}