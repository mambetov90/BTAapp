import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CoreTest;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertTrue;

public class BtaTest extends CoreTest {

    private static final Logger log = LoggerFactory.getLogger(BtaTest.class);

    @Test
    public void insurancePolicyTest() {

        log.info("Atvērt BTA portālu un pārvietoties uz ceļojuma polišu iegādes formu");
        mainPage.openTravelFromMenuPanel();

        log.info("Nomainīt ceļojumā mērķi uz Indija izmantojot “Izvēlies valstis un Pārbaudīt vai ceļojuma mērķis ir nomainīts");
        travelInsurancePage
                .openTravelDestinationList()
                .selectFinalDestinationFromPopup()
                .searchForIndiaAsCountry();

        travelInsurancePage.indiaCountryLabel.shouldBe(visible);

        log.info("Nomainīt  aktivitāti uz “Sports” Pārbaudīt vai aktivitāte nomainīta");
        travelInsurancePage
                .submitSearchedCountry()
                .openActivitiesList()
                .selectSportFromActivityTypePopup();

        travelInsurancePage.sportAsActivityLabel.shouldBe(visible);

        log.info("Pārvietoties uz otro soli");
        travelInsurancePage.pressCalculateTravelInsurancePrice();

        log.info("Izvēlēties Optimal un Atvērt ”Apskati, kas ir apdrošināts” izvēlētajai programmai, kā arī pārbaudīt vai uzlecošā forma ir atvērusies");
        policyPage
                .chooseOptimalPlusAsPolicyPlan()
                .openWhatCoveredPopup();

        policyPage.whatCoveredPopup.shouldBe(visible);

        log.info("Aizvērt, pārvietoties uz nākamo soli un pārbaudīt vai ceļotāja lauki ir redzami un tie ir tukši");
        policyPage.closeWhatCoveredPopupAndContinue();

        policyPage.insuredTravelerFirstName.shouldBe(visible);
        policyPage.insuredTravelerFirstName.shouldBe(empty);
        policyPage.insuredTravelerLastName.shouldBe(visible);
        policyPage.insuredTravelerLastName.shouldBe(empty);
        policyPage.insuredTravelerPersonalId.should(visible);
        policyPage.insuredTravelerPersonalId.shouldBe(empty);
    }
}
