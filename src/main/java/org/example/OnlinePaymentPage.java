package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlinePaymentPage {
    WebDriver driver;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    By mainHeader = By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2");
    By connectionPhone = By.id("connection-phone");
    By connectionSum = By.id("connection-sum");
    By connectionEmail = By.id("connection-email");
    By internetPhone = By.id("internet-phone");
    By internetEmail = By.id("internet-email");
    By internetSum = By.id("internet-sum");
    By instalmentAccount = By.id("score-instalment");
    By instalmentSum = By.id("instalment-sum");
    By instalmentEmail = By.id("instalment-email");
    By arrearsAccount = By.id("score-arrears");
    By arrearsSum = By.id("arrears-sum");
    By arrearsEmail = By.id("arrears-email");
    By buttonContinue = By.xpath("//*[@id=\"pay-connection\"]/button");
    By allImages = By.tagName("img");
    By link = By.linkText("Подробнее о сервисе");

    public void enterConnectionPhone(String phoneNumber) {
        driver.findElement(connectionPhone).sendKeys(phoneNumber);
    }

    public void enterConnectionSum(String sum) {
        driver.findElement(connectionSum).sendKeys(sum);
    }


    public void clickButtonContinue() {
        driver.findElement(buttonContinue).click();
    }


    public String getMainHeader() {
        return driver.findElement(mainHeader).getText();
    }

    public List<WebElement> getAllPayIcons() {
        return driver.findElements(allImages);
    }

    public void linkClick() {
        driver.findElement(link).click();
    }

    public String getPhonePlaceholder() {
        return driver.findElement(connectionPhone).getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return driver.findElement(connectionSum).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(connectionEmail).getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return driver.findElement(internetSum).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmail).getAttribute("placeholder");
    }

    public String getInstalmentAccountPlaceholder() {
        return driver.findElement(instalmentAccount).getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return driver.findElement(instalmentSum).getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(instalmentEmail).getAttribute("placeholder");
    }

    public String getArrearsAccountPlaceholder() {
        return driver.findElement(arrearsAccount).getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return driver.findElement(arrearsSum).getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }

}




