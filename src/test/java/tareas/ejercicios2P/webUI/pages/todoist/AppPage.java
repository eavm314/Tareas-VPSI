package tareas.ejercicios2P.webUI.pages.todoist;

import org.openqa.selenium.By;
import tareas.ejercicios2P.webUI.controls.Control;

public class AppPage {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
}
