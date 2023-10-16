package tareas.ejercicios2P.webUI.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tareas.ejercicios2P.webUI.pages.todoist.AppPage;
import tareas.ejercicios2P.webUI.pages.todoist.LoginPage;
import tareas.ejercicios2P.webUI.session.Session;

public class TodoistBaseTest {
    LoginPage loginPage = new LoginPage();
    AppPage appPage = new AppPage();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @Test
    public void login(){
        loginPage.emailInput.setText("eavm2021@gmail.com");
        loginPage.passwordInput.setText("eavm1234");

        loginPage.logInButton.click();

        Assertions.assertTrue(appPage.todayTitle.isControlDisplayed(),
                "ERROR no se pudo iniciar sesion");

    }
}
