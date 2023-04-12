import AbstractComponents.SearchFlightAvailability;
import PageComponentes.MultiTrip;
import PageComponentes.RoundTrip;
import Pages.TravelHomePage;
import dataSets.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DemoTest extends BaseTest{
    TravelHomePage travelHomePage;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = initDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        travelHomePage.chooseBookStrategy("roundtrip");


        travelHomePage.bookTrip(reservationDetails);
    }
    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
    @DataProvider
    public Object[][] getData()throws IOException {
        JsonReader jsonReader = new JsonReader();
        List<HashMap<String, String>> listOfHashMaps = jsonReader.getJsonData("D:\\Self Development\\Design patterns\\Rahul Shetty\\DesignPatterns\\DesignPatternsWithDevOps\\src\\test\\java\\dataSets\\reservationDetails.json");
        return new Object[][]{
                {listOfHashMaps.get(0)},
                {listOfHashMaps.get(1)}
        };
    }


}

