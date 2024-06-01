import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    public static final float ACCURACY = 0.0f;

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Булка", 1.1f);
        Assert.assertEquals("Булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Булка", 1.1f);
        Assert.assertEquals(1.1f, bun.getPrice(),  ACCURACY);
    }

}
