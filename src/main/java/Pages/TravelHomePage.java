package Pages;

import AbstractComponents.SearchFlightAvailability;
import PageComponentes.FooterNavigation;
import PageComponentes.HeaderNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void chooseBookStrategy(SearchFlightAvailability searchFlightAvailability ){
        this.searchFlightAvailability = searchFlightAvailability;

    }

    public void checkAvailability(String origin, String destination){
        this.searchFlightAvailability.checkAvailability(origin, destination);
    }

}
