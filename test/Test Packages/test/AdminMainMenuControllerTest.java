/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;

/**
 *
 * @author Matteo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminMainMenuControllerTest extends ApplicationTest {

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

    }

    @Test
    public void test1_InitialState() {
        verifyThat("#btnLogOut", isEnabled());
        verifyThat("#btnManageClients", isEnabled());
        verifyThat("#btnManageClubs", isEnabled());
        verifyThat("#btnManageEvents", isEnabled());
        verifyThat("#btnManageArtists", isEnabled());
        verifyThat("#btnManageClients", isFocused());

    }

    @Test
    public void test_LogOut() {
        clickOn("#btnLogOut");
        //acabar, Se vuelve a la ventana de inicio de sesión (logIn).
    }

    @Test
    public void test_ManageClients() {
        clickOn("#btnManageClients");
        //acabar, Se redirige a la ventana de gestión de Clientes
    }

    @Test
    public void test_ManageClubs() {
        clickOn("#btnManageClubs");
        //acabar, Se redirige a la ventana de gestión de Clubes
    }

    @Test
    public void test_ManageArtists() {
        clickOn("#btnManageArtists");
        //acabar, Se redirige a la ventana de gestión de Artistas
    }

    @Test
    public void test_ManageEvents() {
        clickOn("#btnManageEvents");
        //acabar, Se redirige a la ventana de gestión de Eventos
    }
}
