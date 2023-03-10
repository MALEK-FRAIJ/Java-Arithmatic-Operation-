package com.calculator;

import java.awt.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.Border;

public class OperationsFrame extends JFrame implements ActionListener {

    private JFrame window;
    // private Stack<Double> digitNumber;

    private JTextField[] fieldsInput;
    private JTextField numOneField, numTwoField, resultTextField;

    private JPanel[] panelArray;
    private JPanel buttonsPanel, fieldPanel, drawPanel, mainPanel, titlePanel;

    private JButton[] functionButtons;
    private JButton addButton, subButton, equButton, showOperationButton, clrButton, closeBtn;

    private JLabel[] labelArray;
    private JLabel title, titleAppLabel, resultLabel, operationsLabel, subOrAddLabel,
            numOneLabel, numTwoLabel, displayLabelOne;

    private static JLabel displayLabelTwo;

    private JLabel titleAppLabel2;

    private static JLabel resultLabel2;

    private JLabel titleResult;

    private Font textFont = new Font("Ink Free"  , Font.BOLD, 24);
    private Border border = BorderFactory.createLoweredSoftBevelBorder();

    private long number1 = 0, number2 = 0, result = 0;
    private char operator = '!';

    private String input1, s1, input2, s2;
    private static ArrayList<Integer> firstNumber;
    private static ArrayList<Integer> secondNumber;

    private static int var = 0;
    private boolean flag = false;

    private static int[] result1Number;
    private int n1, n2;

    public OperationsFrame() {

        window = new JFrame("Arithmetic Operators");
        new GuiManager();

        createPanels();
        createLabel();
        createButtons();
        createTextField();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(
                new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setIconImage(new ImageIcon("D:\\calculator.png").getImage());

        window.setSize(1000, 600);
        window.setLocation(170, 30);

        window.add(titlePanel);
        window.add(mainPanel);

        window.setVisible(true);
    }

    private void createPanels() {
        panelArray = new JPanel[5];

        titlePanel = new JPanel();
        mainPanel = new JPanel();

        buttonsPanel = new JPanel();
        fieldPanel = new JPanel();
        drawPanel = new JPanel();

        panelArray[0] = titlePanel;
        panelArray[1] = mainPanel;
        panelArray[2] = buttonsPanel;
        panelArray[3] = fieldPanel;
        panelArray[4] = drawPanel;

        for (JPanel iterable_paPanel : panelArray) {
            iterable_paPanel.setBackground(Color.DARK_GRAY);

        }

        buttonsPanel.setLayout(new GridLayout(7, 1, 50, 10));
        fieldPanel.setLayout(new GridLayout(8, 1, 50, 10));
        drawPanel.setLayout(new GridLayout(8, 1, 50, 10));
        drawPanel.setBorder(border);

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 0));

        mainPanel.add(drawPanel);
        mainPanel.add(fieldPanel);
        mainPanel.add(buttonsPanel);

    }

    private void createButtons() {
        functionButtons = new JButton[6];

        addButton = new JButton("+");
        subButton = new JButton("-");
        equButton = new JButton("=");
        clrButton = new JButton("Clear");
        showOperationButton = new JButton("Display");
        closeBtn = new JButton("Close");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = equButton;
        functionButtons[3] = clrButton;
        functionButtons[4] = showOperationButton;
        functionButtons[5] = closeBtn;

        for (JButton jButton : functionButtons) {

            jButton.addActionListener(this);
            jButton.setFont(textFont);
            jButton.setFocusable(false);
            jButton.setBackground(Color.BLACK);
            jButton.setForeground(new Color(0xffffff));
            buttonsPanel.add(jButton);

        }

    }

    private void createLabel() {
        labelArray = new JLabel[12];
        title = new JLabel("Arithmetic Operators App");

        titleAppLabel = new JLabel(" Enter Two Number ");
        resultLabel = new JLabel();
        operationsLabel = new JLabel(" Operations ");
        subOrAddLabel = new JLabel("RESULT");

        titleAppLabel2 = new JLabel(" Show Steps ");

        displayLabelOne = new JLabel();
        displayLabelTwo = new JLabel();

        numOneLabel = new JLabel();
        numTwoLabel = new JLabel();
        titleResult = new JLabel(" ------------------------------ ");
        resultLabel2 = new JLabel();

        labelArray[0] = title;
        labelArray[1] = titleAppLabel;
        labelArray[2] = resultLabel;
        labelArray[3] = operationsLabel;
        labelArray[4] = subOrAddLabel;
        labelArray[5] = titleAppLabel2;
        labelArray[6] = displayLabelOne;
        labelArray[7] = displayLabelTwo;
        labelArray[8] = numOneLabel;
        labelArray[9] = numTwoLabel;
        labelArray[10] = titleResult;
        labelArray[11] = resultLabel2;

        for (JLabel iterable_Label : labelArray) {
            iterable_Label.setFont(textFont);
            iterable_Label.setForeground(Color.WHITE);
            iterable_Label.setBackground(Color.DARK_GRAY);
            iterable_Label.setHorizontalAlignment(JLabel.CENTER);
        }

        title.setFont(new Font("Ink Free",Font.BOLD,60));;

        fieldPanel.add(titleAppLabel);
        buttonsPanel.add(operationsLabel);
        titlePanel.add(title);

        for (int i = 0; i < labelArray.length; i++) {

            if (i >= 5) {
                // labelArray[i].setHorizontalAlignment(JLabel.LEFT);
                // labelArray[i].setBorder(border);
                drawPanel.add(labelArray[i]);
            }
         
        
        }
       
        
    }

    private void createTextField() {
        fieldsInput = new JTextField[3];

        numOneField = new JTextField(15);
        numTwoField = new JTextField(15);
        resultTextField = new JTextField(15);

        fieldsInput[0] = numOneField;
        fieldsInput[1] = numTwoField;
        fieldsInput[2] = resultTextField;

        for (JTextField jTextField : fieldsInput) {

            jTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
            jTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            jTextField.setBorder(border);
            jTextField.setBackground(Color.DARK_GRAY);
            jTextField.setForeground(Color.WHITE);
            jTextField.setHorizontalAlignment(JTextField.CENTER);

            if (jTextField == resultTextField) {
                fieldPanel.add(subOrAddLabel);

            }
            fieldPanel.add(jTextField);

        }

        resultTextField.setEditable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            try {
                number1 = Long.parseLong(numOneField.getText());
                operator = '+';
                subOrAddLabel.setText("Addition result");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "plz,Enter the number ...\n" + ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == subButton) {
            try {
                number1 = Long.parseLong(numOneField.getText());
                operator = '-';

                subOrAddLabel.setText("Subtraction result");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "plz,Enter the number ...\n" + ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == equButton) {

            flag =true;
            if (operator == '!') {
                JOptionPane.showMessageDialog(null, "plz,Enter the operation ...\n", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

            try {
                number2 = Long.parseLong(numTwoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "plz,Enter the number ...\n" + ex.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    if (number1 >= number2) {
                        result = number1 - number2;
                    } else {
                        result = number2 - number1;
                    }

                    break;
                default:

            }
            if (result == (int) result) {

                resultTextField.setText(String.valueOf((int) result));

            } else {

                resultTextField.setText(String.valueOf(result));

            }

            getNumberOnLabel();
            sliceNumber();

        }

        if (e.getSource() == clrButton) {

            for (JTextField tField : fieldsInput) {
                tField.setText("");
            }
            for (int i = 6; i < labelArray.length; i++) {
                if (i == 10)
                    continue;

                labelArray[i].setText("");
            }

            result = 0;
            number2 = 0;
            number1 = 0;
            var = 0;
            flag = false;
       
        }
        if (e.getSource() == showOperationButton) {
            if (flag == true) {
                if (operator == '+') {
                    getNumberAddition();
                } else {
                    getNumberSubtraction();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please click on the button ( = ) Perform calculations ...\n",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == closeBtn) {
            System.exit(0);
        }

    }

    public void getNumberOnLabel() {

        s1 = "";
        s2 = "";
        input1 = numOneField.getText().trim();
        input2 = numTwoField.getText().trim();

        n1 = Integer.parseInt(input1);
        n2 = Integer.parseInt(input2);

        int count = Math.abs(input1.length() - input2.length());
        // int a=0;
        if (input1.length() > input2.length()) {

            while (count-- > 0) {
                s2 += 0 + "  ";
                // secondNumber.set(a++, 0);
            }
        } else if (input1.length() < input2.length()) {
            while (count-- > 0) {
                s1 += 0 + "  ";
                // firstNumber.set(a++, 0);
            }
        }

        for (int i = 0; i < input1.length(); i++) {
            s1 += input1.charAt(i) + "  ";
        }
        for (int i = 0; i < input2.length(); i++) {
            s2 += input2.charAt(i) + "  ";
        }
        if (n1 >= n2) {
            numOneLabel.setText(s1);
            numTwoLabel.setText(s2);
        } else {
            numOneLabel.setText(s2);
            numTwoLabel.setText(s1);
        }

    }

    public void sliceNumber() {
        input1 = s1.replaceAll("  ", "");
        input2 = s2.replaceAll("  ", "");

        firstNumber = new ArrayList<Integer>();
        secondNumber = new ArrayList<Integer>();

        for (int i = 0; i < input1.length(); i++) {

            if (n1 >= n2) {
                firstNumber.add(input1.charAt(i) - '0');
                secondNumber.add(input2.charAt(i) - '0');
            } else {
                secondNumber.add(input1.charAt(i) - '0');
                firstNumber.add(input2.charAt(i) - '0');
            }

        }

        var = firstNumber.size() -1;

        result1Number = new int[firstNumber.size()];

        switch (operator) {
            case '+':
                additionNumbers();
                break;
            case '-':
                SubtractionNumbers();
                break;

            default:
                JOptionPane.showMessageDialog(null, "plz,Enter the operation ...\n", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }

    }

    public static void getNumberAddition() {
        // Collections.reverse(firstNumber);

        String space = "";
        String space2 = "";

        for (int i = 0; i < firstNumber.size(); i++) {
            if (i >= var) {
                space +=firstNumber.get(i) + "  ";
                space2 +=result1Number[i] + "  ";
            } else {
                space += "  ";
                space2 += "  ";
            }
        }
        resultLabel2.setText(space);
        displayLabelTwo.setText(space2);

        var--;
    }
    public static void getNumberSubtraction() {
        // Collections.reverse(firstNumber);

        String space = "";
        String space2 = "";

        for (int i = 0; i < firstNumber.size(); i++) {
            if (i >= var) {
                space += firstNumber.get(i) + "  ";
                space2 += result1Number[i] + "  ";
            } else {
                space += "  ";
                space2 += "  ";
            }
        }
        resultLabel2.setText(space);
        displayLabelTwo.setText(space2);

        var--;
    }

    public void SubtractionNumbers() {

        for (int i = firstNumber.size() - 1; i >= 0; i--) {

            int n = firstNumber.get(i) - secondNumber.get(i);
            if (n < 0) {

                int a = firstNumber.get(i - 1) - 1;
                int b = firstNumber.get(i) + 10;
                result1Number[i] = b;
                firstNumber.set(i - 1, a);
                firstNumber.set(i, b - secondNumber.get(i));
            } else {
                firstNumber.set(i, n);
            }
        }
    }

    public void additionNumbers() {
        int[] arr = { 0, 0 };

        result1Number = new int[firstNumber.size()];

        for (int i = firstNumber.size() - 1; i >= 0; i--) {
            int n = firstNumber.get(i) + secondNumber.get(i) + arr[1];
            result1Number[i] = arr[1];
            if (n > 9 && i != 0) {
                int j = 0;
                while (n > 0) {
                    arr[j] = n % 10;
                    n /= 10;
                    j++;
                }

                
                firstNumber.set(i, arr[0]);

            } else {
                firstNumber.set(i, n);
                arr[1] = 0;
            }
        }
    }
}
