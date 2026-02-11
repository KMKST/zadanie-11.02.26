import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NaprawionaAplikacja {
    private JFrame frame;
    private JButton startButton;
    private JLabel statusLabel;

    public NaprawionaAplikacja() {
        frame = new JFrame("Naprawiona Aplikacja");
        startButton = new JButton("Start");
        statusLabel = new JLabel("Status: Gotowy");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Wyłącz przycisk
                statusLabel.setText("Trwa weryfikacja danych...");

                new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000); // Symulacja długotrwałej operacji
                            publish("Pracuję... " + (i + 1) + "s");
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<String> chunks) {
                        String status = chunks.get(chunks.size() - 1);
                        statusLabel.setText(status); // Aktualizacja etykiety statusu
                    }

                    @Override
                    protected void done() {
                        statusLabel.setText("Zakończono pomyślnie!"); // Ustaw końcowy status
                        startButton.setEnabled(true); // Włącz przycisk
                    }
                }.execute(); // Uruchom SwingWorker'a
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(startButton);
        frame.add(statusLabel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NaprawionaAplikacja();
    }
}