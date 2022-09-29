package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
    
    @FunctionalInterface
    public interface ContactUpdateListener{
        void contactUpdateNotify();
    }
    private ContactUpdateListener listener;
    private JPanel contentPane;
    private Component parent; // 업데이트 창을 실행 시킨 부모 컴포넌트
    private int index; // 수정할 연락처의 인덱스
    private ContactDaoImpl dao; // 연락처 검색(read), 업데이트(update), ....
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JButton btnSave;
    private JButton btnCancel;
    

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                ContactUpdateFrame frame = new ContactUpdateFrame(parent,index,listener);
                frame.setVisible(true);
            }
        });
    }

    public ContactUpdateFrame(Component parent,int index, ContactUpdateListener listener) {
        this.parent = parent; // 부모 컴포먼트를 저장 초기화.
        this.index = index;
        this.dao = ContactDaoImpl.getInstance(); // DAO 싱글턴 객체를 가져옴
        this.listener = listener; // 업데이트 창을 만든 메인 창의 주소를 저장
        
        initialize(); // UI 컴포넌트들을 생성,초기화
        
        initializeContactInfo(); // 연락처를 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
        
    }
    void initializeContactInfo() {
        Contact contact = dao.read(index); // 수정하려는 연락처 정보
       
        //각 textField에 연락처 정보를 씀
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
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
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            updateContact();
            }
        });
        btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnSave.setBounds(120, 201, 121, 50);
        contentPane.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnCancel.setBounds(253, 201, 97, 50);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        // 각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        //Contact 타입 객체 생성
        Contact contact = new Contact(name,phone,email);
        
        // DAO의 메서드를 사용해서 연락처 정보(파일) 업데이트
        dao.update(index, contact);
        
        // 창 닫기
        dispose();
        
        // 메인 창(Window)에게 연락처 정보 업데이트 됬다고 알려줌.

        listener.contactUpdateNotify();
    }
    
}
