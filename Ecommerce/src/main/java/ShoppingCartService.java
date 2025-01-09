//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ShoppingCartService {
//    private final Map<String, Double> productPrices;
//    private final List<String> cartItems;
//
//    public ShoppingCartService() {
//        productPrices = new HashMap<>();
//        productPrices.put("Laptop - $999.99", 999.99);
//        productPrices.put("Smartphone - $499.99", 499.99);
//        productPrices.put("Headphones - $199.99", 199.99);
//        cartItems = new ArrayList<>();
//    }
//
//    public void addToCart(String product) {
//        cartItems.add(product);
//    }
//
//    public void removeFromCart(String product) {
//        cartItems.remove(product);
//    }
//
//    public double calculateTotal() {
//        return cartItems.stream()
//                .mapToDouble(product -> productPrices.getOrDefault(product, 0.0))
//                .sum();
//    }
//}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartService {
    private Map<String, Double> productPrices;
    private List<String> cartItems;

    public ShoppingCartService() {
        productPrices = new HashMap<>();
        productPrices.put("Laptop - $999.99", 999.99);
        productPrices.put("Smartphone - $499.99", 499.99);
        productPrices.put("Headphones - $199.99", 199.99);
        cartItems = new ArrayList<>();
    }

    public void addToCart(String product) {
        cartItems.add(product);
    }

    public void removeFromCart(String product) {
        cartItems.remove(product);
    }

    public double calculateTotal() {
        return cartItems.stream()
                .mapToDouble(product -> productPrices.getOrDefault(product, 0.0))
                .sum();
    }

//    public List<String> getCartItems() {
//        return new ArrayList<>(cartItems);
//    }
}
