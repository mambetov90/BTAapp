package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


abstract public class CoreTest {
    public MainPage mainPage;
    public TravelInsurancePage travelInsurancePage;
    public PolicyPage policyPage;
    
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Before
    public void init() throws InterruptedException {
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
