import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calc {
    public void layout() {
        JFrame frame = new JFrame();
        JLabel display = new JLabel("0", JLabel.RIGHT);
        display.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        display.setOpaque(true);
        display.setFont(new Font("Arial", Font.PLAIN, 35));
        display.setBackground(new Color(28, 28, 28));
        display.setForeground(Color.WHITE);
        JPanel numberPanel = new JPanel(new GridLayout(5, 3, 4, 4));
        numberPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        String[] buttonLabels = {"%","C", "00","AC","7", "8", "9","-", "4", "5", "6","÷","1", "2", "3","×", "0", ".", "=", "+"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBackground(new Color(80, 80, 80));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            button.setFont(new Font("Arial", Font.BOLD, 22));
            switch (button.getText()) {
                case "AC":
                    button.setBackground(new Color(255, 99, 71, 255));
                    numberPanel.add(button);
                    break;
                case "÷":
                    button.setBackground(new Color(255, 149, 0));
                    button.setForeground(Color.BLACK);
                    break;
                case "×":
                    button.setBackground(new Color(255, 149, 0));
                    button.setForeground(Color.BLACK);
                    break;
                case "-":
                    button.setBackground(new Color(255, 149, 0));
                    button.setForeground(Color.BLACK);
                    break;
                case "+":
                    button.setBackground(new Color(255, 149, 0));
                    button.setForeground(Color.BLACK);
                    break;
                case "":
                    button.setBackground(new Color(212, 212, 210));
                    button.setForeground(Color.BLACK);
                    break;
                case "C":
                    button.setBackground(new Color(212, 212, 210));
                    button.setForeground(Color.BLACK);
                    break;
                case "%":
                    button.setBackground(new Color(212, 212, 210));
                    button.setForeground(Color.BLACK);
                    break;
                case "00":
                    button.setBackground(new Color(212, 212, 210));
                    button.setForeground(Color.BLACK);
                    break;
            }
            numberPanel.add(button);
            numberPanel.setBackground(new Color(28, 28, 28));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.equals("C")) {
                        String currentText = display.getText();
                        if (currentText.length() > 1) {
                            display.setText(currentText.substring(0, currentText.length() - 1));
                        } else {
                            display.setText("0");
                        }
                    } else if (command.equals("AC")) {
                        display.setText("0");
                    } else if ("0123456789.00".contains(command)) {
                        if (display.getText().equals("0")) {
                            display.setText(command);
                        } else {
                            display.setText(display.getText() + command);
                        }
                    } else if ("×+-÷".contains(command)) {
                        display.setText(display.getText() + " " + command + " ");
                    } else if (command.equals("=")) {
                        String[] values = display.getText().split(" ");
                        double result = Double.parseDouble(values[0]);
                        for (int i = 1; i < values.length; i += 2) {
                            String operator = values[i];
                            double op = Double.parseDouble(values[i + 1]);
                            switch (operator) {
                                case "×":
                                    result *= op;
                                    break;
                                case "+":
                                    result += op;
                                    break;
                                case "-":
                                    result -= op;
                                    break;
                                case "÷":
                                    result /= op;
                                    break;
                            }
                        }
                        display.setText(String.valueOf(result));
                    }
                }
            });
        }
        frame.add(display, BorderLayout.PAGE_START);
        frame.add(numberPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calc cal = new Calc();
        cal.layout();
    }
}