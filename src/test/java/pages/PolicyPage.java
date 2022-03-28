package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PolicyPage extends CoreTest {

    private final SelenideElement whatsCoveredButton = $("button[data-param='{\"id\":\"OPP\"}'] span[class='title popup-title']");
    private final SelenideElement chooseOptimalPlusButton = $(".button.hide-on-mobile.red[data-param='{\"id\":\"OPP\"}']");
    private final SelenideElement closeWhatCoveredButton = $("button[class='popup-close close']");
    private final SelenideElement submitOptimalPlusPlanButton = $("button[data-button='submit']");


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
