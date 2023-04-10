package PageComponentes;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(String from, String destination) {
        System.out.println("I'm inside the multi trip");
        find(multiCity_rdo).click();
        find(modalPopUp).click();
        selectOriginCity(from);
        selectDestinationCity(destination);
        selectDestinationCity2("BLR");
    }

    public void selectOriginCity(String origin)
    {
        find(from).click();
        find(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        find(to).click();
        find(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        find(destination_2).click();
        find(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }
}
