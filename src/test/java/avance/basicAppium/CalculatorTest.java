package avance.basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    AppiumDriver phone;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","IphoneX");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");

        phone = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        phone.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp(){
        phone.quit();
    }

    @Test
    public void verifyAddTwoNumber() throws InterruptedException {
        // click  5
        phone.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        // click +
        phone.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
        // click 7
        phone.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();
        // click  =
        phone.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();
         // verification  expectedResult 12 = actualResult 12
        Thread.sleep(5000);
        String expectedResult="12 Calculation result";
        String actualResult= phone.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma esta mal");
    }



}
