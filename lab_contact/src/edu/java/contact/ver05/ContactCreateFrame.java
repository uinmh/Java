package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
    
    @FunctionalInterface
    public interface ContactInsertListener {
        void contactInsertNotify(Contact c);
    }

    private ContactInsertListener listener;
    
    
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
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    public ContactCreateFrame(Component parent,ContactInsertListener listener) {
        
        this.parent = parent; // 부모 컴포먼트를 저장 초기화.
        this.listener = listener; // ContactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트들을 생성,초기화
    }
    
    /**
     * Initialize UI components
     */
   private void initialize() {
        
        //닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //JFrame이 화면에 보이게 될 좌표와 크기(가로/세로)를 설정.
        int x = parent.getX(); // 부모 컴포넌트의 x좌표
        int y = parent.getY(); // 부모 컴포넌트의 y좌표.
                
        setTitle("새 연락처");
        setBounds(x+130, y+150, 434, 300);
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
        textName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textName.setBounds(120, 23, 230, 40);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            
        });
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textPhone.setColumns(10);
        textPhone.setBounds(120, 80, 230, 40);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(120, 140, 230, 40);
        contentPane.add(textEmail);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            createNewContact();
            }
        });
        btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnSave.setBounds(120, 201, 97, 50);
        contentPane.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행.
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnCancel.setBounds(253, 201, 97, 50);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
        // 3개의 JText필드에 입력된 문자열을 읽는다.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        // Contact 객체 생성
        
        Contact contact = new Contact(name, phone, email);
        
        // 현재 창 닫기
        dispose();
        
        // 새 연락처가 생성 됬음을 (ContactMain) 알려줌.
        
        listener.contactInsertNotify(contact);
        
        
    }
}
