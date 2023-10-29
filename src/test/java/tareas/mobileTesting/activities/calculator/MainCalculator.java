package tareas.mobileTesting.activities.calculator;

import org.openqa.selenium.By;
import tareas.mobileTesting.control.Button;
import tareas.mobileTesting.control.Label;

public class MainCalculator {
    public Button fiveButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='5']"));
    public Button sevenButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='7']"));
    public Button addButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='plus']"));
    public Button equalButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='equals']"));

    public Label resultLabel = new Label(By.id("result_final"));

}
