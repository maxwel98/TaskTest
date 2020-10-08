package org.tasktest.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /*
            Локаторы
     */
    // определение локатора для кнопки написания письма
    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")
    private WebElement writeMailBtn;

    // определение локатора поля ввода адресата
    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea")
    private WebElement destinationMailField;

    // определение локатора поля ввода темы письма
    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/div/input")
    private WebElement topicMailField;

    // определение локатора поля ввода текста письма
    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div")
    private WebElement textMailField;

    // определение локатора для кнопки оправления письма
    @FindBy(xpath = "/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]")
    private WebElement sendBtn;

    /*
            Методы
     */
    // метод для ввода адресата
    public void inputDestinationMail(String destinationMail) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='maxwel98@yandex.ru';", destinationMailField);
        //destinationMailField.click();
        //destinationMailField.sendKeys(destinationMail);
    }

    // метод для ввода темы
    public void inputTopicMail(String topicMail) {
        topicMailField.sendKeys(topicMail); }

    // метод для ввода текста
    public void inputTextMail(String textMail) {
        textMailField.sendKeys(textMail); }

    // метод для нажатия кнопки отправления
    public void clickSendBtn(){
        sendBtn.click();
    }

    // метод для нажатия кнопки написания письма
    public void clickWriteMailBtn(){
        writeMailBtn.click();
    }




}
