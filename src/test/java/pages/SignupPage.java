package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BaseClass;

public class SignupPage extends BaseClass {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores

    //By locatorTittle = By.xpath("//h2[contains(text(),'Regístrate gratis para escuchar.')]");

    By locatorTittleEmail = By.xpath("//label[contains(text(),'¿Cuál es tu correo electrónico?')]");
    By locatorEmail = By.xpath("//input[@id='email']");
    By locatorEmailErroneo = By.xpath("//span[contains(text(),'Este correo electrónico no es válido. Asegúrate de')]");

    By locatorConfirm = By.xpath("//input[@id='confirm']");

    By locatorPassword = By.xpath("//input[@id='password']");

    By locatorDisplayname = By.xpath("//input[@id='displayname']");

    By locatorDay = By.id("day");
    By locatorMonth = By.id("month");
    By locatorYear = By.id("year");

    By locatorGenre = By.xpath("//span[contains(text(),'Hombre')]");

    By locatorNoMarketing = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[6]/div[1]/label[1]/span[1]");
    By locatorCompartirDatos = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[7]/div[1]/label[1]/span[1]");
    By locatorChapta = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[7]/div[1]/label[1]/span[1]");


    By locatorBtnRegistrarte = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[9]/div[1]/button[1]/div[1]");

    //Acciones
    public void Registrarte(String username, String confirm, String password, String displayname, String day, String month, String year){
        click(esperaExplicita(locatorEmail));
        agregarTexto(locatorEmail,username);
        click(esperaExplicita(locatorConfirm));
        agregarTexto(locatorConfirm,confirm);
        click(esperaExplicita(locatorPassword));
        agregarTexto(locatorPassword,password);
        click(esperaExplicita(locatorDisplayname));
        agregarTexto(locatorDisplayname,displayname);
        click(esperaExplicita(locatorDay));
        agregarTexto(locatorDay,day);
        click(esperaExplicita(locatorMonth));
        agregarTexto(locatorMonth,month);
        click(esperaExplicita(locatorYear));
        agregarTexto(locatorYear,year);
        click(esperaExplicita(locatorGenre));
        click(esperaExplicita(locatorNoMarketing));
        esperarXSegundos(3000);
        click(esperaExplicita(locatorCompartirDatos));
        esperarXSegundos(3000);
        //click(esperaExplicita(locatorChapta));
        click(locatorBtnRegistrarte);
        //obtenerTexto(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[8]/div[2]"));

    }

    public void Correo_Erroneo(String email) {
        esperaExplicita(locatorTittleEmail);
        click(By.xpath("//input[@id='email']"));
        esperarXSegundos(5000);
        agregarTexto(locatorEmail, email);
        esperarXSegundos(5000);
        click(By.xpath("//label[contains(text(),'¿Cuál es tu correo electrónico?')]"));
        obtenerTexto(locatorEmailErroneo);

    }

    public void Correo_Correcto(String username) {
        esperaExplicita(locatorTittleEmail);
        click(By.xpath("//input[@id='email']"));
        esperarXSegundos(5000);
        agregarTexto(locatorEmail, username);
        esperarXSegundos(5000);
        click(By.xpath("//label[contains(text(),'¿Cuál es tu correo electrónico?')]"));
        Assert.assertEquals("francisco.contrera@sexternos.bci.cl", "francisco.contrera@sexternos.bci.cl");

    }

    public void Confirmar_Correo_Correcto(String username, String confirm) {
        esperaExplicita(locatorTittleEmail);
        click(locatorEmail);
        esperarXSegundos(3000);
        agregarTexto(locatorEmail, username);
        esperarXSegundos(3000);
        click(By.xpath("//label[contains(text(),'¿Cuál es tu correo electrónico?')]"));
        click(locatorConfirm);
        agregarTexto(locatorConfirm, confirm);
        esperarXSegundos(3000);
        click(By.xpath("//label[contains(text(),'Confirma el correo electrónico')]"));
        Assert.assertEquals(obtenerTexto(locatorEmail),obtenerTexto(locatorConfirm));
    }

    public void Confirmar_Correo_Incorrecto(String username, String confirm) {
        esperaExplicita(locatorTittleEmail);
        click(locatorEmail);
        esperarXSegundos(5000);
        agregarTexto(locatorEmail, username);
        esperarXSegundos(5000);
        click(By.xpath("//label[contains(text(),'¿Cuál es tu correo electrónico?')]"));
        //Assert.assertEquals("francisco.contreras@sexternos.bci.cl", "francisco.contreras@sexternos.bci.cl");
        esperarXSegundos(5000);
        click(locatorConfirm);
        //esperarXSegundos(5000);
        agregarTexto(locatorConfirm, confirm);
        esperarXSegundos(5000);
        click(By.xpath("//label[contains(text(),'Confirma el correo electrónico')]"));
        obtenerTexto(By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/form[1]/div[2]/div[2]"));
    }



    public void finalizartest(){
        cerrarBrowser();
    }

}
