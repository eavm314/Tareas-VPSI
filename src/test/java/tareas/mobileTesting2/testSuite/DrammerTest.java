package tareas.mobileTesting2.testSuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tareas.mobileTesting2.activities.drammer.*;
import tareas.mobileTesting2.session.Session;

public class DrammerTest {
    TermsAndConditionsScreen tms = new TermsAndConditionsScreen();
    SearchScreen sc = new SearchScreen();
    SideMenu sm = new SideMenu();
    Top100Screen t100 = new Top100Screen();
    LoginScreen ls = new LoginScreen();

    @BeforeEach
    public void acceptTerms() throws InterruptedException {

        // Coordenadas iniciales y finales del deslizamiento
        int startX = 100; // Coordenada X inicial
        int startY = 1000; // Coordenada Y inicial
        int endX = 100; // Coordenada X final
        int endY = 100; // Coordenada Y final

        // Realiza el deslizamiento
        TouchAction touchAction = new TouchAction(Session.getSession().getDevice());
        Thread.sleep(3000);
        for (int i = 0; i < 10; i++) {
            touchAction.press(PointOption.point(startX,startY)).moveTo(PointOption.point(endX,endY)).release().perform();
//            Thread.sleep(500);
        }

        tms.agreeButton.click();
    }
    @Test
    public void searchTesting(){

        sc.searchBox.setText("Wood");
        sc.searchButton.click();

        Assertions.assertTrue(sc.productLabel.isControlDisplayed(),
                "ERROR no se realizo la busqueda");
    }

    @Test
    public void top100Testing(){

        sm.burgerButton.click();
        sm.top100Button.click();

        t100.getElement("Octomore 7.3/169PPM").click();

        Assertions.assertTrue(t100.getElement("Octomore 7.3/169PPM").isControlDisplayed(),
                "ERROR no se muestra la info del producto");
    }

    @Test
    public void loginTesting(){
        String email = "enriqueadhemar@gmail.com";
        String pwd = "enrique123";

        sm.burgerButton.click();
        sm.loginButton.click();

        ls.emailInput.setText(email);
        ls.pwdInput.setText(pwd);

        ls.login.click();

        Assertions.assertTrue(ls.loginConfirmation(email).isControlDisplayed(),
                "ERROR no se pudo hacer login");
    }


    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }



}
