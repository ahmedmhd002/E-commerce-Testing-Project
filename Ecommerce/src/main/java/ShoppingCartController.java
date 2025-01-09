import java.util.ArrayList;
import java.util.List;

public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final List<String> cartItems;

    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
        this.cartItems = new ArrayList<>();
    }

    public void addItemToCart(String item) {
        cartItems.add(item);
        cartService.addToCart(item);
    }

    public void removeItemFromCart(String item) {
        cartItems.remove(item);
        cartService.removeFromCart(item);
    }

    public String getCartItems() {
        return String.join("\n", cartItems);
    }

    public double getCartTotal() {
        return cartService.calculateTotal();
    }
}
