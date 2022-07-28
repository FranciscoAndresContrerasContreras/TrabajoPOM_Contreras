package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ClaveInvalidaPage;
import pages.HomePage;
import pages.LoginPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CP001_Login_Fallido {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ClaveInvalidaPage claveInvalidaPage;
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
        loginPage = new LoginPage(homePage.getDriver());
        claveInvalidaPage = new ClaveInvalidaPage(loginPage.getDriver());
        dataCP = new ArrayList<>();
    }

    @BeforeMethod
    public void preTests(){
        urlSitio = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(urlSitio);
        homePage.maximizarBrowser();
    }

    @AfterTest
    public void posEjecucion(){
        loginPage.finalizartest();

    }

    @Test
    public void CP001_Login_Fallido(){
        dataCP = DataDriven.getData("CP001_Login_Fallido");
        homePage.IrAIniciarSesion();
        loginPage.esperarXSegundos(3000);
        loginPage.loginfallido(dataCP.get(1),dataCP.get(2));
        Assert.assertEquals(claveInvalidaPage.obtenerTituloErrorAuth(),"Nombre de usuario o contraseña incorrectos.");

    }

}
