import AbstractComponents.SearchFlightAvailability;
import PageComponentes.MultiTrip;
import PageComponentes.RoundTrip;
import Pages.TravelHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoTest {
    TravelHomePage travelHomePage;
    WebDriver driver;

    @Test
    public void flightTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        travelHomePage.chooseBookStrategy("roundtrip");
        travelHomePage.bookTrip("MAA", "HYD");
    }
}
