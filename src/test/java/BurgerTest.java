import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Burger burger = new Burger();

    @Mock
    Database database;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;
    @Mock
    Ingredient ingredientThird;

    private final List<Bun> buns = Arrays.asList(new Bun("red bun",300f));

    private final String bunName = "red bun";


    @Before
    public void setAvailableBun() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(database.availableBuns().get(0));
        Assert.assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(424f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(110.5F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        float expectedBurgerPrice = 1134.5f;
        Assert.assertEquals("Некорректная цена бургера с двумя добавленными ингредиентами", expectedBurgerPrice, burger.getPrice(), 0f);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSecond.getName()).thenReturn("sausage");
        Mockito.when(ingredientSecond.getPrice()).thenReturn(300f);
        Mockito.when(ingredientThird.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientThird.getName()).thenReturn("cutlet");
        Mockito.when(ingredientThird.getPrice()).thenReturn(100f);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.moveIngredient(1, 2);
        String expected = "(==== red bun ====)" + "\r\n"
                + "= sauce chili sauce =" + "\r\n"
                +"= filling cutlet ="+ "\r\n"
                +"= filling sausage ="+ "\r\n"
                + "(==== red bun ====)" + "\r\n\r\n"
                + "Price: 1300,000000" + "\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }

}
