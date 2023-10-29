package avance.ejerciciosEnClase2P;

import avance.ejerciciosEnClase2P.config.ConfigTodoist;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest extends TodoistBaseTest{
    @Test
    public void changePassword() throws InterruptedException {
        login();
        openSettings();
        setNewPassword();
        logout();
        loginPage.enterLoginButton.click();
        login();
    }

    private void openSettings() {
        appPage.profileButton.click();
        appPage.settingsButton.click();

        settingsPage.changePasswordButton.click();

        Assertions.assertTrue(settingsPage.confirmChangePasswordButton.isControlDisplayed(),
                "Error no se pudo ingresar a la configuracion de contraseña");
    }

    private void setNewPassword() throws InterruptedException {
        String newPassword = "eavm1234";
        settingsPage.currentPasswordInput.setText(ConfigTodoist.password);

        ConfigTodoist.password = newPassword;

        settingsPage.newPasswordInput.setText(newPassword);
        settingsPage.newPasswordConfirmInput.setText(newPassword);

        settingsPage.confirmChangePasswordButton.click();

        Thread.sleep(2000);
        settingsPage.closeSettingsButton.click();

        Assertions.assertTrue(appPage.profileButton.isControlDisplayed(),
                "Error no se pudo cerrar el dialogo de configuracion");
    }
}
