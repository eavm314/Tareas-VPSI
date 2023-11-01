package tareas.mobileTesting2.activities.drammer;

import org.openqa.selenium.By;
import tareas.mobileTesting2.control.Button;
import tareas.mobileTesting2.control.Label;
import tareas.mobileTesting2.control.TextBox;

public class LoginScreen {
    public TextBox emailInput = new TextBox(By.xpath("//android.widget.TextView[@text=\"Email address\"]/../../android.view.View/android.widget.EditText"));
    public TextBox pwdInput = new TextBox(By.xpath("//android.widget.TextView[@text=\"Password\"]/../../android.view.View/android.widget.EditText"));
    public Button login = new Button(By.xpath("//android.widget.Button[@text=\"LOGIN\"]"));
    public Label loginConfirmation(String email){
        return new Label(By.xpath("//android.widget.TextView[@text=\"Hi "+email+", great you're using the Drammer app!\"]"));
    }
}
