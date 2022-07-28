package tests;

import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.internal.BaseClassFinder;
import pages.HomePage;
import pages.SignupPage;
import utils.BaseClass;
import utils.DataDriven;
import utils.PropertiesDriven;

import javax.xml.crypto.Data;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CP005_Correo_Erroneo {
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

    @AfterMethod
    public void posEjecucion(){
        signuppage.finalizartest();
    }


    @Test
    public void CP005_CorreoErroneo(){
        dataCP = DataDriven.getData("CP005_CorreoErroneo");
        homePage.IrARegistrarte();
        signuppage.esperarXSegundos(5000);
        signuppage.Correo_Erroneo(dataCP.get(1));



    }

}
