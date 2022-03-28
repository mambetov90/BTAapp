package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


abstract public class CoreTest {
    public static WebDriver driver;


    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        //Configuration.startMaximized = true;
        //Configuration.pageLoadTimeout = 20000;

    }

    @Before
    public void init() throws InterruptedException {
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }


}
