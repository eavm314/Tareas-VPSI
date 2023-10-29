package avance.ejerciciosEnClase2P;

import avance.ejerciciosEnClase2P.config.ConfigTodoist;
import avance.ejerciciosEnClase2P.pages.AppPage;
import avance.ejerciciosEnClase2P.pages.LoginPage;
import avance.ejerciciosEnClase2P.pages.SettingsPage;
import avance.webUITemplate.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TodoistBaseTest {
    LoginPage loginPage = new LoginPage();
    AppPage appPage = new AppPage();
    SettingsPage settingsPage = new SettingsPage();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    public void login(){
        loginPage.emailInput.setText(ConfigTodoist.email);
        loginPage.passwordInput.setText(ConfigTodoist.password);

        loginPage.logInButton.click();

        Assertions.assertTrue(appPage.profileButton.isControlDisplayed(),
                "ERROR no se pudo iniciar sesion");
    }

    public void logout(){
        appPage.profileButton.click();
        appPage.logoutButton.click();

        Assertions.assertTrue(loginPage.enterLoginButton.isControlDisplayed(),
                "ERROR no se pudo cerrar sesion");
    }
}
