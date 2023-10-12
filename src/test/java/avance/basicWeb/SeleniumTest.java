package avance.basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class SeleniumTest {
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
    public void verifySomething() throws InterruptedException {
        login();
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
