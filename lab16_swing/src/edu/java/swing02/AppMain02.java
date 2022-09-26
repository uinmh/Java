package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

    private JFrame frame;
    private JTextField textInput;
    private JLabel lblResult;
    private JButton btnInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
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
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // absolute layout 선택해서 값이 null
        
        lblResult = new JLabel("New label");
        lblResult.setFont(new Font("맑은 고딕", Font.BOLD, 40)); 
        lblResult.setBounds(12, 10, 410, 65); // *시작위치 (12,10) *실행크기 (410,107)
        frame.getContentPane().add(lblResult);// JLabeldl이 화면에 추가.
        
        textInput = new JTextField();
        textInput.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        textInput.setBounds(12, 85, 410, 88);
        frame.getContentPane().add(textInput); //JTextfiled가 화면에 추가.
        textInput.setColumns(10);
        
        btnInput = new JButton("입력");
        //버튼에 이벤트 핸들러를 설정 - 이벤트가 발생했을 때 그 이벤트를 처리할 수 있는 객체를 정의.
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // 버튼이 클릭됬을 때 할 일을 정의.
               //1) JTextField에 입력된 내용을 읽는다.
                String input = textInput.getText();
                
               //2) 그 내용을 JLabel에 씀.
                lblResult.setText(input);
               //3) 
            }
        });
        btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        btnInput.setBounds(12, 183, 410, 68);
        frame.getContentPane().add(btnInput); // JButton을 화면에 추가
    }
}
