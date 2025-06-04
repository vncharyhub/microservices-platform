// ProductServiceApplication.java
@SpringBootApplication
@RestController
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return new Product(id, "Laptop", 999.99);
    }

    record Product(String id, String name, double price) {}
}

// application.properties
server.port=8082
spring.application.name=product-service
