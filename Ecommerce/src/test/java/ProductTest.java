import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testSetId() {
        Product product = new Product();
        product.setId("1");
        assertEquals("1", product.getId());
    }

    @Test
    public void testSetName() {
        Product product = new Product();
        product.setName("Laptop");
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testSetPrice() {
        Product product = new Product();
        product.setPrice(999.99);
        assertEquals(999.99, product.getPrice());
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product();
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testGetId() {
        Product product = new Product();
        product.setId("1");
        assertEquals("1", product.getId());
    }

    @Test
    public void testGetName() {
        Product product = new Product();
        product.setName("Laptop");
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testGetPrice() {
        Product product = new Product();
        product.setPrice(999.99);
        assertEquals(999.99, product.getPrice());
    }

    @Test
    public void testGetQuantity() {
        Product product = new Product();
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }
}
