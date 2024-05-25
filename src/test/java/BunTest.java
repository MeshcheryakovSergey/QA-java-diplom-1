import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {


    @Test
    public void getNameTest() {
        Bun bun = new Bun("Булка", 1.1f);
        Assert.assertEquals("Булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Булка", 1.1f);
        Assert.assertEquals(1.1f, bun.getPrice(),  0.0f);
    }

}
