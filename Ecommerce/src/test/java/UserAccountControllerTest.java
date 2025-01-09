//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class UserAccountControllerTest {
//    private UserAccountController userController;
//
//    @BeforeEach
//    public void setUp() {
//        userController = new UserAccountController();
//    }
//
//    @Test
//    public void testLogin() {
//        assertTrue(userController.login("testuser", "password"));
//        assertFalse(userController.login("testuser", "wrongpassword"));
//        assertFalse(userController.login("unknownuser", "password"));
//    }
//
//    @Test
//    public void testRegister() {
//        UserAccount newUser = new UserAccount();
//        newUser.setUsername("newuser");
//        newUser.setPassword("newpassword");
//        newUser.setBalance(100.0);
//
//        assertTrue(userController.register(newUser));
//        assertFalse(userController.register(newUser)); // Trying to register the same user again should fail
//    }
//}
