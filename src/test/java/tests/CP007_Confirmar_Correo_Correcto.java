package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignupPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CP007_Confirmar_Correo_Correcto {
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
    public void CP007_Confirmar_Correo_Correcto(){
        dataCP = DataDriven.getData("CP007_Confirmar_Correo_Correcto");
        homePage.IrARegistrarte();
        signuppage.esperarXSegundos(5000);
        signuppage.Confirmar_Correo_Correcto(dataCP.get(1), dataCP.get(2));


    }

}
