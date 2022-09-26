package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class AppMain04 {

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivided;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 306, 541);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel(" num1");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 128, 192));
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNewLabel.setBounds(25, 47, 65, 50);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNum = new JLabel(" num2");
        lblNum.setForeground(new Color(255, 255, 255));
        lblNum.setBackground(new Color(0, 128, 192));
        lblNum.setOpaque(true);
        lblNum.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNum.setBounds(25, 107, 65, 50);
        frame.getContentPane().add(lblNum);

        textField1 = new JTextField();
        textField1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        textField1.setBounds(110, 47, 140, 50);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        textField2.setColumns(10);
        textField2.setBounds(110, 107, 140, 50);
        frame.getContentPane().add(textField2);

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 파라미터 AcctionEvent e : 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 가지고 있음.
                // ActionEvent.getSource() : 이벤트가 발생한 컴포넌트를 리턴.
                performCalculation(e);
                double result = Double.parseDouble(textField1.getText());
                double result1 = Double.parseDouble(textField2.getText());

                textArea.setText(result + " + " + result1 + " = " + (result + result1));

            }
        });
        btnPlus.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnPlus.setBounds(12, 183, 58, 50);
        frame.getContentPane().add(btnPlus);

        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double result = Double.parseDouble(textField1.getText());
                double result1 = Double.parseDouble(textField2.getText());

                textArea.setText(result + " - " + result1 + " = " + (result - result1));

            }
        });
        btnMinus.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnMinus.setBounds(80, 183, 58, 50);
        frame.getContentPane().add(btnMinus);

        JButton btnMultiply = new JButton("X");
        btnMultiply.addActionListener((e) -> performCalculation(e));
        btnMultiply.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnMultiply.setBounds(150, 183, 58, 50);
        frame.getContentPane().add(btnMultiply);

        JButton btnDivided = new JButton("/");
        btnDivided.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double result = Double.parseDouble(textField1.getText());
                double result1 = Double.parseDouble(textField2.getText());

                textArea.setText(result + " / " + result1 + " = " + (result / result1));
            }
        });
        btnDivided.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnDivided.setBounds(220, 183, 58, 50);
        frame.getContentPane().add(btnDivided);

        textArea = new JTextArea();
        textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        textArea.setBounds(12, 263, 266, 229);
        frame.getContentPane().add(textArea);

    }

    private void performCalculation(ActionEvent e) {

        double number1 = 0;
        double number2 = 0;
        String op = "";

        try {
            // JTextField에 입력된 문자열을 읽고, double 타입으로 변환.
            number1 = Double.parseDouble(textField1.getText());
            number2 = Double.parseDouble(textField2.getText());
            double result; // 산술 결과를 저장하기 위한 변수.

            Object source = e.getSource(); // 이벤트가 발생한 컴포넌트

            if (source == btnPlus) {
                result = number1 + number2;
                op = " + ";
            } else if (source == btnMinus) {
                result = number1 - number2;
                op = " - ";
            } else if (source == btnMultiply) {
                result = number1 * number2;
                op = " * ";
            } else {
                result = number1 / number2;
                op = " / ";
            }

            String output = String.format("%f %s %f = %f", number1, op, number2, result);
            textArea.setText(output);
        } catch (Exception ex) {
            textArea.setText("number1 또는 number2는 숫자 타입으로 입력하세요...");
        }
    }
}