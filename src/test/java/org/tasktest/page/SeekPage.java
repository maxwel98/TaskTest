package org.tasktest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.UnsupportedEncodingException;

public class SeekPage {

        /**
            * конструктор класса, занимающийся инициализацией полей класса
        */
        public WebDriver driver;
        public SeekPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver; }

        /*
                Локаторы
         */
        // определение локатора для поля поиска писем
        @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[2]/div[2]/form/div/table/tbody/tr/td/table/tbody/tr/td/div/input[1]")
        private WebElement seekName;

        //локатор расширенного поиска
        @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[2]/div[2]/form/button[2]")
        private WebElement advancedSeekBtn;
        // определение локатора кнопки поиска
        @FindBy(xpath = "/html/body/div[28]/div/div[2]/div[10]/div[1]")
        private WebElement seekBtn;

        // определение локатора для количества писем
        @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div/span/div[1]/span/span[2]")
        private WebElement quantityMail;

        //метод поиска необходимых писем по отправителю
        public void inputSeekName(String seek) {
            try{
                byte[] b = seek.getBytes();
            seekName.sendKeys(new String(b,"windows-1251"));}
            catch (Exception UnsupportedEncodingException)
            {
            seekName.sendKeys(seek);
            }
        }

        //метод нажатия кнопки раширенного поиска
        public void clickAdvancedSeekBtn(){
            advancedSeekBtn.click();
        }

        //метод нажатия кнопки поиска
        public void clickSeekBtn(){
            seekBtn.click();
        }

        //метод для определения количества писем
        public String getQuantityMail(){
            return quantityMail.getText(); }

}
