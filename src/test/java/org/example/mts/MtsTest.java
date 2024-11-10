package org.example.mts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void initDriver() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.id("cookie-agree"));
        if (button.isDisplayed()) {
            button.click();
        }
    }

    @DisplayName("Проверить название указанного блока")
    @Test
    public void test1() {
        WebElement title1 = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        title1.getText();
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", title1.getText());
    }

    @DisplayName("Проверить наличие логотипов платежных систем")
    @Test
    public void test2() {
        List<String> logosNames = new ArrayList<>();
        List<WebElement> logos = driver.findElements(By.tagName("img"));
        for (WebElement logo : logos) {
            logosNames.add(logo.getAttribute("alt"));
        }
        Assertions.assertTrue(logosNames.contains("Visa"));
        Assertions.assertTrue(logosNames.contains("Verified By Visa"));
        Assertions.assertTrue(logosNames.contains("MasterCard"));
        Assertions.assertTrue(logosNames.contains("MasterCard Secure Code"));
        Assertions.assertTrue(logosNames.contains("Белкарт"));
    }

    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе' ")
    @Test
    public void test3() {
        WebElement link1 = driver.findElement(By.linkText("Подробнее о сервисе"));
        link1.click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить'")
    @Test
    public void test4() {
        WebElement phone = driver.findElement(By.id("connection-phone"));
        WebElement sum = driver.findElement(By.id("connection-sum"));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        phone.sendKeys("297777777");
        sum.sendKeys("100");
        buttonContinue.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement frame = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(frame);
        WebElement googleButton = driver.findElement(By.id("gpay-button-online-api-id"));
        Assertions.assertTrue(googleButton.isDisplayed());
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
