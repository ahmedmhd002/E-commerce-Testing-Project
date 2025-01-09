import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        productController = new ProductController();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productController.addProduct(product);
        assertEquals(1, productController.getProducts().size());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productController.addProduct(product);
        productController.deleteProduct(product);
        assertEquals(0, productController.getProducts().size());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productController.addProduct(product);
        Product retrievedProduct = productController.getProductById("1");
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

        productController.addProduct(product);

        Product updatedProduct = new Product();
        updatedProduct.setId("1");
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(200.0);
        updatedProduct.setQuantity(20);

        productController.updateProduct(updatedProduct);

        Product retrievedProduct = productController.getProductById("1");
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

        productController.addProduct(product1);
        productController.addProduct(product2);

        List<Product> products = productController.getProducts();
        assertEquals(2, products.size());
    }

    @Test
    public void testDeleteNonExistentProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);

        productController.deleteProduct(product);
        assertEquals(0, productController.getProducts().size());
    }
}
