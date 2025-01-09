//public class UserAccountController {
//    public UserAccountService userService = new UserAccountService();
//
//    public boolean login(UserAccount user) {
//        return userService.login(user);
//    }
//
//    public void register(UserAccount user) {
//        userService.register(user);
//    }
//}


public class UserAccountController {
    private UserAccountService userService = new UserAccountService();

    public boolean login(String username, String password) {
        if (username==null || password==null) {
            return false; // Username empty
        }

        return userService.login(username, password);
    }

    public boolean register(UserAccount newUser) {
        if (newUser.getUsername()==null) {
            return false; // Username empty
        }
        return userService.register(newUser);
    }

    public UserAccount getUser(String username) {
        return userService.getUser(username);
    }
}

