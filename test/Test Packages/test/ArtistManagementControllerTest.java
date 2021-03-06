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

/**
 *
 * @author Matteo Fernández
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtistManagementControllerTest extends ApplicationTest {

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
        verifyThat("#btnDisableArtist", isDisabled());
        verifyThat("#menuItemDisableArtist", isDisabled());
        verifyThat("#btnEnableArtist", isDisabled());
        verifyThat("#menuItemEnableArtist", isDisabled());
        verifyThat("#btnNewArtist", isDisabled());
        verifyThat("#menuItemNewArtist", isDisabled());
        verifyThat("#btnAddArtist", isEnabled());
        verifyThat("#btnSeeEvents", isEnabled());
        verifyThat("#txtFullNameArtist", isFocused());
    }

}
