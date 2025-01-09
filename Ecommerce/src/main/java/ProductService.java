import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProductById(String id) {
        Optional<Product> product = products.stream().filter(p -> p.getId().equals(id)).findFirst();   //Java Streams to filter the list of products
        return product.orElse(null);
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(updatedProduct.getId())) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }
}
