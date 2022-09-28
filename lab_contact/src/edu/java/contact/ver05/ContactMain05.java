package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ContactMain05 {

    private static final String[] COLUMN_NAMES = {"이름","전화번호"};
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private ContactDaoImpl dao;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); //UI컴포넌트 생성,초기화
        
        dao = ContactDaoImpl.getInstance(); //연락처 데이터 관리(추가,삭제,변경,검색)....
        loadContactDataFromFile(); // 데이터 파일에 저장된 데이터를 로드해서 테이블에 설정.
    }

    private void loadContactDataFromFile() {
      
        List<Contact> list = dao.read();
        
        for(Contact c : list) {
            addContactToTableModel(c);
        }
        
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
        frame.setTitle("Contact Ver 0.5");
        frame.setBounds(100, 100, 707, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 44, 691, 497);
        frame.getContentPane().add(scrollPane);
        
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 0, 691, 45);
        frame.getContentPane().add(buttonPanel);
        
        JButton btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame);
            }
        });
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactUpdateFrame.newContactUpdateFrame(frame);
            }
        });
        btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttonPanel.add(btnDelete);
        
        JButton btndelete = new JButton("검색");
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btndelete.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        buttonPanel.add(btndelete);
    }
}
