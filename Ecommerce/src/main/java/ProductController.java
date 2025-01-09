import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();

    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void deleteProduct(Product product) {
        productService.removeProduct(product);
    }

    public Product getProductById(String id) {
        return productService.getProductById(id);
    }

    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }
}
