package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CP004_Registrarte {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private SignupPage signuppage;
    private String urlSitio;
    private ArrayList<String> dataCP;
    private String path;
    private String browser;
    private String propertyDriver;


    //Métodos
    @BeforeTest
    public void preparacionEjecucion(){
        path = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutaDriver")).toString();
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,path,propertyDriver);
        signuppage = new SignupPage(homePage.getDriver());
        dataCP = new ArrayList<>();
    }

    @BeforeMethod
    public void preTests(){
        urlSitio = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(urlSitio);
        homePage.maximizarBrowser();
        homePage.esperarXSegundos(5000);
    }

    @AfterTest
    public void posEjecucion(){
        signuppage.finalizartest();

    }

    @Test
    public void CP004_Registrarte(){
        dataCP = DataDriven.getData("CP004_Registrarte");
        homePage.IrARegistrarte();
        homePage.esperarXSegundos(5000);
        signuppage.Registrarte(dataCP.get(1), dataCP.get(2),dataCP.get(3),dataCP.get(4), dataCP.get(5),dataCP.get(6),dataCP.get(7));


    }

}
