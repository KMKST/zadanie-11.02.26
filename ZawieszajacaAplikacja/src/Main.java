import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            UzytkownikModel model = new UzytkownikModel();
            GlownyView view = new GlownyView();
            new GlownyController(model, view);

            view.setVisible(true);
        });
    }
}
