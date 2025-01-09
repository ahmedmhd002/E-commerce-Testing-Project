import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product();
        product.setPrice(100.0);

        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
        assertEquals(100.0, cart.getTotalPrice());
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product();
        product.setPrice(100.0);

        cart.addProduct(product);
        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
        assertEquals(0.0, cart.getTotalPrice());
    }
}

