package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver05.ContactCreateFrame.ContactInsertListener;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class ContactSearchFrame extends JFrame {
    private static final String[] COLUMN_NAMES = {"이름","전화번호","이메일"};
    private JFrame frame;
    private JTextField textField;
    private JTable table;
    private DefaultTableModel model;
    private Component parent;
    private ContactInsertListener listener;
    /**
     * Launch the application.
     */
    public static void ContactSearchFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactSearchFrame window = new ContactSearchFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public ContactSearchFrame(Component parent,ContactInsertListener listener) {
        
        this.parent = parent; // 부모 컴포먼트를 저장 초기화.
        this.listener = listener; // ContactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트들을 생성,초기화
    }

    /**
     * Create the application.
     */
    public ContactSearchFrame() {
        initialize();
    }

    private void addContactToTableModel(Contact c) {
        // 테이블 모델에 추가할 행(row) 데이터
        Object[] rowData = {c.getName(),c.getPhone()};
        // 데이터 테이블에 모델 추가
        model.addRow(rowData);
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 479, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(43, 33, 214, 45);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("검색");
        btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        btnNewButton.setBounds(303, 33, 97, 45);
        frame.getContentPane().add(btnNewButton);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBounds(10, 104, 443, 287);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        table.setBounds(10, 104, 443, 287);
        frame.getContentPane().add(table);
        
        JCheckBox chckbxName = new JCheckBox("이름");
        chckbxName.setBounds(43, 6, 59, 23);
        frame.getContentPane().add(chckbxName);
        
        JCheckBox chckbxPhone = new JCheckBox("전화번호");
        chckbxPhone.setBounds(106, 6, 83, 23);
        frame.getContentPane().add(chckbxPhone);
        
        JCheckBox chckbxEmail = new JCheckBox("email");
        chckbxEmail.setBounds(198, 6, 59, 23);
        frame.getContentPane().add(chckbxEmail);
    }
}
