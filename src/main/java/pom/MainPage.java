package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage {
    // URL главной страницы
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка закрытия всплывающего окна
    private final By cookieButton = By.id("rcc-confirm-button");

    // Кнопка заказа вверху страницы
    private final By orderButtonTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // Кнопка заказа внизу страницы
    private final By orderButtonBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']");

    // Кнопка "Сколько это стоит? И как оплатить?"
    private final By howMuchButton = By.id("accordion__heading-0");

    // Текст ответа на вопрос "Сколько это стоит? И как оплатить"
    private final By howMuchButtonText = By.xpath(".//div[@id='accordion__panel-0']/p");

    // Кнопка "Хочу сразу несколько самокатов! Так можно?"
    private final By severalScooterButton = By.id("accordion__heading-1");

    // Текст ответа на вопрос "Хочу сразу несколько самокатов! Так можно?"
    private final By severalScooterButtonText = By.xpath(".//div[@id='accordion__panel-1']/p");

    // Кнопка "Как рассчитывается время аренды?"
    private final By rentalTimeButton = By.id("accordion__heading-2");

    // Текст ответа на вопрос "Как рассчитывается время аренды?"
    private final By rentalTimeButtonText = By.xpath(".//div[@id='accordion__panel-2']/p");

    // Кнопка "Можно ли заказать самокат прямо на сегодня?"
    private final By oderTodayButton = By.id("accordion__heading-3");

    // Текст ответа на вопрос "Можно ли заказать самокат прямо на сегодня?"
    private final By oderTodayButtonText = By.xpath(".//div[@id='accordion__panel-3']/p");

    // Кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By extendOderButton = By.id("accordion__heading-4");

    // Текст ответа на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By extendOderButtonText = By.xpath(".//div[@id='accordion__panel-4']/p");

    // Кнопка "Вы привозите зарядку вместе с самокатом?"
    private final By takeChargeButton = By.id("accordion__heading-5");

    // Текст ответа на вопрос "Вы привозите зарядку вместе с самокатом?"
    private final By takeChargeButtonText = By.xpath(".//div[@id='accordion__panel-5']/p");

    // Кнопка "Можно ли отменить заказ?"
    private final By cancelOderButton = By.id("accordion__heading-6");

    // Текст ответа на вопрос "Можно ли отменить заказ?"
    private final By cancelOderButtonText = By.xpath(".//div[@id='accordion__panel-6']/p");

    // Кнопка "Я живу за МКАДом, привезёте?"
    private final By liveMKADButton = By.id("accordion__heading-7");

    // Текст ответа на вопрос "Я живу за МКАДом, привезёте?"
    private final By liveMKADButtonText = By.xpath(".//div[@id='accordion__panel-7']/p");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод открытия страницы
    public void openMainPage() {
        driver.get(url);
    }

    // Метод закрытия страницы
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }

    // Метод нажатия на кнопку
    public void clickButton(By button) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        driver.findElement(button).click();
    }

    // Метод открывающий текст при нажатии на кнопку
    public String checkingAnswerQuestion(By button, By buttonText) {

        driver.findElement(button).click();
        return driver.findElement(buttonText).getText();
    }

    // Метод проверяет, что текст при нажатии на кнопку верный
    public void testTextEqualsAnswerQuestion(By button, By buttonText, String expectedResult) {
        String actualResult = checkingAnswerQuestion(button, buttonText);
        Assert.assertEquals(actualResult, expectedResult);
    }


    // Метод выбора через какую кнопку заказа начать оформление
    public void clickOrderButton(int number) {
        if (number == 0) {
            driver.findElement(orderButtonTop).click();
        } else if (number == 1) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                    driver.findElement(orderButtonBottom));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.findElement(orderButtonBottom).click();
                  }
    }


}
