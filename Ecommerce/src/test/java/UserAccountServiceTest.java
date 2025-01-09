import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserAccountServiceTest {
    private UserAccountService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserAccountService();

        // Pre-populate with an existing user for login tests
        UserAccount existingUser = new UserAccount();
        existingUser.setUsername("testuser");
        existingUser.setPassword("password");
        existingUser.setBalance(500.0);
        userService.register(existingUser); // Ensure the user is registered before login tests
    }

    @Test
    public void testRegisterUser() {
        UserAccount newUser = new UserAccount();
        newUser.setUsername("newuser");
        newUser.setPassword("newpassword");
        newUser.setBalance(100.0);

        assertTrue(userService.register(newUser)); // Should succeed
        assertFalse(userService.register(newUser)); // Trying to register the same user again should fail
    }

    @Test
    public void testLoginUser() {
        assertTrue(userService.login("testuser", "password")); // Should succeed
//        assertTrue(userService.login("", "password")); // Should fail

        assertFalse(userService.login("testuser", "wrongpassword")); // Wrong password
        assertFalse(userService.login("unknownuser", "password")); // User not registered
    }
}
