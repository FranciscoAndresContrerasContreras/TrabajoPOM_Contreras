package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ClaveInvalidaPage extends BaseClass {
    public ClaveInvalidaPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar Localizadores
    By locatorTituloErrorAuth = By.xpath("//span[contains(text(),'Nombre de usuario o contraseña incorrectos.')]");

    //Acciones
    public String obtenerTituloErrorAuth(){
        return obtenerTexto(esperaExplicita(locatorTituloErrorAuth));
    }

}
