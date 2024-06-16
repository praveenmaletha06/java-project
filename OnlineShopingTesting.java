import java.awt.*;
    import java.awt.event.*;
    
    public class OnlineShopingTesting extends Frame {
       // Components for the shopping interface
        private Label lblWelcome, lblInventory;
        private Button btnLogout, btnViewCart, btnCheckout;
    
        // Login components
        private Label lblEmail, lblPassword;
        private TextField txtEmail, txtPassword;
        private Button btnLogin;
    
        // Inventory
        private Label lblInventoryList;
        private TextArea txtInventoryList;
    
        public OnlineShopingTesting() {
            setTitle("Welcome to Online Shopping");
            setSize(600, 400);
            setLayout(new GridLayout(4, 1));
            setBackground(Color.pink);
    
            // Initialize login components
            lblEmail = new Label("EMAIL ID:");
            lblEmail.setFont(new Font("ARIAL",Font.PLAIN,40));
            lblEmail.setBackground(Color.yellow);
            add(lblEmail);
    
            txtEmail = new TextField();
            add(txtEmail);
    
            lblPassword = new Label("PASSWORD:");
            add(lblPassword);
            lblPassword.setFont(new Font("ARIAL",Font.PLAIN,30));
            lblPassword.setBackground(Color.yellow);
    
            txtPassword = new TextField();
            txtPassword.setEchoChar('*');                               
            // To hide password characters
            add(txtPassword);
    
            btnLogin = new Button("Login");
            add(btnLogin);
            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login();
                }
            });
    
              // Initialize inventory components
            lblInventory = new Label("Inventory:");
            lblInventory.setFont(new Font("ARIAL",Font.PLAIN,30));
            lblInventory.setBackground(Color.RED);
            add(lblInventory);
    
            lblInventoryList = new Label("");
            add(lblInventoryList);
    
            txtInventoryList = new TextArea();
            txtInventoryList.setEditable(false);
            add(txtInventoryList);
    
            // Initialize shopping interface components
            lblWelcome = new Label("Welcome PRAVEEN to Online Shopping!");
            lblWelcome.setFont(new Font("ARIAL",Font.PLAIN,30));
            lblWelcome.setBackground(Color.green);
            add(lblWelcome); 

            btnViewCart = new Button("View Cart");
            btnViewCart.setBackground(Color.red);
            btnViewCart.setFont(new Font("ARIAL",Font.PLAIN,30));
            add(btnViewCart);
            btnViewCart.setEnabled(false);
    
            btnCheckout = new Button("Checkout");
            btnCheckout.setBackground(Color.red);
            btnCheckout.setFont(new Font("ARIAL",Font.PLAIN,30));
            add(btnCheckout);
            btnCheckout.setEnabled(false);
    
            btnLogout = new Button("Logout");
            btnLogout.setBackground(Color.red);
            btnLogout.setFont(new Font("ARIAL",Font.PLAIN,30));
            add(btnLogout);
            btnLogout.setEnabled(false);
    
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
        }
    
        private void login() {
            String email = txtEmail.getText();
            String password = txtPassword.getText();
    
            if (email.equals("Testing@123.com") && password.equals("Testing@1234")) {
              // If login successful, enable shopping buttons and disable login components
                lblWelcome.setText("Welcome to Praveen Maletha Online Shopping!");
                btnViewCart.setEnabled(true);
                btnCheckout.setEnabled(true);
                btnLogout.setEnabled(true);
    
                lblEmail.setVisible(false);
                txtEmail.setVisible(false);
                lblPassword.setVisible(false);
                txtPassword.setVisible(false);
                btnLogin.setVisible(false);
    
                // Display inventory
                displayInventory();
            } else {
              // If login failed, display an error message
                showMessageDialog("Invalid email or password. Please try again.");
            }
        }
    
        private void displayInventory() {
            // Mock inventory data
            String[] inventory = {
                "Laptop ($999.99) - 10 available",
                "Smartphone ($499.99) - 20 available",
                "Headphones ($99.99) - 30 available"
            };
    
             // Display inventory in the text area
            for (String item : inventory) {
                txtInventoryList.append(item + "\n");
            }
        }
    
        private void showMessageDialog(String message) {
            // Display a simple message dialog
            Dialog dialog = new Dialog(this, "Message", true);
            dialog.setLayout(new FlowLayout());
            dialog.add(new Label(message));
            Button okButton = new Button("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            dialog.add(okButton);
            dialog.setSize(200, 100);
            dialog.setVisible(true);
        }
    
        public static void main(String[] args) {
            OnlineShopingTesting onlineShopping = new OnlineShopingTesting();
            onlineShopping.setVisible(true);
        }
    }
    
