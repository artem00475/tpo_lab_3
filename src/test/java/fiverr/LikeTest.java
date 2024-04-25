package fiverr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class LikeTest {
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
        chromeDriver = new EdgeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--remote-allow-origins=*");
        firefoxDriver = new FirefoxDriver();
    }

    private void likeService(WebDriver driver) throws InterruptedException {
        driver.get("https://www.fiverr.com/start_selling");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1936, 1096));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//h3")).click();
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"__ZONE__main\"]/div/div/div[2]/div[1]/div/aside/div[1]/div/div[1]/div/div[2]/span/button"));
        String classList = btn.getAttribute("classList");
        btn.click();
        Assertions.assertNotEquals(classList, btn.getAttribute("classList"));
    }

    private void dislikeService(WebDriver driver) throws InterruptedException {
        driver.get("https://www.fiverr.com/start_selling");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1936, 1096));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//h3")).click();
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"__ZONE__main\"]/div/div/div[2]/div[1]/div/aside/div[1]/div/div[1]/div/div[2]/span/button"));
        String classList = btn.getAttribute("classList");
        btn.click();
        Assertions.assertNotEquals(classList, btn.getAttribute("classList"));
    }

    @Test
    public void likeServiceChrome() throws InterruptedException {
        likeService(chromeDriver);
    }

    @Test
    public void likeServiceFirefox() throws InterruptedException {
//        likeService(firefoxDriver);
    }

    @Test
    public void dislikeServiceChrome() throws InterruptedException {
        dislikeService(chromeDriver);
    }

    @Test
    public void dislikeServiceFirefox() throws InterruptedException {
//        likeService(firefoxDriver);
    }
}
