package PageComponentes;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNavigation extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public HeaderNavigation(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);

    }

    public String getFlightAttribute()
    {
        return find(flights).getAttribute("class");


    }
    public int getLinkCount()
    {
        return findElements(links).size();
    }
}
