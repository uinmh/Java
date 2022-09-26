package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

    private JFrame frame;
    private JLabel lblText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // 쓰레드를 EventQueue에 등록 -> 자바 가상 머신이 쓰레드를 실행시킴 -> run() 실행.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
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
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        lblText = new JLabel("안녕하세요.Swing! ^^"); // JLabel 객체 생성.
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        frame.getContentPane().add(lblText, BorderLayout.CENTER); // JLabel 객체를 화면에 추가.
    }

}
