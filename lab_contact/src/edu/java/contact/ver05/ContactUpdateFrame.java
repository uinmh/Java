package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JButton btnSave;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                ContactUpdateFrame frame = new ContactUpdateFrame(parent);
                frame.setVisible(true);
            }
        });
    }

    public ContactUpdateFrame(Component parent) {
        this.parent = parent; // 부모 컴포먼트를 저장 초기화.
        initialize(); // UI 컴포넌트들을 생성,초기화
    }
    
    /**
     * Initialize UI components
     */
   private void initialize() {
        
        //닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX(); // 부모 컴포넌트의 x좌표
        int y = parent.getY(); // 부모 컴포넌트의 y좌표.
                
        setTitle("연락처 수정");
        setBounds(x+140, y+150, 434, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblName.setBounds(12, 15, 70, 50);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblPhone.setBounds(12, 70, 107, 50);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblEmail.setBounds(12, 130, 84, 50);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textName.setBounds(120, 23, 230, 40);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textPhone.setColumns(10);
        textPhone.setBounds(120, 80, 230, 40);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(120, 140, 230, 40);
        contentPane.add(textEmail);
        
        btnSave = new JButton("업데이트");
        btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnSave.setBounds(120, 201, 121, 50);
        contentPane.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnCancel.setBounds(253, 201, 97, 50);
        contentPane.add(btnCancel);
    }
}
