package avance.ejerciciosEnClase2P.pages;

import avance.webUITemplate.controls.Button;
import avance.webUITemplate.controls.TextBox;
import org.openqa.selenium.By;

public class SettingsPage {
    public Button changePasswordButton = new Button(By.xpath("//a[@href='/app/settings/account/password']"));
    public TextBox currentPasswordInput = new TextBox(By.xpath("//span[text()='Current password']/../../../div/input"));
    public TextBox newPasswordInput = new TextBox(By.xpath("//span[text()='New password']/../../../div/input"));
    public TextBox newPasswordConfirmInput = new TextBox(By.xpath("//span[text()='Confirm new password']/../../../div/input"));
    public Button confirmChangePasswordButton = new Button(By.xpath("//button[@type='submit' and span[text()='Change password']]"));
    public Button closeSettingsButton = new Button(By.xpath("//button[@aria-label='Close settings']"));
}
