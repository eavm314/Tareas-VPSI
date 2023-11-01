package tareas.mobileTesting2.activities.drammer;

import org.openqa.selenium.By;
import tareas.mobileTesting2.control.Button;
import tareas.mobileTesting2.control.Label;

public class SideMenu {
    public Button burgerButton = new Button(By.xpath("//android.widget.Button[@text=\"menu\"]"));
    public Button loginButton = new Button(By.xpath("//android.view.View[@content-desc=\"Login\"]"));
    public Button top100Button = new Button(By.xpath("//android.view.View[@content-desc=\"Top 100\"]"));

}
