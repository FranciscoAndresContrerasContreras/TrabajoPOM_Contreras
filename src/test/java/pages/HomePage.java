package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {

    //Localizadores
    By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

    By locatorBtnIniciarsesión = By.xpath("//div[contains(text(),'Iniciar sesión')]");

    By locatorspotifylogo = By.xpath("//body/div[@id='main']/div[1]/div[2]/nav[1]/div[1]/div[1]/a[1]");

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }


    //acciones
    public void IrAIniciarSesion(){
        click(esperaExplicita(locatorBtnIniciarsesión));
    }

    public void IrARegistrarte(){
        esperarXSegundos(10000);
        click(esperaExplicita(locatorBtnRegistrarte));
        //esperarXSegundos(30000);
    }


}
