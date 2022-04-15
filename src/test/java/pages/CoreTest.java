package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;


abstract public class CoreTest {
    public MainPage mainPage;
    public TravelInsurancePage travelInsurancePage;
    public PolicyPage policyPage;
    
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Before
    public void init() {
        setUp();
        mainPage = new MainPage();
        travelInsurancePage = new TravelInsurancePage();
        policyPage = new PolicyPage();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
