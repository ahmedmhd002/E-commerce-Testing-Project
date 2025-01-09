import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EcommerceApp {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private UserAccountController userController;
    private UserAccount loggedInUser;
    private ShoppingCartController cartController;
    private DefaultListModel<String> productListModel;
    private JList<String> productList;
    private JTextArea cartArea;
    private double cartTotal;
    private JTextArea transactionResultArea;
    private JLabel balanceLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EcommerceApp::new);
    }

    public EcommerceApp() {
        userController = new UserAccountController();
        cartController = new ShoppingCartController(new ShoppingCartService());

        frame = new JFrame("E-commerce System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(createLoginPanel(), "Login");
        cardPanel.add(createRegisterPanel(), "Register");
        cardPanel.add(createDashboardPanel(), "Dashboard");
        cardPanel.add(createProductPanel(), "Product");
        cardPanel.add(createCartPanel(), "Cart");
        cardPanel.add(createTransactionPanel(), "Transaction");
        cardPanel.add(createSellProductPanel(), "SellProduct");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(e -> handleLogin(usernameField.getText(), new String(passwordField.getPassword())));
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty cell
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); // Empty cell
        loginPanel.add(registerButton);

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4, 2, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(e -> handleRegister(usernameField.getText(), new String(passwordField.getPassword())));

        registerPanel.add(usernameLabel);
        registerPanel.add(usernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(new JLabel()); // Empty cell
        registerPanel.add(registerButton);

        return registerPanel;
    }

    private JPanel createDashboardPanel() {
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(3, 1, 10, 10));
        dashboardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton productButton = new JButton("View Products");
        productButton.addActionListener(e -> cardLayout.show(cardPanel, "Product"));

        JButton sellProductButton = new JButton("Sell a Product");
        sellProductButton.addActionListener(e -> cardLayout.show(cardPanel, "SellProduct"));

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));

        dashboardPanel.add(productButton);
        dashboardPanel.add(sellProductButton);
        dashboardPanel.add(logoutButton);

        return dashboardPanel;
    }

    private JPanel createProductPanel() {
        JPanel productPanel = new JPanel();
        Product p=new Product();
        p.setId("1");
        p.setName("Iphone");
        p.setPrice(100);
        productPanel.setLayout(new BorderLayout(10, 10));
        productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        productPanel.add(balanceLabel, BorderLayout.NORTH);

        JLabel title = new JLabel("Product List");
        title.setFont(new Font("Sans Serif", Font.BOLD, 18));
        productPanel.add(title, BorderLayout.NORTH);

        productListModel = new DefaultListModel<>();
        productListModel.addElement("Laptop - $499.99");
        productListModel.addElement("Smartphone - $499.99");
        productListModel.addElement("Headphones - $199.99");

        productList = new JList<>(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(productList);
        productPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> addToCart());
        buttonPanel.add(addToCartButton);

        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(e -> cardLayout.show(cardPanel, "Cart"));
        buttonPanel.add(viewCartButton);

        JButton backToDashboardButton = new JButton("Back to Dashboard");
        backToDashboardButton.addActionListener(e -> cardLayout.show(cardPanel, "Dashboard"));
        buttonPanel.add(backToDashboardButton);

        productPanel.add(buttonPanel, BorderLayout.SOUTH);

        return productPanel;
    }




    private void addProductToTable(DefaultTableModel tableModel, Product product) {
        Object[] rowData = {product.getId(), product.getName(), product.getPrice()};
        tableModel.addRow(rowData);
    }

    private JPanel createCartPanel() {
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout(10, 10));
        cartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        cartPanel.add(balanceLabel, BorderLayout.NORTH);

        JLabel title = new JLabel("Your Cart");
        title.setFont(new Font("Sans Serif", Font.BOLD, 18));
        cartPanel.add(title, BorderLayout.NORTH);

        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(cartArea);
        cartPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton removeButton = new JButton("Remove from Cart");
        removeButton.addActionListener(e -> removeFromCart());
        buttonPanel.add(removeButton);

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.addActionListener(e -> handlePayment());
        buttonPanel.add(confirmButton);

        JButton backToProductButton = new JButton("Back to Products");
        backToProductButton.addActionListener(e -> cardLayout.show(cardPanel, "Product"));
        buttonPanel.add(backToProductButton);

        cartPanel.add(buttonPanel, BorderLayout.SOUTH);

        return cartPanel;
    }

    private JPanel createTransactionPanel() {
        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(new BorderLayout(10, 10));
        transactionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        transactionPanel.add(balanceLabel, BorderLayout.NORTH);

        JLabel title = new JLabel("Transaction Status");
        title.setFont(new Font("Sans Serif", Font.BOLD, 18));
        transactionPanel.add(title, BorderLayout.NORTH);

        transactionResultArea = new JTextArea();
        transactionResultArea.setEditable(false);
        transactionResultArea.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(transactionResultArea);
        transactionPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backToProductButton = new JButton("Back to Products");
        backToProductButton.addActionListener(e -> cardLayout.show(cardPanel, "Product"));
        transactionPanel.add(backToProductButton, BorderLayout.SOUTH);

        return transactionPanel;
    }

    private JPanel createSellProductPanel() {
        JPanel sellProductPanel = new JPanel();
        sellProductPanel.setLayout(new GridLayout(4, 2, 10, 10));
        sellProductPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();
        JButton sellButton = new JButton("Sell Product");
        JButton backButton = new JButton("Back");

        sellButton.addActionListener(e -> handleSellProduct(nameField.getText(), priceField.getText()));
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Dashboard"));

        sellProductPanel.add(nameLabel);
        sellProductPanel.add(nameField);
        sellProductPanel.add(priceLabel);
        sellProductPanel.add(priceField);
        sellProductPanel.add(sellButton);
        sellProductPanel.add(backButton);

        return sellProductPanel;
    }

    private void handleLogin(String username, String password) {
        if (userController.login(username, password)) {
            loggedInUser = userController.getUser(username);
            updateBalanceLabel();
            cardLayout.show(cardPanel, "Dashboard");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
        }
    }

    private void handleRegister(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username cannot be empty.");
            return;
        }
        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Password cannot be empty.");
            return;
        }

        UserAccount newUser = new UserAccount();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setBalance(2000.0);

        if (userController.register(newUser)) {
            JOptionPane.showMessageDialog(frame, "Registration successful. Please login.");
            cardLayout.show(cardPanel, "Login");
        } else {
            JOptionPane.showMessageDialog(frame, "Username already exists. Please choose another.");
        }
    }

    private void addToCart() {
        String selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            cartController.addItemToCart(selectedProduct);
            cartArea.setText(cartController.getCartItems());
        }
    }

    private void removeFromCart() {
        String selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            cartController.removeItemFromCart(selectedProduct);
            cartArea.setText(cartController.getCartItems());
        }
    }

    private void handlePayment() {
        cartTotal = cartController.getCartTotal();
        boolean success = loggedInUser.getBalance() >= cartTotal;

        if (success) {
            loggedInUser.setBalance(loggedInUser.getBalance() - cartTotal);
            updateBalanceLabel();
            transactionResultArea.setText("Payment processed successfully.\nNew balance: " + loggedInUser.getBalance());
        } else {
            transactionResultArea.setText("Payment failed. Check user details and amount.");
        }
        cardLayout.show(cardPanel, "Transaction");
    }

    private void handleSellProduct(String name, String priceText) {
        try {
            double price = Double.parseDouble(priceText);
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Product name cannot be empty.");
            } else if (price <= 0) {
                JOptionPane.showMessageDialog(frame, "Price must be greater than 0.");
            } else {
                productListModel.addElement(name + " - $" + price);
                JOptionPane.showMessageDialog(frame, "Product added successfully.");
                cardLayout.show(cardPanel, "Dashboard");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid price format.");
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + loggedInUser.getBalance());
    }
}
