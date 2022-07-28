package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ClaveInvalidaPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CP003_Login_Correcto {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ClaveInvalidaPage claveInvalidaPage;
    private String urlSitio;
    private UserPage userPage;
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
        userPage = new UserPage(loginPage.getDriver());
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
    public void CP003_Login_Correcto(){
        dataCP = DataDriven.getData("CP003_Login_Correcto");
        homePage.IrAIniciarSesion();
        loginPage.esperarXSegundos(3000);
        userPage.imgUser(dataCP.get(1), dataCP.get(2) );


    }

}
