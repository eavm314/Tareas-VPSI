package avance.ejerciciosEnClase2P.pages;

import avance.webUITemplate.controls.Button;
import avance.webUITemplate.controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public Button enterLoginButton = new Button(By.xpath("//a[@href='/auth/login']"));
    public TextBox emailInput = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox passwordInput = new TextBox(By.xpath("//input[@type='password']"));
    public Button logInButton = new Button(By.xpath("//button[@type='submit']"));
}
