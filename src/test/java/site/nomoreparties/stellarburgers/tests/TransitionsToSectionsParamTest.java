package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class TransitionsToSectionsParamTest extends BaseTest {
    private final int unActiveExpectedSection;
    private final int activeExpectedSection;
    private static final int sauce = 1;
    private static final int bun = 0;
    private static final int filling = 1;

    public TransitionsToSectionsParamTest(int activeExpectedSection, int unActiveExpectedSection) {
        this.activeExpectedSection = activeExpectedSection;
        this.unActiveExpectedSection = unActiveExpectedSection;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {bun, sauce},
                {sauce, bun},
                {filling, bun},
        };
    }

    @Before
    public void registerUser() {
        registerUserWithAPI();
    }

    @Test
    @DisplayName("Метод перехода к разделу")
    @Description("Метод сравнивает классы секции до и после нажатия")
    public void checkTransitionToBunSection(){
        String expectedSectionClass;
        if (unActiveExpectedSection == bun) {
            expectedSectionClass = new ConstructorPage(driver)
                    .getSectionClass(activeExpectedSection);
        } else {
            expectedSectionClass = new ConstructorPage(driver)
                    .clickOnSection(unActiveExpectedSection)
                    .getSectionClass(activeExpectedSection);
        }

        String actualSectionClass = new ConstructorPage(driver)
                .clickOnSection(activeExpectedSection)
                .getSectionClass(activeExpectedSection);

        assertNotEquals("Переход к разделу не сработал",
                expectedSectionClass,
                actualSectionClass
        );
    }
}