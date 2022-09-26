package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField NameInput;
    private JTextField PhoneInput;
    private JTextField EmailInput;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 600);
        frame.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("입력");
        // 버튼에 이벤트 핸들러를 등록
        // 이벤트 핸들러 : 이벤트가 발생됬을때 자동으로 호출되는 메서드.
        
        btnNewButton.addActionListener((e) -> printInfo());
        
        
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 35));
        btnNewButton.setBounds(313, 119, 112, 59);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblName.setBounds(51, 52, 64, 46);
        frame.getContentPane().add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblPhone.setBounds(31, 114, 105, 46);
        frame.getContentPane().add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblEmail.setBounds(41, 184, 80, 46);
        frame.getContentPane().add(lblEmail);
        
        NameInput = new JTextField();
        NameInput.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        NameInput.setBounds(148, 60, 150, 33);
        frame.getContentPane().add(NameInput);
        NameInput.setColumns(10);
        
        PhoneInput = new JTextField();
        PhoneInput.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        PhoneInput.setColumns(10);
        PhoneInput.setBounds(148, 128, 150, 33);
        frame.getContentPane().add(PhoneInput);
        
        EmailInput = new JTextField();
        EmailInput.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        EmailInput.setColumns(10);
        EmailInput.setBounds(148, 191, 150, 33);
        frame.getContentPane().add(EmailInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        textArea.setBounds(32, 275, 372, 255);
        frame.getContentPane().add(textArea);
    }
    
    
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
        // JTextField에 입력된 내용을 읽음.
        
        String name = NameInput.getText();
        String phone = PhoneInput.getText();
        String email = EmailInput.getText();
        
//      textArea.setText("이름 = "+ input + "\n전화번호 = " + input2 + "\n이메일 = " + input3);
        
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n")
        .append("전화번호: ").append(phone).append("\n")
        .append("이메일 : ").append(email);
        
        textArea.setText(buffer.toString());
    }
}
