import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {

    @Test
    public void testUserAccountCreation() {
        UserAccount user = new UserAccount();
        user.setUsername("testuser");
        user.setPassword("password");

        assertEquals("testuser", user.getUsername());
        assertEquals("password", user.getPassword());
    }
}
