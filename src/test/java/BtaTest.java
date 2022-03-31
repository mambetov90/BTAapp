import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CoreTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class BtaTest extends CoreTest {

    private static final Logger log = LoggerFactory.getLogger(BtaTest.class);

    private final SelenideElement indiaCountryLabel = $(byText("Indija"));
    private final SelenideElement sportAsActivityLabel = $(byText("Sports"));
    private final SelenideElement progressBar = $("div[class='content-loader loading']");
    private final SelenideElement whatCoveredPopup = $("div[class='covered-popup-travel']");
    private final SelenideElement insuredTravelerFirstName = $(byId("travelerFirstName0"));
    private final SelenideElement insuredTravelerLastName = $(byId("travelerLastName0"));
    private final SelenideElement insuredTravelerPersonalId = $(byId("travelerIdentityNumber0"));

    @Test
    public void insurancePolicyTest() {

        log.info("Atvērt BTA portālu un pārvietoties uz ceļojuma polišu iegādes formu");
        mainPage
                .openTravelFromMenuPanel();

        log.info("Nomainīt ceļojumā mērķi uz Indija izmantojot “Izvēlies valstis un Pārbaudīt vai ceļojuma mērķis ir nomainīts");
        travelInsurancePage
                .openTravelDestinationList()
                .selectFinalDestinationFromPopup()
                .searchForIndiaAsCountry();

        assertTrue(indiaCountryLabel.shouldBe(visible).isDisplayed());

        log.info("Nomainīt  aktivitāti uz “Sports” Pārbaudīt vai aktivitāte nomainīta");
        travelInsurancePage
                .submitSearchedCountry()
                .openActivitiesList()
                .selectSportFromActivityTypePopup();

        assertTrue(sportAsActivityLabel.shouldBe(visible).isDisplayed());

        log.info("Pārvietoties uz otro soli");
        travelInsurancePage
                .pressCalculateTravelInsurancePrice();

        progressBar.shouldBe(Condition.hidden, Duration.ofMillis(10000));

        log.info("Izvēlēties Optimal un Atvērt ”Apskati, kas ir apdrošināts” izvēlētajai programmai, kā arī pārbaudīt vai uzlecošā forma ir atvērusies");
        policyPage
                .chooseOptimalPlusAsPolicyPlan()
                .openWhatCoveredPopup();

        assertTrue(whatCoveredPopup.shouldBe(visible).isDisplayed());

        log.info("Aizvērt, pārvietoties uz nākamo soli un pārbaudīt vai ceļotāja lauki ir redzami un tie ir tukši");
        policyPage
                .closeWhatCoveredPopupAndContinue();

        progressBar.shouldBe(Condition.hidden, Duration.ofMillis(10000));

        assertTrue(insuredTravelerFirstName.shouldBe(visible).isDisplayed());
        assertTrue(insuredTravelerFirstName.getAttribute("data-store-value").isEmpty());

        assertTrue(insuredTravelerLastName.shouldBe(visible).isDisplayed());
        assertTrue(insuredTravelerLastName.getAttribute("data-store-value").isEmpty());


        assertTrue(insuredTravelerPersonalId.should(visible).isDisplayed());
        assertTrue(insuredTravelerPersonalId.getAttribute("data-store-value").isEmpty());
    }
}
