package Tests_for_Assign4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JButton button;
    private JLabel label;

    public GUI() {
        setTitle("Sample app by Swing");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        button = new JButton("Push me!");
        label = new JLabel("Text");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button is clicked!");
            }
        });

        add(button);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}