package org.tasktest;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.tasktest.conf.ConfProperties;
import org.tasktest.page.*;
import ru.yandex.qatools.allure.junit.AllureRunListener;


public class LoginTest {

    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static SeekPage seekPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //JUnitCore runner = new JUnitCore();
        //runner.addListener(new AllureRunListener()); runner.run(CalculatorTest.class);
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver",
                ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        seekPage = new SeekPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("stackloginpage"));
    }

    @Test
    public void loginTest() throws AWTException {
        /*
            Авторизируемся на Почте Google
         */
        //Заходим на StackOwerflow
        loginPage.clickStackLoginBtn();
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку Далее
        loginPage.clickIdentifierNextBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку Далее
        loginPage.clickPasswordNextBtn();

        driver.get(ConfProperties.getProperty("loginpage"));
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку Далее
        loginPage.clickIdentifierNextBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку Далее
        loginPage.clickPasswordNextBtn();
        //Заходим на Почту Google
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(ConfProperties.getProperty("mailpage"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*
            Определяем, сколько писем пришло от Имени
         */
        //вводим Имя для поиска количества писем
        seekPage.inputSeekName(ConfProperties.getProperty("seekname"));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Robot e = new Robot();
        //нажимаем Enter
        //e.keyPress(KeyEvent.VK_ENTER);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seekPage.clickAdvancedSeekBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seekPage.clickSeekBtn();
        //Определяем количество писем
        String seekname = new String();
        try {
            seekname = seekPage.getQuantityMail();
        }catch (Exception NoSuchElementException){
            seekname = "0";
        }


        /*
            Отправляем письмо
         */
        //Нажимаем кнопку Написать
        mailPage.clickWriteMailBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //mailPage = new MailPage(driver);
        // Заполняем текст
        mailPage.inputTextMail(ConfProperties.getProperty("textmail")+"Total letters - "+ seekname + ".");
        // Заполняем тему
        mailPage.inputTopicMail(ConfProperties.getProperty("topicmail"));
        // Пишем адрессата
        mailPage.inputDestinationMail(ConfProperties.getProperty("destinationmail"));
        //Отправляем
        mailPage.clickSendBtn();




        }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */


}
