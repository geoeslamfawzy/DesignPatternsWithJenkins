package Pages;

import AbstractComponents.SearchFlightAvailability;
import AbstractComponents.StrategyFactor;
import PageComponentes.FooterNavigation;
import PageComponentes.HeaderNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {

        this.driver=driver;

    }

    public void goTo()
    {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public HeaderNavigation getNavigationBar()
    {

        return new HeaderNavigation(driver,footerNavSectionElement);
    }

    public FooterNavigation getFooterNav()
    {
        return new FooterNavigation(driver,sectionElement);
    }

    public void chooseBookStrategy(String bookingType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvailability = strategyFactor.createStrategy(bookingType);
    }

    public void bookTrip(HashMap<String, String> reservationDetails) throws InterruptedException {
        this.searchFlightAvailability.checkAvailability(reservationDetails);
    }
    public String getTitle(){
        return driver.getTitle();
    }

}
