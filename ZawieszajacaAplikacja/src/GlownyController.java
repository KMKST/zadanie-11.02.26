import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlownyController {

    private UzytkownikModel model;
    private GlownyView view;

    public GlownyController(UzytkownikModel model, GlownyView view) {
        this.model = model;
        this.view = view;

        initController();
    }

    private void initController() {
        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rozpocznijLogowanie();
            }
        });
    }

    private void rozpocznijLogowanie() {

        String user = view.getUsername();
        String pass = view.getPassword();

        new SwingWorker<Boolean, Void>() {

            @Override
            protected Boolean doInBackground() throws Exception {

                // 🔹 Wątek tła (NIE EDT)
                SwingUtilities.invokeLater(() -> {
                    view.getLoginButton().setEnabled(false);
                    view.setStatus("Trwa weryfikacja danych...");
                });

                return model.walidujLogowanie(user, pass);
            }

            @Override
            protected void done() {

                // 🔹 Wracamy do EDT
                try {
                    boolean wynik = get();

                    view.getLoginButton().setEnabled(true);

                    if (wynik) {
                        view.setStatus("Logowanie pomyślne!");
                    } else {
                        view.setStatus("Błędny login lub hasło!");
                    }

                } catch (Exception e) {
                    view.setStatus("Wystąpił błąd: " + e.getMessage());
                }
            }

        }.execute();
    }
}
