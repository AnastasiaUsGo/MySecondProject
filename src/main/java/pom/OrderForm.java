package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
public class OrderForm {
    private WebDriver driver;
    // Имя
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    // Фамилия
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Адрес
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Станция метро
    private final By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Номера телефона
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private final By next = By.xpath(".//button[text()='Далее']");
    // Дата, когда привезут самокат
    private final By dateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Срок аренды
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-root']");
    // Срок аренды 1 день
    private final By oneDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    // Срок аренды 2 дня
    private final By twoDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");
    // Срок аренды 3 дня
    private final By threeDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");
    // Срок аренды 4 дня
    private final By fourDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='четверо суток']");
    // Срок аренды 5 дней
    private final By fiveDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='пятеро суток']");
    // Срок аренды 6 дней
    private final By sixDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='шестеро суток']");
    // Срок аренды 7 дней
    private final By sevenDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']");
    // Чек бокс цвет самоката чёрный жемчуг
    private final By colorScooterBlack = By.xpath(".//input[@id='black']");
    // Чек бокс цвет самоката серая безысходность
    private final By colorScooterGrey = By.xpath(".//input[@id='grey']");
    // Комментарий для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Заказать
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка подтверждения заказа
    private final By confirmButton  = By.xpath(".//button[text()='Да']");
    // Окно с номером заказ
    private final By orderCreated = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderForm(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ввода имени
    public void inputName(String inputName) {
        driver.findElement(name).click();
        driver.findElement(name).sendKeys(inputName);
    }
    // Метод ввода фамилии
    public void inputSurname(String inputSurname) {
        driver.findElement(surname).click();
        driver.findElement(surname).sendKeys(inputSurname);
    }
    // Метод ввода адреса
    public void inputAddress(String inputAddress) {
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(inputAddress);
    }
    // Метод ввода метро
    public void chooseMetro(String inputMetro) {
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(inputMetro);
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    // Метод ввода адреса
    public void inputNumberPhone(String inputNumberPhone) {
        driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).sendKeys(inputNumberPhone);
    }
    // Метод нажатия на кнопку далее
    public void clickNext() {
        driver.findElement(next).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    // Метод ввода даты
    public void inputDateOrder(String inputDateOrder) {
        driver.findElement(dateOrder).click();
        driver.findElement(dateOrder).sendKeys(inputDateOrder);
        driver.findElement(dateOrder).sendKeys(Keys.ENTER);
    }
    // Метод ввода срока аренды
    public void inputRentalPeriod(int period) {
        if (period > 0 && period <= 7) {
            driver.findElement(rentalPeriod).click();
            if (period == 1) {
                driver.findElement(oneDay).click();
            }
            if (period == 2) {
                driver.findElement(twoDay).click();
            }
            if (period == 3) {
                driver.findElement(threeDay).click();
            }
            if (period == 4) {
                driver.findElement(fourDay).click();
            }
            if (period == 5) {
                driver.findElement(fiveDay).click();
            }
            if (period == 6) {
                driver.findElement(sixDay).click();
            }
            if (period == 7) {
                driver.findElement(sevenDay).click();
            }
        } else {
            System.out.println("Fail");
        }
    }
    // Метод выбора цвета самоката
    public void inputColorScooter(String color) {
        if ("черный жемчуг".equals(color)) {
            driver.findElement(colorScooterBlack).click();
        } else if ("серая безысходность".equals(color)) {
            driver.findElement(colorScooterGrey).click();
        } else  {
            driver.findElement(colorScooterBlack).click();
            driver.findElement(colorScooterGrey).click();
        }
    }
    // Метод для написаня комментария
    public void inputComment(String text) {
        driver.findElement(comment).click();
        driver.findElement(comment).sendKeys(text);
    }
    //Метод заполнения формы 1
    public void enterForm_1(String name, String surname, String address, String metro,
                          String phoneNumber){
        inputName(name);
        inputSurname(surname);
        inputAddress(address);
        chooseMetro(metro);
        inputNumberPhone(phoneNumber);
    }
    //Метод заполнения формы 2
    public void enterForm_2(String data, int period, String color, String comment){
        inputDateOrder(data);
        inputRentalPeriod(period);
        inputColorScooter(color);
        inputComment(comment);
    }
    // Метод нажатия на кнопку в форме заказа
    public void clickOrderButtonForm() {
        driver.findElement(orderButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    // Метод подтверждения данных заказа
    public void clickConfirm() {
        driver.findElement(confirmButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    public void checkOrder() {
        Assert.assertThat(driver.findElement(orderCreated).getText(), containsString("Заказ оформлен"));
    }
}
