package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class TravelInsurancePage extends CoreTest {
    private final SelenideElement travelDestinationList = $(byId("regionalSelectorRegion-open"));
    private final SelenideElement countriesButton = $(byId("regionalSelectorCountry"));
    private final SelenideElement adCountryButton = $("div[class='add']");
    private final SelenideElement countrySearchField = $(byId("regionalSelectorCountry-typedValue"));
    private final SelenideElement indiaFromSearchList = $("button[data-value='Indija']");
    private final SelenideElement applyButton = $(byId("regionalSelectorCountry-applyButton"));
    private final SelenideElement activitiesList = $(byId("travelActivities-open"));
    private final SelenideElement sportAsActivity = $(byId("travelActivities-popup-select-option-3"));
    private final SelenideElement calculatePriceButton = $("button[data-type='travelSubmit']");

    public TravelInsurancePage openTravelDestinationList() {
        travelDestinationList.scrollIntoView(true);
        travelDestinationList.click();
        return this;
    }

    public TravelInsurancePage selectFinalDestinationFromPopup() {
        countriesButton.click();
        return this;
    }

    public TravelInsurancePage searchForIndiaAsCountry() {
        adCountryButton.click();
        countrySearchField.setValue("Indija");
        indiaFromSearchList.click();
        return this;
    }

    public TravelInsurancePage submitSearchedCountry() {
        applyButton.click();
        return this;
    }

    public TravelInsurancePage openActivitiesList() {
        activitiesList.click();
        return this;
    }

    public TravelInsurancePage selectSportFromActivityTypePopup() {
        sportAsActivity.click();
        return this;
    }

    public TravelInsurancePage pressCalculateTravelInsurancePrice() {
        calculatePriceButton.click();
        return this;
    }
}