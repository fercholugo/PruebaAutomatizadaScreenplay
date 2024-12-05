package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_FIELD = Target.the("input nombre usuario")
            .located(By.xpath("//input[@name='username']"));

    public static final Target PASSWORD_FIELD = Target.the("input contraseña")
            .located(By.xpath("//input[@class='oxd-input oxd-input--active' and @type='password' and @name='password']"));

    public static final Target LOGIN_BUTTON = Target.the("boton login")
            .located(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button') and contains(@class, 'orangehrm-login-button')]"));

    //elemento para question para credenciales validas
    public static final Target DASHBOARD_HEADER = Target.the("header dashboard")
            .located(By.xpath("//h6[contains(@class, 'oxd-text') and contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Dashboard']"));

    //elemento para question mensaje "Invalid credentials"
    public static final Target ERROR_MESSAGE_INVALID_CREDENTIALS = Target.the("mensaje de error de credenciales invalidas")
            .located(By.xpath("//p[contains(@class, 'oxd-text') and contains(@class, 'oxd-alert-content-text') and text()='Invalid credentials']"));



}
