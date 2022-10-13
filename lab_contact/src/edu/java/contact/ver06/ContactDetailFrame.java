package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactDetailFrame extends JFrame {

    public interface ContactUpdatelListener {
        void ContactUpdate();
    }
    
    
    private ContactUpdatelListener listener;
    private Component parent;
    private Integer cid;
    private ContactDaoImpl dao;
    private JPanel contentPane;
    private JTextField textCid;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactDetailFrame(Component parent, Integer cid, ContactUpdatelListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactDetailFrame frame = new ContactDetailFrame(parent, cid, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ContactDetailFrame(Component parent, Integer cid, ContactUpdatelListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.cid = cid;
        this.dao = ContactDaoImpl.getInstance();
        initalize();
        
        initializeContactData();
        
    }

    private void initializeContactData() {
      
        Contact contact = dao.select(cid);

            textCid.setText(contact.getCid().toString());
            textName.setText(contact.getName());
            textPhone.setText(contact.getPhone());
            textEmail.setText(contact.getEmail());
            
        
    }
    /**
     * Create the frame.
     */
    public void initalize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 370, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbltitle = new JLabel("상세 정보");
        lbltitle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lbltitle.setBounds(117, 20, 115, 39);
        contentPane.add(lbltitle);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName.setBounds(21, 141, 58, 45);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblPhone.setBounds(12, 210, 100, 45);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblEmail.setBounds(12, 283, 100, 45);
        contentPane.add(lblEmail);
        
        JLabel lblNumber = new JLabel("번호");
        lblNumber.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblNumber.setBounds(21, 85, 58, 45);
        contentPane.add(lblNumber);
        
        textCid = new JTextField();
        textCid.setEditable(false);
        textCid.setBounds(128, 87, 65, 40);
        contentPane.add(textCid);
        textCid.setColumns(10);
        
        textName = new JTextField();
        textName.setColumns(10);
        textName.setBounds(128, 144, 170, 40);
        contentPane.add(textName);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(128, 218, 172, 40);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(127, 284, 172, 40);
        contentPane.add(textEmail);
        
        JButton btnNewButton = new JButton("수정");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        btnNewButton.setBounds(30, 360, 99, 64);
        contentPane.add(btnNewButton);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        btnCancel.setBounds(220, 361, 99, 64);
        contentPane.add(btnCancel);
    }
    private void updateContact() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        if(name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(this,
                    "이름/전화번호는 반드시 입력 되어야 합니다.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Contact contact = new Contact(cid, name, phone, email);
        
        int result = dao.update(contact);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, 
                    cid + "번 주소록 업데이트 성공");
            
            dispose();
            
            listener.ContactUpdate();
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    cid + "번 주소록 업데이트 실패"
                    );
        }
        
        
    }
}
