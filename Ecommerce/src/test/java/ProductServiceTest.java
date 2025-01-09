import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productService.addProduct(product);
        assertEquals(1, productService.getAllProducts().size());
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productService.addProduct(product);
        productService.removeProduct(product);
        assertEquals(0, productService.getAllProducts().size());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productService.addProduct(product);
        Product retrievedProduct = productService.getProductById("1");
        assertNotNull(retrievedProduct);
        assertEquals("Test Product", retrievedProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productService.addProduct(product);

        Product updatedProduct = new Product();
        updatedProduct.setId("1");
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(200.0);
        updatedProduct.setQuantity(20);

        productService.updateProduct(updatedProduct);

        Product retrievedProduct = productService.getProductById("1");
        assertNotNull(retrievedProduct);
        assertEquals("Updated Product", retrievedProduct.getName());
        assertEquals(200.0, retrievedProduct.getPrice());
        assertEquals(20, retrievedProduct.getQuantity());
    }

    @Test
    public void testAddDuplicateProduct() {
        Product product1 = new Product();
        product1.setId("1");
        product1.setName("Test Product 1");
        product1.setPrice(100.0);
        product1.setQuantity(10);

        Product product2 = new Product();
        product2.setId("1");
        product2.setName("Test Product 2");
        product2.setPrice(200.0);
        product2.setQuantity(20);

        productService.addProduct(product1);
        productService.addProduct(product2);

        List<Product> products = productService.getAllProducts();
        assertEquals(2, products.size());
    }

    @Test
    public void testRemoveNonExistentProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productService.removeProduct(product);
        assertEquals(0, productService.getAllProducts().size());
    }
}
