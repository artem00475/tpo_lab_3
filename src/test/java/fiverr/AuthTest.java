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

public class AuthTest {
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
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        chromeDriver = new EdgeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--remote-allow-origins=*");
        options1.addArguments("--disable-blink-features=AutomationControlled");
        options1.setPageLoadStrategy(PageLoadStrategy.NONE);
        firefoxDriver = new FirefoxDriver();
    }

    @AfterAll
    static void destroy() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    private void login(WebDriver driver) throws InterruptedException {
        driver.get("https://www.fiverr.com");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1920, 1079));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//p[contains(.,'Continue with email/username')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//section/div/div/div/input")).sendKeys("Tester0047");
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//div[2]/div/div/input")).sendKeys("TestTest1");
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//p[contains(.,'Sign In')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        String greeting = driver.findElement(By.xpath("//h2[text^='Welcome to Fiverr,']")).getText();
        Assertions.assertEquals("Welcome to Fiverr, tester0047 \uD83C\uDF89", greeting);
    }

    @Test
    public void loginChrome() throws InterruptedException {
        login(chromeDriver);
    }

    @Test
    public void loginFirefox() throws InterruptedException {
//        login(firefoxDriver);
    }

    private void logout(WebDriver driver) throws InterruptedException {
        driver.get("https://www.fiverr.com");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1920, 1079));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//figure")).click();
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();
        String greeting = driver.findElement(By.xpath("//h1")).getText();
        Assertions.assertEquals("Find the right freelance service, right away", greeting);
    }

    @Test
    public void logoutChrome() throws InterruptedException {
        logout(chromeDriver);
    }

    @Test
    public void logoutFirefox() throws InterruptedException {
//        logout(firefoxDriver);
    }

    private void wrongLogin(WebDriver driver) throws InterruptedException {
        driver.get("https://www.fiverr.com");
        Thread.sleep((long) (Math.random() * 10000));
        driver.manage().window().setSize(new Dimension(1920, 1079));
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//p[contains(.,'Continue with email/username')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//section/div/div/div/input")).sendKeys("Tester123");
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//div[2]/div/div/input")).sendKeys("TestTest1");
        Thread.sleep((long) (Math.random() * 10000));
        driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
        Thread.sleep((long) (Math.random() * 10000));
        String greeting = driver.findElement(By.xpath("//section/div[3]/p']")).getText();
        Assertions.assertEquals("Wrong email or password", greeting);
    }

    @Test
    public void wrongLoginChrome() throws InterruptedException {
        wrongLogin(chromeDriver);
    }

    @Test
    public void wrongLoginFirefox() throws InterruptedException {
//        wrongLogin(firefoxDriver);
    }


}
