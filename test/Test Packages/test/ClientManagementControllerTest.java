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
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author Matteo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientManagementControllerTest extends ApplicationTest {

    /**
     * Starts application to be tested.
     *
     * @param stage Primary Stage object
     * @throws Exception if we have any error
     */
    @Override
    public void start(Stage stage) throws Exception {

    }

    @Test
    public void test1_InitialState() {
        verifyThat("#btnBack", isEnabled());
        verifyThat("#btnNewClient", isEnabled());
        verifyThat("#btnSeeEvents", isDisabled());
        verifyThat("#menuItemNewClient", isEnabled());
        verifyThat("#menuItemSeeEvents", isDisabled());
        verifyThat("#btnNewClient", isFocused());
    }

}
