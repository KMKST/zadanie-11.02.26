import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZawieszajacaAplikacja {
    private JFrame frame;
    private JButton startButton;
    private JLabel statusLabel;

    public ZawieszajacaAplikacja() {
        frame = new JFrame("Zawieszająca Aplikacja");
        startButton = new JButton("Start");
        statusLabel = new JLabel("Status: Gotowy");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Długotrwała operacja w wątku EDT
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000); // 5 sekund blokady
                        statusLabel.setText("Pracuję... " + (i + 1) + "s");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                statusLabel.setText("Zakończono blokadę.");
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
        new ZawieszajacaAplikacja();
    }
}