
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartControllerTest {
    @Test
    public void testAddItemToCart() {
        ShoppingCartService service = new ShoppingCartService();
        ShoppingCartController controller = new ShoppingCartController(service);

        controller.addItemToCart("Laptop - $999.99");
        assertEquals("Laptop - $999.99", controller.getCartItems());
    }

    @Test
    public void testGetCartTotal() {
        ShoppingCartService service = new ShoppingCartService();
        ShoppingCartController controller = new ShoppingCartController(service);

        controller.addItemToCart("Laptop - $999.99");
        controller.addItemToCart("Smartphone - $499.99");
        assertEquals(1499.98, controller.getCartTotal(), 0.01);
    }

    @Test
    public void testRemoveItemFromCart() {
        ShoppingCartService service = new ShoppingCartService();
        ShoppingCartController controller = new ShoppingCartController(service);

        controller.addItemToCart("Laptop - $999.99");
        controller.addItemToCart("Smartphone - $499.99");
        controller.removeItemFromCart("Laptop - $999.99");
        assertEquals("Smartphone - $499.99", controller.getCartItems());
    }



    @Test
    public void testEmptyCart() {
        ShoppingCartService service = new ShoppingCartService();
        ShoppingCartController controller = new ShoppingCartController(service);

        assertEquals("", controller.getCartItems());
        assertEquals(0.0, controller.getCartTotal(), 0.01);
    }




}
