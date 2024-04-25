package fiverr;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class TariffTest {
    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;

    @BeforeAll
    static void init() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Артём\\Desktop\\ИТМО\\6 семестр\\tpo_lab_3\\src\\main\\resources\\msedgedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Артём\\Desktop\\ИТМО\\6 семестр\\tpo_lab_3\\src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 Edg/124.0.0.0");

        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeDriver = new EdgeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--remote-allow-origins=*");
        options1.addArguments("--disable-blink-features=AutomationControlled");
        options1.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0");
        options1.setPageLoadStrategy(PageLoadStrategy.NONE);
        firefoxDriver = new FirefoxDriver();
    }

    @AfterAll
    static void destroy() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    private void changeTariff(WebDriver driver) throws InterruptedException {
        Thread.sleep((long) (Math.random() * 10000));
        driver.get("https://www.fiverr.com/");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1936, 1096));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//h3")).click();
        Thread.sleep((long) (Math.random() * 10000));
        String tariff = driver.findElement(By.xpath("//b")).getText();
        driver.findElement(By.xpath("//label[contains(.,'Standard')]")).click();
        String tariff2 = driver.findElement(By.xpath("//b")).getText();
        Assertions.assertNotEquals(tariff, tariff2);
        Assertions.assertEquals("Standard Package", tariff2);
    }

    @Test
    public void changeTariffChrome() throws InterruptedException {
        changeTariff(chromeDriver);
    }

    @Test
    public void changeTariffFirefox() throws InterruptedException {
        changeTariff(firefoxDriver);
    }


}
