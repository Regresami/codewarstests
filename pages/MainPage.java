package codewars;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private Actions action;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    /*
    ��� ����, ����� ������ ����������� �� codewars.com �� ������ ��� ������ ������ ������������� ���� � ������� ������� �
    �����, ������� �� �������. � ������ ������ ����� ���������� �������������� ��������� � �������������� �����������.
    ������ ����� ����� ���� �� ������ ��������� �� ����� �����������.
    */
    @FindBy(xpath = "//a[text()='Log In']")
    private WebElement signInButton;
    @FindBy(xpath = "//form[@class='simple_form mbn']")
    private WebElement signUpElement;
    @FindBy(xpath = "//*[@id='attempt_btn']")
    private WebElement submitSignUpButton;
    @FindBy(xpath ="//a[@data-track='Language Tab Clicked']")
    private List<WebElement> languageList;
    // ��� �������� � ���������� ���� ������� ���� ��� ���������, � �������� �� ����� �������� �������� ������ �� �������
    @FindBy(xpath = "(//span[text()='a'])[2]")
    private WebElement clojureButton;
    @FindBy(xpath = "(//span[text()='b'])[2]")
    private WebElement cButton;
    @FindBy(xpath = "(//span[text()='a'])[2]")
    private WebElement cPlusPlusButton;
    @FindBy(xpath = "(//span[text()='b'])[2]")
    private WebElement cSharpButton;
    @FindBy(xpath = "(//span[text()='y'])[1]")
    private WebElement crystalButton;
    @FindBy(xpath = "(//span[text()='b'])[2]")
    private WebElement dartButton;
    @FindBy(xpath = "(//span[text()='int'])[3]")
    private WebElement dartButton2;
    @FindBy(xpath = "(//span[text()='b'])[1]")
    private WebElement elixirButton;
    @FindBy(xpath = "(//span[text()='b'])[1]")
    private WebElement fSharpButton;

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }
    public boolean isPresentAndDisplayedSignUpElement() {
        try {
            return signUpElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } // ����� �� ��������� boolean, ������� ���� ������� SignUp �������� � ���� ��� �����, ������� �� �� ������
    }     // ���� ���������� ������. ����� ������� � ���������� FALSE, ��� ��� "������" FALSE isDisplayed'a ������ ���
          // �� ����� ����� ��������, ���� �� �� ����� �������� �� ��������.

    public MainPage clojureLanguage(String validOrInvalidCase) {
        // ����� �� ������ ������������ ������� �������� ����������. valid/invalid
        // valid - ���������� ��������, � ������� �� ���������� ���������� ������ ��� ������
        // invalid - ����������/������������ ������
        languageList.get(0).click(); // ���������� � ����� ��� ��������� � ������� �� ���� Clojure
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(clojureButton).doubleClick().click().sendKeys("(* a b))").perform();
        // � ���� ������� �� ������� � ������� Actions ������, ������� "�����" ������ �������� ������ ��� ������ � �������� �������� ������
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(clojureButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage cLanguage(String validOrInvalidCase) {
        languageList.get(2).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(cButton).click().sendKeys("*").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(cButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage cPlusLanguage(String validOrInvalidCase)  {
        languageList.get(3).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(cPlusPlusButton).click().sendKeys("return ").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(cPlusPlusButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage cSharpLanguage(String validOrInvalidCase)  {
        languageList.get(4).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(cSharpButton).click().sendKeys("*").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(cSharpButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage crystalLanguage(String validOrInvalidCase) {
        languageList.get(5).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(crystalButton).click().sendKeys(",").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(crystalButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage dartLanguage(String validOrInvalidCase)  {
        languageList.get(6).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(dartButton).doubleClick().click().sendKeys(" return (a*b); ").perform();
            action.moveToElement(dartButton2).doubleClick()
                .click().sendKeys("int multiply(int a, int b){ ").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(dartButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage elixirLanguage(String validOrInvalidCase) {
        languageList.get(7).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(elixirButton).click().sendKeys(",").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(elixirButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
    public MainPage fSharpLanguage(String validOrInvalidCase) {
        languageList.get(8).click();
        if(validOrInvalidCase.equals("valid"))
            action.moveToElement(fSharpButton).doubleClick().click()
                    .sendKeys("let multiply a b = a * b").perform();
        if(validOrInvalidCase.equals("invalid"))
            action.moveToElement(fSharpButton).doubleClick().click().sendKeys("invalid test case").perform();
        submitSignUpButton.click();
        return new MainPage(driver);
    }
}
