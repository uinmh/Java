package edu.java.contact.ver06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver05.ContactUpdateFrame;
import edu.java.contact.ver06.ContactCreateFrame.ContactInsertListener;
import edu.java.contact.ver06.ContactDetailFrame.ContactUpdatelListener;

import static edu.java.contact.ver06.Contact.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Contact06Main 
            implements ContactInsertListener,ContactUpdatelListener {

    private static final String[] COLUMN_NAMES= {
            COL_CID,COL_NAME,COL_PHONE
    };
    
    
    private DefaultTableModel model;
    private ContactDaoImpl dao;
    private JFrame frame;
    private JTable table;
    private JButton btnNewButton;
    private JButton btnDelete;
    private JButton btnDetail;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Contact06Main window = new Contact06Main();
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
    public Contact06Main() {
        
        
        initialize();
        dao = ContactDaoImpl.getInstance();
        initializeTable();
    }

    private void initializeTable() {
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        
        table.setModel(model);
        List<Contact> list = dao.select();
        
        for (Contact c : list) {
            Object[] row = {
                    c.getCid(), c.getName(), c.getPhone(), c.getEmail()
            };
            model.addRow(row);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        frame = new JFrame();
        frame.setTitle("Contact sql_ver 0.6");
        frame.setBounds(100, 100, 553, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttenPanel = new JPanel();
        frame.getContentPane().add(buttenPanel, BorderLayout.NORTH);
        
        btnNewButton = new JButton("등록");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ContactCreateFrame.newContactCreateFrame(frame, Contact06Main.this);
            }
        });
        
        btnNewButton_1 = new JButton("전체보기");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        buttenPanel.add(btnNewButton_1);
        btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        buttenPanel.add(btnNewButton);
        
        btnDetail = new JButton("상세보기");
        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailFrame();
            }
        });
        btnDetail.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        buttenPanel.add(btnDetail);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteContact();                  
                    }catch (Exception e1) {
                        JOptionPane.showMessageDialog(frame,
                                "삭제할 행을 먼저 선택 하세요.",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);   
                    }
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        buttenPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }

    private void deleteContact() {
        
        int row = table.getSelectedRow();
        
        //선택된 행에서 인덱스 0번 컬럼의 값 (BLOG_NO)를 읽음.
        Integer cid = (Integer)model.getValueAt(row, 0);
        
        int confirm = JOptionPane.showConfirmDialog(frame,
                cid + "번 글을 삭제 하시겠습니까",
                "삭제 확인",
                JOptionPane.YES_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(cid);
        }else {
            return;
        }
        
        // 테이블 갱신
        model.removeRow(row);
        
        JOptionPane.showMessageDialog(frame, "삭제 완료!");
        
    }

    private void showDetailFrame() {
        
        int row = table.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "테이블의 행을 먼저 선택하세요",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer cid = (Integer)model.getValueAt(row, 0);
        System.out.println(cid);
        ContactDetailFrame.newContactDetailFrame(frame, cid, Contact06Main.this);
        
    }

    @Override
    public void ContactInsertNotify(Contact contact) {
        initializeTable();
        
    }

    @Override
    public void ContactUpdate() {
        initializeTable();
        
    }

}
