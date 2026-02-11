import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame {

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;

    public GlownyView() {
        setTitle("System Logowania");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        userField = new JTextField(15);
        passField = new JPasswordField(15);
        loginButton = new JButton("Zaloguj");
        statusLabel = new JLabel(" ");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("Użytkownik:"));
        panel.add(userField);
        panel.add(new JLabel("Hasło:"));
        panel.add(passField);
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(new JLabel("Status:"));
        panel.add(statusLabel);

        add(panel);
    }

    // Gettery potrzebne Controllerowi
    public String getUsername() {
        return userField.getText();
    }

    public String getPassword() {
        return new String(passField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
