package problems.task16;

import javax.swing.*;
import java.awt.*;

public class BallWindow extends JFrame {
    JPanel panel = new JPanel();
    JButton btn = new JButton("Add point");

    public BallWindow() {
        setBounds(100, 200, 600, 600);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        btn.setBounds(200, 10, 160, 20);
        contentPane.add(btn);
        panel.setBounds(30, 40, 520, 500);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        btn.addActionListener(e -> {
            new BallThread(panel).start();
            repaint();
        });
    }
}
