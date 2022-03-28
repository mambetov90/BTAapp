package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import readProps.ConfigProvider;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends CoreTest {

    private final SelenideElement cookiesPopup = $("div[class='cookie-notice strong']");
    private final SelenideElement acceptButton = $x("//button[@class='button green allow']");
    private final SelenideElement travelMenuLabel = $(byText("Ceļojumi"));

    public MainPage() {
        Selenide.open(ConfigProvider.URL);
        acceptCookies();
    }

    public void acceptCookies() {
        if (cookiesPopup.isDisplayed()) {
            acceptButton.click();
        }
    }

    public TravelInsurancePage openTravelFromMenuPanel() {
        travelMenuLabel.click();
        return new TravelInsurancePage();
    }
}
