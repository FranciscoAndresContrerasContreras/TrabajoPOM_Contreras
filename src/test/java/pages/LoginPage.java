package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores
    By locatorTxtUsername = By.id("login-username");

    By locatorTxtPassword = By.id("login-password");

    By locatorTxtErroneo = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]");

    By locatorBtnIniciarSesion = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]/div[1]");

    //Acciones
    public void loginfallido(String username, String password){
        click(esperaExplicita(locatorTxtUsername));
        agregarTexto(locatorTxtUsername,username);
        click(esperaExplicita(locatorTxtPassword));
        agregarTexto(locatorTxtPassword,password);
        if(estaHabilitado(locatorBtnIniciarSesion)) {
            click(esperaExplicita(locatorBtnIniciarSesion));
        }
    }

    public void correoerroneo(String username){
        click(esperaExplicita(locatorTxtUsername));
        esperarXSegundos(2000);
        agregarTexto(locatorTxtUsername, username);
        esperarXSegundos(2000);
        obtenerTexto(locatorTxtErroneo);
    }

    /*public void logincorrecto(){
        click(esperaExplicita(locatorTxtUsername));
        agregarTexto(locatorTxtUsername,"akmeteam@gmail.com");
        click(esperaExplicita(locatorTxtPassword));
        agregarTexto(locatorTxtPassword,"franciscoandres");
        if(estaHabilitado(locatorBtnIniciarSesion)) {
            click(esperaExplicita(locatorBtnIniciarSesion));
        }
    }*/

    public void finalizartest(){
        cerrarBrowser();
    }
}
