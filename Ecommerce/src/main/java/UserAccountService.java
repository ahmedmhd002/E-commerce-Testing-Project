//public class UserAccountService {
//    public boolean login(UserAccount user) {
//        // Implement login logic
//        return true;
//    }
//
//    public void register(UserAccount user) {
//        // Implement registration logic
//    }
//}

import java.util.ArrayList;
import java.util.List;

public class UserAccountService {
    private List<UserAccount> users = new ArrayList<>(); //array of users

    public UserAccountService() {
        // Add a default user for testing
        UserAccount defaultUser = new UserAccount();
        defaultUser.setUsername("ahmed");
        defaultUser.setPassword("1234");
        defaultUser.setBalance(1500.0);
        users.add(defaultUser);
    }

    public boolean login(String username, String password) {
        if(username==null || password==null ){
            return false;
        }
        for (UserAccount user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean register(UserAccount newUser) {
        for (UserAccount user : users) {

            if (newUser.getUsername()==null) {
                return false; // Username empty
            }

            if (user.getUsername().equals(newUser.getUsername())) {
                return false; // Username already exists
            }
        }
        users.add(newUser);
        return true;
    }

    public UserAccount getUser(String username) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

