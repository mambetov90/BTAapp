package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import readProps.ConfigProvider;

public class MainPage extends CoreTest {
    private final SelenideElement cookiesPopup = Selenide.$("div[class='cookie-notice strong']"),
            acceptButton = Selenide.$x("//button[@class='button green allow']"),
            travelMenuLabel = Selenide.$(Selectors.byText("Ceļojumi"));

    public MainPage() {
        Selenide.open(ConfigProvider.URL);
        this.acceptCookies();
    }

    public void acceptCookies() {
        if (this.cookiesPopup.isDisplayed()) {
            this.acceptButton.click();
        }

    }

    public TravelInsurancePage openTravelFromMenuPanel() {
        this.travelMenuLabel.click();
        return new TravelInsurancePage();
    }
}
