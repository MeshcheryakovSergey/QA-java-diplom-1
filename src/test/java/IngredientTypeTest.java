import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String typeName;

    public IngredientTypeTest(String typeName) {
        this.typeName = typeName;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void IngredientTypeParamTest() {
        Assert.assertEquals(IngredientType.valueOf(typeName.toUpperCase()).toString(),
                typeName);
    }
}