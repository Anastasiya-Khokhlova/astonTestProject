package org.example;

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
    public void initDriver(){
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
    public void checkElementName() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", onlinePaymentPage.getMainHeader());
    }

    @DisplayName("Проверить наличие логотипов платежных систем")
    @Test
    public void checkForLogos() {
       OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        List<String> logosNames = new ArrayList<>();
        List<WebElement> logos = onlinePaymentPage.getAllPayIcons();
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
    public void checkLink() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.linkClick();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить'")
    @Test
    public void enterFieldsAndCheckButton() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.enterConnectionPhone("297777777");
        onlinePaymentPage.enterConnectionSum("100.25");
        onlinePaymentPage.clickButtonContinue();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[8]/div/iframe")));
        PaymentFramePage paymentFramePage = new PaymentFramePage(driver);
        Assertions.assertTrue(paymentFramePage.isGoogleButtonDisplayed());
    }
   @DisplayName("Проверить надписи в незаполненных полях")
   @Test
    public void checkConnectionPlaceholders() {
       OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
       Assertions.assertEquals("Номер телефона", onlinePaymentPage.getPhonePlaceholder());
       Assertions.assertEquals("Сумма", onlinePaymentPage.getSumPlaceholder());
       Assertions.assertEquals("E-mail для отправки чека", onlinePaymentPage.getEmailPlaceholder());
   }
    @DisplayName("Проверить надписи в незаполненных полях")
    @Test
    public void checkInternetPlaceholders() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        Assertions.assertEquals("Номер абонента", onlinePaymentPage.getInternetPhonePlaceholder());
        Assertions.assertEquals("Сумма", onlinePaymentPage.getInternetSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", onlinePaymentPage.getInternetEmailPlaceholder());
    }
    @DisplayName("Проверить надписи в незаполненных полях")
    @Test
    public void checkInstalmentPlaceholders() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        Assertions.assertEquals("Номер счета на 44", onlinePaymentPage.getInstalmentAccountPlaceholder());
        Assertions.assertEquals("Сумма", onlinePaymentPage.getInstalmentSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", onlinePaymentPage.getInstalmentEmailPlaceholder());
    }
    @DisplayName("Проверить надписи в незаполненных полях")
    @Test
    public void checkArrearsPlaceholders() {
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
        Assertions.assertEquals("Номер счета на 2073", onlinePaymentPage.getArrearsAccountPlaceholder());
        Assertions.assertEquals("Сумма", onlinePaymentPage.getArrearsSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", onlinePaymentPage.getArrearsEmailPlaceholder());
   }

   @DisplayName("Проверить корректность отображения полей")
   @Test
   public void checkPaymentFramePlaceholders() {
       String phoneNumber = "297777777";
       String paySum = "100.25";
       OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);
       onlinePaymentPage.enterConnectionPhone(phoneNumber);
       onlinePaymentPage.enterConnectionSum(paySum);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       onlinePaymentPage.clickButtonContinue();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[8]/div/iframe")));
       PaymentFramePage paymentFramePage = new PaymentFramePage(driver);
       Assertions.assertEquals(paySum + " BYN", paymentFramePage.getPayDescriptionCost());
       Assertions.assertEquals("Оплатить " + paySum + " BYN", paymentFramePage.getPayButtonText());
       Assertions.assertEquals("Оплата: Услуги связи Номер:375" + phoneNumber, paymentFramePage.getPayDescriptionText());
       Assertions.assertEquals("Номер карты", paymentFramePage.getCardNumberPlaceholder());
       Assertions.assertEquals("Срок действия", paymentFramePage.getValidityPeriodPlaceholder());
       Assertions.assertEquals("CVC", paymentFramePage.getCvcPlaceholder());
       Assertions.assertEquals("Имя держателя (как на карте)", paymentFramePage.getCardholderNamePlaceholder());
       List<String> logosNames = new ArrayList<>();
       List<WebElement> logos = paymentFramePage.getAllPayIcons();
       for (WebElement logo : logos) {
           logosNames.add(logo.getAttribute("src"));
       }
       Assertions.assertTrue(logosNames.contains("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg"));
       Assertions.assertTrue(logosNames.contains("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg"));
       Assertions.assertTrue(logosNames.contains("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg"));
       Assertions.assertTrue(logosNames.contains("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg"));
       Assertions.assertTrue(logosNames.contains("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg"));
   }

   @AfterEach
    public void closeDriver() {
       driver.quit();
   }

}
