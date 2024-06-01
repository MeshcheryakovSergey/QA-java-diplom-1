import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    public final IngredientType type;
    public final String name;
    public final float price;

    public static final float ACCURACY = 0.0f;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE,"Соус Spicy-X", 90.0f},
                {SAUCE,"Соус фирменный Space Sauce", 0.1f},
                {SAUCE,null, 99.9f},
                {SAUCE,"Соус с шипами Антарианского плоскоходца", -0},
                {null,"Соус традиционный галактический", 5.5f},
                {FILLING,"Мясо бессмертных моллюсков Protostomia", -1337.0f},
                {FILLING,"Говяжий метеорит (отбивная)", 3.33f},
                {FILLING,null, 4.444f},
                {FILLING,"Биокотлета из марсианской Магнолии", -0},
                {null,"Филе Люминесцентного тетраодонтимформа", 5.5555f}
        };
        }

    @Test
    public void ingredientParamTest (){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), ACCURACY);
        Assert.assertEquals(type, ingredient.getType());
    }
}
