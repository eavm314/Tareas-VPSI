package tareas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class TodoLyTest {
    private ChromeDriver chrome;
    private WebElement projectItem;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chrome.get("https://todo.ly/");
    }
    @Test
    public void homeWorkorkTest(){
        login();
        createProject();
        updateProject();
    }

    public void createProject(){
        Random rnd = new Random();
        String projectName = "Project "+rnd.nextInt();
        chrome.findElement(By.xpath("//td[text()=\"Add New Project\"]")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(projectName);
        chrome.findElement(By.id("NewProjNameButton")).click();

        Assertions.assertEquals(1, chrome.findElements(By.xpath("//td[text()=\""+projectName+"\"]")).size());
        projectItem = chrome.findElement(By.xpath("//td[text()=\""+projectName+"\"]/.."));
    }

    public void updateProject(){
        projectItem.click();
        chrome.findElement(By.xpath("//div[@class='ProjItemMenu' and contains(@style, 'display: block;')]")).click();
        chrome.findElement(By.id("projectContextMenu")).findElement(By.xpath("//li[@class='edit']")).click();

        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys("Proyecto editado");

        chrome.findElement(By.id("ItemEditSubmit")).click();

        Assertions.assertEquals(1, chrome.findElements(By.xpath("//td[text()='Proyecto editado']")).size());
    }

    public void login(){
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("enriqueadhemar@gmail.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("eavm123");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");
    }
    @AfterEach
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        chrome.quit();
    }
}
