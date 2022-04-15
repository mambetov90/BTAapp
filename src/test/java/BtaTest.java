import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
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

        assertTrue(travelInsurancePage.indiaCountryLabel.shouldBe(visible).isDisplayed());

        log.info("Nomainīt  aktivitāti uz “Sports” Pārbaudīt vai aktivitāte nomainīta");
        travelInsurancePage
                .submitSearchedCountry()
                .openActivitiesList()
                .selectSportFromActivityTypePopup();

        assertTrue(travelInsurancePage.sportAsActivityLabel.shouldBe(visible).isDisplayed());

        log.info("Pārvietoties uz otro soli");
        travelInsurancePage
                .pressCalculateTravelInsurancePrice();

        log.info("Izvēlēties Optimal un Atvērt ”Apskati, kas ir apdrošināts” izvēlētajai programmai, kā arī pārbaudīt vai uzlecošā forma ir atvērusies");
        policyPage
                .chooseOptimalPlusAsPolicyPlan()
                .openWhatCoveredPopup();

        assertTrue(policyPage.whatCoveredPopup.shouldBe(visible).isDisplayed());

        log.info("Aizvērt, pārvietoties uz nākamo soli un pārbaudīt vai ceļotāja lauki ir redzami un tie ir tukši");
        policyPage
                .closeWhatCoveredPopupAndContinue();

        assertTrue(policyPage.insuredTravelerFirstName.shouldBe(visible).isDisplayed());
        assertTrue(policyPage.insuredTravelerFirstName.getAttribute("data-store-value").isEmpty());

        assertTrue(policyPage.insuredTravelerLastName.shouldBe(visible).isDisplayed());
        assertTrue(policyPage.insuredTravelerLastName.getAttribute("data-store-value").isEmpty());


        assertTrue(policyPage.insuredTravelerPersonalId.should(visible).isDisplayed());
        assertTrue(policyPage.insuredTravelerPersonalId.getAttribute("data-store-value").isEmpty());
    }
}
