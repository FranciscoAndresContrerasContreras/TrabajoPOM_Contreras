package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class UserPage extends BaseClass {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores
    By locatorTxtUsername = By.id("login-username");

    By locatorTxtPassword = By.id("login-password");

    By locatorBtnIniciarSesion = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]/div[1]");

    By locatorImgUser = By.xpath("//body[1]/div[4]/div[1]/div[2]/div[1]/header[1]/button[2]/figure[1]/div[1]/img[1]");

    //Acciones
   public void imgUser(String username, String password){
        click(esperaExplicita(locatorTxtUsername));
        agregarTexto(locatorTxtUsername,username);
        click(esperaExplicita(locatorTxtPassword));
        agregarTexto(locatorTxtPassword,password);
        if(estaHabilitado(locatorBtnIniciarSesion)) {
            click(esperaExplicita(locatorBtnIniciarSesion));
        }
        estaDesplegado(locatorImgUser);

    }

}

