package pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderFormTest {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;
    private final int period;
    private final int numberButtonOrder;
    private final String color;
    private final String comment;

    public OrderFormTest(int numberButtonOrder, String name, String surname, String address, String metro,
                         String phoneNumber, String date, int period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.numberButtonOrder = numberButtonOrder;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {1, "Иван", "Иванов", "улица Иванова 22", "Таганская", "+79999999999", "03.11.2022", 2,
                        "серая безысходность", "В первой половине дня" },
                {0, "Иван", "Иванов", "улица Иванова 22", "Таганская", "+79999999999", "03.11.2022", 2,
                        "серая безысходность", "В первой половине дня" },
                {1, "Елена", "Прекрасная", "улица Ленина 13", "Тверская", "+79998887654", "01.11.2022", 6,
                        "черный жемчуг", ""},
                {0, "Елена", "Прекрасная", "улица Ленина 13", "Тверская", "+79998887654", "01.11.2022", 6,
                        "черный жемчуг", ""},
        };
    }


    @Before
    public void setUp() throws Exception {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/path/to/webdriver/bin/chromedriver.exe"))
                .build();
        driver = new ChromeDriver(service);
    }

    @Test
    public void OderFormTest() {
       MainPage mainPage = new MainPage(driver);
        OrderForm orderForm = new OrderForm(driver);

        mainPage.openMainPage();
        mainPage.closeCookie();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.clickOrderButton(numberButtonOrder);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        orderForm.inputName(name);
        orderForm.inputSurname(surname);
        orderForm.inputAddress(address);
        orderForm.chooseMetro(metro);
        orderForm.inputNumberPhone(phoneNumber);
        orderForm.clickNext();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        orderForm.inputDateOrder(date);
        orderForm.inputRentalPeriod(period);
        orderForm.inputColorScooter(color);
        orderForm.inputComment(comment);
        orderForm.clickOrderButtonForm();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        orderForm.clickConfirm();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        orderForm.checkOrder();
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
