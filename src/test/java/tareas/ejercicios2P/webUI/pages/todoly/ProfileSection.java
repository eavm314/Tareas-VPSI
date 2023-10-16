package tareas.ejercicios2P.webUI.pages.todoly;

import org.openqa.selenium.By;
import tareas.ejercicios2P.webUI.controls.Button;
import tareas.ejercicios2P.webUI.controls.Control;
import tareas.ejercicios2P.webUI.controls.TextBox;

public class ProfileSection {
    public Control settingsDialog = new Control(By.id("settingsDialog"));
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//button[span[text()='Ok']]"));
}