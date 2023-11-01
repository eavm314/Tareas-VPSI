package tareas.mobileTesting2.activities.drammer;

import org.openqa.selenium.By;
import tareas.mobileTesting2.control.Button;
import tareas.mobileTesting2.control.Label;
import tareas.mobileTesting2.control.TextBox;

public class SearchScreen {
    public TextBox searchBox = new TextBox(By.xpath("//android.widget.EditText"));
    public Button searchButton = new Button(By.xpath("//android.widget.Button[@text=\"SEARCH\"]"));
    public Label productLabel = new Label(By.xpath("//android.widget.TextView[@text=\"Sherwood's 11 year old 2007/2017 Orkney Islands cask 0036/2007\"]"));
}
