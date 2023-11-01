package tareas.mobileTesting2.activities.drammer;

import org.openqa.selenium.By;
import tareas.mobileTesting2.control.Button;
import tareas.mobileTesting2.control.Label;

public class Top100Screen {
    public Button getElement(String text){
        return new Button(By.xpath("//android.widget.TextView[@text='"+text+"']"));
    }
    public Label getRating(String rating){
        return new Label(By.xpath("//android.widget.TextView[@text='"+rating+"']"));
    }
}
