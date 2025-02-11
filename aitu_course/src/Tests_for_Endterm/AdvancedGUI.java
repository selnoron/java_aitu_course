package Tests_for_Endterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdvancedGUI extends JFrame {
    private JTextField inputField;
    private JButton submitButton;
    private JTextArea outputArea;
    private JComboBox<String> comboBox;

    public AdvancedGUI() {
        setTitle("Advanced Swing Application");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Input:");
        inputField = new JTextField(15);
        submitButton = new JButton("Submit");

        topPanel.add(inputLabel);
        topPanel.add(inputField);
        topPanel.add(submitButton);

        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        JLabel selectLabel = new JLabel("Select:");
        String[] options = {"Option 1", "Option 2", "Option 3"};
        comboBox = new JComboBox<>(options);

        bottomPanel.add(selectLabel);
        bottomPanel.add(comboBox);

        add(bottomPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                outputArea.append("Input: " + inputText + "\n");
                inputField.setText("");
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                outputArea.append("Selected: " + selectedOption + "\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        AdvancedGUI gui = new AdvancedGUI();
    }
}