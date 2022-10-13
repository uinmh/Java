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
import java.net.http.WebSocket.Listener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
    @FunctionalInterface
    public interface ContactInsertListener {
        void ContactInsertNotify(Contact contact);
    }
    
    private ContactInsertListener listener;
    private Component parent;
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private ContactDaoImpl dao;
    

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactCreateFrame frame = new ContactCreateFrame(parent,listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.dao = ContactDaoImpl.getInstance();
        initialize();
    }
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("새 주소록 작성");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 327, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName.setBounds(31, 62, 76, 65);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblPhone.setBounds(12, 137, 107, 65);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblEmail.setBounds(22, 212, 83, 65);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textName.setBounds(131, 79, 129, 35);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textPhone.setColumns(10);
        textPhone.setBounds(131, 154, 129, 35);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(131, 230, 129, 35);
        contentPane.add(textEmail);
        
        JLabel lblNewLabel = new JLabel("전화번호 등록");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
        lblNewLabel.setBounds(59, 10, 174, 43);
        contentPane.add(lblNewLabel);
        
        JButton btnInsert = new JButton("등록");
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        btnInsert.setBounds(31, 323, 97, 56);
        contentPane.add(btnInsert);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        btnCancel.setBounds(175, 323, 97, 56);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
     
        
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        if (name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(this,
                    "등록이 불가능 합니다",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        return;        
    }
        
        Contact contact = new Contact(null, name, phone, email);
        
        int result = dao.insert(contact);
        if (result == 1) {
            JOptionPane.showMessageDialog(this,
                    contact.getName() + "등록 되었습니다.");
        dispose();
        listener.ContactInsertNotify(contact);
        }else {
            JOptionPane.showMessageDialog(this,
                    "작성할 수 없습니다.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
  }

}