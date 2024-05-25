import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void getCorrectSauceValue() {
        Assert.assertEquals("SAUCE",IngredientType.SAUCE.toString());
    }

    @Test
    public void getCorrectFillingValue() {
        Assert.assertEquals("FILLING",IngredientType.FILLING.toString());
    }
}
