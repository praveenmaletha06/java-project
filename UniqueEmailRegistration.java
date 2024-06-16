import java.awt.*;
import java.awt.event.*;

public class UniqueEmailRegistration extends Frame {
    private Label lblTitle, lblEmail, lblPassword, lblConfirmPassword;
    private TextField txtEmail;
    private TextField txtPassword;
    private TextField txtConfirmPassword;
    private Button btnRegister;

    public UniqueEmailRegistration() {
        setTitle("Unique Email Registration");
        setSize(1000, 750);
        setLayout(null);
        setBackground(Color.blue);
        // Using null layout for custom positioning

        // Title label
        lblTitle = new Label("Register New Account");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(80, 30, 200, 20);
        add(lblTitle);

        // Email label and text field
        lblEmail = new Label("Email:");
        lblEmail.setBounds(50, 70, 80, 20);
        add(lblEmail);

        txtEmail = new TextField();
        txtEmail.setBounds(140, 70, 150, 20);
        add(txtEmail);

        // Password label and text field
        lblPassword = new Label("Password:");
        lblPassword.setBounds(50, 100, 80, 20);
        add(lblPassword);

        txtPassword = new TextField();
        txtPassword.setEchoChar('*'); // To hide password characters
        txtPassword.setBounds(140, 100, 150, 20);
        add(txtPassword);

        // Confirm Password label and text field
        lblConfirmPassword = new Label("Confirm Password:");
        lblConfirmPassword.setBounds(20, 130, 110, 20);
        add(lblConfirmPassword);

        txtConfirmPassword = new TextField();
        txtConfirmPassword.setEchoChar('*'); // To hide password characters
        txtConfirmPassword.setBounds(140, 130, 150, 20);
        add(txtConfirmPassword);

        // Register button
        btnRegister = new Button("Register");
        btnRegister.setBounds(140, 160, 80, 30);
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        add(btnRegister);

        // Close window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void register() {
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showMessageDialog("Please fill in all fields.");
        } else if (!isValidEmail(email)) {
            showMessageDialog("Invalid email address. Please enter a valid email.");
        } else if (!password.equals(confirmPassword)) {
            showMessageDialog("Passwords do not match. Please re-enter your password.");
        } else {
            showMessageDialog("Registration successful!\nEmail: " + email + "\nPassword: " + password);
            // Here you can add code to save the registration details to a database or file
            // For simplicity, we just display a message
        }
    }

    private boolean isValidEmail(String email) {
        // Very basic email validation
        return email.contains("@") && email.contains(".");
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
        dialog.setSize(250, 100);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        UniqueEmailRegistration registrationForm = new UniqueEmailRegistration();
        registrationForm.setVisible(true);
    }
}