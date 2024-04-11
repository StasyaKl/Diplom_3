package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.assertNotEquals;

public class TransitionsToSectionsTest extends BaseTest {
    private String expectedSectionClass;
    private String actualSectionClass;
    private final int sauce = 1;

    @Test
    @DisplayName("Метод перехода к разделу «Булки»")
    @Description("Метод сравнивает классы секции до и после нажатия")
    public void checkTransitionToBunSection(){
        int bun = 0;
        expectedSectionClass = new ConstructorPage(driver)
                .clickOnSection(sauce)
                .getSectionClass(bun);

        actualSectionClass = new ConstructorPage(driver)
                .clickOnSection(bun)
                .getSectionClass(bun);

        assertNotEquals("Раздел «Булки» не выбран",
                expectedSectionClass,
                actualSectionClass
        );
    }

    @Test
    @DisplayName("Метод перехода к разделу «Соусы»")
    @Description("Метод сравнивает классы секции до и после нажатия")
    public void checkTransitionToSauceSection(){
        expectedSectionClass = new ConstructorPage(driver).
                getSectionClass(sauce);

        actualSectionClass = new ConstructorPage(driver)
                .clickOnSection(sauce)
                .getSectionClass(sauce);

        assertNotEquals("Раздел «Соусы» не выбран",
                expectedSectionClass,
                actualSectionClass
        );
    }

    @Test
    @DisplayName("Метод перехода к разделу «Начинки»")
    @Description("Метод сравнивает классы секции до и после нажатия")
    public void checkTransitionToFillingSection(){
        int filling = 2;
        expectedSectionClass = new ConstructorPage(driver)
                .getSectionClass(filling);

        actualSectionClass = new ConstructorPage(driver)
                .clickOnSection(filling)
                .getSectionClass(filling);

        assertNotEquals("Раздел «Начинки» не выбран",
                expectedSectionClass,
                actualSectionClass
        );
    }
}
