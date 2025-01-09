//public class TransactionHandler {
//    public boolean processPayment(UserAccount user, double amount) {
//        if (user == null || amount <= 0) {
//            return false;
//        }
//
//        // Simulate checking for sufficient balance
//        if (user.getBalance() < amount) {
//            return false;
//        }
//
//        // Deduct the amount from the user's balance
//        user.setBalance(user.getBalance() - amount);
//
//        // Record the transaction (this could be to a database or a log, simplified here)
//        System.out.println("Processed payment of " + amount + " for user " + user.getUsername());
//
//        return true;
//    }
//
//    public boolean validateTransaction(UserAccount user, double amount) {
//        if (user == null || amount <= 0) {
//            return false;
//        }
//
//        // Validate that the user has sufficient funds
//        if (user.getBalance() < amount) {
//            return false;
//        }
//
//        return true;
//    }
//}


public class TransactionHandler {
    public boolean processPayment(UserAccount user, double amount) {
        if (validateTransaction(user, amount)) {
            user.setBalance(user.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean validateTransaction(UserAccount user, double amount) {
        if (user == null || amount <= 0 || user.getBalance() < amount) {
            return false;
        }
        return true;
    }
}

