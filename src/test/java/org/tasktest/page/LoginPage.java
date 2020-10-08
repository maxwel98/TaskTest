package org.tasktest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    /*
            Локаторы
     */
    // определяем локатор кнопки входа на StackOwerflow через Google
    @FindBy(xpath = "//*[@id=\"openid-buttons\"]/button[1]")
    private WebElement stackLoginBtn;

     // определение локатора поля ввода логина
    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginField;

    // определение локатора кнопки Далее для входа в аккаунт
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button")
    private WebElement identifierNextBtn;


    // определение локатора поля ввода пароля
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwdField;

    // определение локатора кнопки Далее для входа в аккаунт
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button")
    private WebElement passwordNextBtn;

    //stack click btn
    public void clickStackLoginBtn(){
        stackLoginBtn.click();
    }


    /*
           Методы
     */
    //метод для ввода логина
    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    //метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    // метод для осуществления нажатия кнопки Далее для входа в аккаунт
    public void clickIdentifierNextBtn() {
        identifierNextBtn.click(); }

    // метод для осуществления нажатия кнопки Далее для входа в аккаунт
    public void clickPasswordNextBtn() {
        passwordNextBtn.click(); }
}
