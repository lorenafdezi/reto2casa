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
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author Matteo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClubProfileControllerTest extends ApplicationTest {

    private static final String OVERSIZED_TEXT = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
            + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

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
        verifyThat("#btnSaveChanges", isDisabled());
        verifyThat("#btnBack", isEnabled());
        verifyThat("#btnBack", isFocused());
        verifyThat("#btnEditProfile", isEnabled());
    }

    @Test
    public void test_SaveChangesEnabled() {
        clickOn("#btnEditProfile");
        verifyThat("#btnSaveChanges", isEnabled());
    }

    @Test
    public void test_SaveChangesDisables() {
        clickOn("#btnSaveChanges");
        verifyThat("#btnSaveChanges", isDisabled());
    }

    @Test
    public void test_NameClubs() {
        clickOn("#txtName");
        write("Club artesano");
        verifyThat("#btnSaveChanges", isEnabled());
        verifyThat("#btnBack", isEnabled());
    }

    @Test
    public void test_NameClubIsCorrect() {
        clickOn("#txtName");
        write("Club artesano");
        verifyThat("#btnSaveChanges", isEnabled());
        verifyThat("#btnBack", isEnabled());
    }

    /**
     * Test the Club length is less than 255.
     */
    @Test
    public void test2_TxtClubMaximumLength() {
        doubleClickOn("#txtName");
        write(OVERSIZED_TEXT);
        verifyThat("#btnSaveChanges", isDisabled());
        verifyThat("* Must be less than 255 characters", isVisible());
    }

}
