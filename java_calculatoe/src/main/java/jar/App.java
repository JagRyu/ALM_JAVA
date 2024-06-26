package jar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class App {
    private JFrame frame;
    private JTextField textField;
    private double firstNumber;
    private double secondNumber;
    private String operator;
    public App() {
        frame = new JFrame("계산기 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
        };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "=":
                    secondNumber = Double.parseDouble(textField.getText());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            result = firstNumber / secondNumber;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = command;
                    textField.setText("");
                    break;
                default:
                    textField.setText(textField.getText() + command);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());;
        
    }
}