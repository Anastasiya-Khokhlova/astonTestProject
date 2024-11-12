package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentFramePage {
    WebDriver driver;

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
    }
    By payDescriptionCost = By.className("pay-description__cost");
    By payButton = By.cssSelector("[type='submit']");
    By payDescriptionText = By.className("pay-description__text");
    By cardNumber = By.xpath("/html/body/app-root/div/div/div/" +
            "app-payment-container/section/div/app-card-page/div/div[1]/" +
            "app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    By validityPeriod = By.xpath("/html/body/app-root/div/div/div/" +
            "app-payment-container/section/div/app-card-page/div/div[1]/" +
            "app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    By cvc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/" +
            "section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/" +
            "app-input/div/div/div[1]/label");
    By cardholderName = By.xpath("/html/body/app-root/div/div/div/" +
            "app-payment-container/section/div/app-card-page/div/div[1]/" +
            "app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");
    By allImages = By.tagName("img");
    By googleButton = By.id("gpay-button-online-api-id");

    public String getCardNumberPlaceholder() {
        return driver.findElement(cardNumber).getAttribute("innerText");
    }

    public String getValidityPeriodPlaceholder() {
        return driver.findElement(validityPeriod).getAttribute("innerText");
    }

    public String getCvcPlaceholder() {
        return driver.findElement(cvc).getAttribute("innerText");
    }

    public String getCardholderNamePlaceholder() {
        return driver.findElement(cardholderName).getAttribute("innerText");
    }

    public String getPayDescriptionCost () {
        return driver.findElement(payDescriptionCost).getAttribute("innerText");
    }

    public String getPayButtonText () {
        return driver.findElement(payButton).getAttribute("innerText");
    }

    public String getPayDescriptionText () {
        return driver.findElement(payDescriptionText).getAttribute("innerText");
    }

    public List<WebElement> getAllPayIcons() {
        return driver.findElements(allImages);
    }

    public boolean isGoogleButtonDisplayed() {
        return driver.findElement(googleButton).isDisplayed();
    }


}
