package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class PolicyPage extends CoreTest {

    public final SelenideElement insuredTravelerFirstName = $(byId("travelerFirstName0")),
            insuredTravelerLastName = $(byId("travelerLastName0")),
            insuredTravelerPersonalId = $(byId("travelerIdentityNumber0")),
            whatCoveredPopup = $("div[class='covered-popup-travel']");

    static final SelenideElement whatsCoveredButton = $("button[data-param='{\"id\":\"OPP\"}'] span[class='title popup-title']"),
            chooseOptimalPlusButton = $(".button.hide-on-mobile.red[data-param='{\"id\":\"OPP\"}']"),
            closeWhatCoveredButton = $("button[class='popup-close close']"),
            submitOptimalPlusPlanButton = $("button[data-button='submit']");

    public PolicyPage chooseOptimalPlusAsPolicyPlan() {
        Selenide.executeJavaScript("arguments[0].click();", chooseOptimalPlusButton);
        return this;
    }

    public PolicyPage openWhatCoveredPopup() {
        Selenide.executeJavaScript("arguments[0].click();", whatsCoveredButton);
        return this;
    }

    public PolicyPage closeWhatCoveredPopupAndContinue() {
        closeWhatCoveredButton.click();
        submitOptimalPlusPlanButton.click();
        return this;
    }
}
