package avance.ejerciciosEnClase2P.pages;

import avance.webUITemplate.controls.Button;
import org.openqa.selenium.By;
import tareas.ejercicios2P.webUI.controls.Control;

public class AppPage {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
    public Button profileButton = new Button(By.id(":r0:"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button logoutButton = new Button(By.xpath("//button[span[text()='Log out']]"));

}
