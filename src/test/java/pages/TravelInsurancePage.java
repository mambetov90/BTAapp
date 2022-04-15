package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TravelInsurancePage extends CoreTest {
    static final SelenideElement travelDestinationList = $(byId("regionalSelectorRegion-open")),
            countriesButton = $(byId("regionalSelectorCountry-showListSearch")),
            adCountryButton = $(byId("regionalSelectorCountry-addCountry")),
            countrySearchField = $(byId("regionalSelectorCountry-typedValue")),
            indiaFromSearchList = $("button[data-value='Indija']"),
            applyButton = $(byId("regionalSelectorCountry-applyButton")),
            activitiesList = $(byId("travelActivities-open")),
            sportAsActivity = $(byId("travelActivities-popup-select-option-3")),
            calculatePriceButton = $("button[data-type='travelSubmit']");

    public final SelenideElement indiaCountryLabel = $(byText("Indija")),
            sportAsActivityLabel = $(byText("Sports"));

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