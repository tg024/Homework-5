import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_5 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://en.ventis.com/");
        Thread.sleep(1000);
    }

    //Register with valid credentials
    @Test
    public void validCredentials() throws InterruptedException{
        driver.findElement(By.id("Preferences_LanguageCode")).click();
        Thread.sleep(1000);
        Select language = new Select(driver.findElement(By.id("Preferences_LanguageCode")));
        language.selectByIndex(2);
        driver.findElement(By.id("btn-login-menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='New on Ventis?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("registerEmail")).sendKeys("lekawobu@acrossgracealley.com");
        driver.findElement(By.id("registerPassword")).sendKeys("test1234");
        driver.findElement(By.id("day")).click();
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(5);
        driver.findElement(By.id("month")).click();
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByIndex(3);
        driver.findElement(By.id("year")).click();
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByIndex(2);
        driver.findElement(By.id("registerPhone")).sendKeys("552000000");
        driver.findElement(By.id("registerTermini")).click();
        driver.findElement(By.id("registerPrivacy")).click();
        driver.findElement(By.id("ko_mkt_diretto")).click();
        driver.findElement(By.id("ko_cessione_dati")).click();
        driver.findElement(By.id("registerButton")).click();
        Thread.sleep(5000);
    }

    //Register with invalid password format
    @Test
    public void InvalidPassword() throws InterruptedException{
        driver.findElement(By.id("Preferences_LanguageCode")).click();
        Thread.sleep(1000);
        Select language = new Select(driver.findElement(By.id("Preferences_LanguageCode")));
        language.selectByIndex(2);
        driver.findElement(By.id("btn-login-menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='New on Ventis?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("registerEmail")).sendKeys("lekawobu@acrossgracealley.com");
        driver.findElement(By.id("registerPassword")).sendKeys("test");
        driver.findElement(By.id("day")).click();
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(5);
        driver.findElement(By.id("month")).click();
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByIndex(3);
        driver.findElement(By.id("year")).click();
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByIndex(2);
        driver.findElement(By.id("registerPhone")).sendKeys("552000000");
        driver.findElement(By.id("registerTermini")).click();
        driver.findElement(By.id("registerPrivacy")).click();
        driver.findElement(By.id("ko_mkt_diretto")).click();
        driver.findElement(By.id("ko_cessione_dati")).click();
        driver.findElement(By.id("registerButton")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
