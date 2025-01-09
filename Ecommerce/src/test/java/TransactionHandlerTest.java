import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionHandlerTest {

    @Test
    public void testProcessPayment_TC1() {
        UserAccount user = null;
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.processPayment(user, 200.0));
    }

    @Test
    public void testProcessPayment_TC2() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.processPayment(user, 0.0));
    }

    @Test
    public void testProcessPayment_TC3() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.processPayment(user, -50.0));
    }

    @Test
    public void testProcessPayment_TC4() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.processPayment(user, 600.0));
    }

    @Test
    public void testProcessPayment_TC5() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertTrue(handler.processPayment(user, 500.0));
        assertEquals(0.0, user.getBalance(), 0.01);
    }

    @Test
    public void testProcessPayment_TC6() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertTrue(handler.processPayment(user, 200.0));
        assertEquals(300.0, user.getBalance(), 0.01);
    }

    @Test
    public void testValidateTransaction_TC1() {
        UserAccount user = null;
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.validateTransaction(user, 200.0));
    }

    @Test
    public void testValidateTransaction_TC2() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.validateTransaction(user, 0.0));
    }

    @Test
    public void testValidateTransaction_TC3() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.validateTransaction(user, -50.0));
    }

    @Test
    public void testValidateTransaction_TC4() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertFalse(handler.validateTransaction(user, 600.0));
    }

    @Test
    public void testValidateTransaction_TC5() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertTrue(handler.validateTransaction(user, 500.0));
    }

    @Test
    public void testValidateTransaction_TC6() {
        UserAccount user = new UserAccount();
        user.setBalance(500.0);
        TransactionHandler handler = new TransactionHandler();

        assertTrue(handler.validateTransaction(user, 200.0));
    }
}
