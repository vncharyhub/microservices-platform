// UserServiceApplication.java
@SpringBootApplication
@RestController
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return new User(id, "John Doe", "john@example.com");
    }

    record User(String id, String name, String email) {}
}

// application.properties
server.port=8081
spring.application.name=user-service
