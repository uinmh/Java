package view;

import static model.Member.Entity.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.MemberDao;
import controller.MemberDaoImpl;
import model.Member;
import view.MemberDetailFrame.MemberViewListener;
import view.MemberNoticeFrame.MemberNoticeListener;

public class MemMain 
                implements MemberViewListener,
                           MemberNoticeListener{
  
    private static final String[] COLUMN_NAMES_NOTICE = {
            COL_NOTICE_NO, COL_TITLE, COL_MEM_NAME_NOTICE           
          };
    private JFrame frame;
    private JButton btnDetailMem;
    private JTable Pay_table;
    private JTable Notice_table;
    private MemberDaoImpl dao;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemMain window = new MemMain();
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
    public MemMain() {
        this.dao = MemberDaoImpl.getInstance();
        
        initialize();
        initializeTable();
    }

    private void initializeTable() {
        
        model = new DefaultTableModel(null,COLUMN_NAMES_NOTICE);
        
        Notice_table.setModel(model);
        
        List<Member> list = dao.readNotice();
        
        for (Member m : list) {
            Object[] row = {
                    m.getNoticeNo(),m.getTitle(),m.getMemNameNotice()
            };
            model.addRow(row);
        }
        
    }
    
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 527);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        btnDetailMem = new JButton("멤버 리스트");
        btnDetailMem.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnDetailMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MemberDetailFrame.newMemberDetailFrame(frame, MemMain.this);
            }
        });
        btnDetailMem.setBounds(68, 21, 140, 50);
        frame.getContentPane().add(btnDetailMem);
        
        JButton btnDetailPay = new JButton("회비 납부 관리");
        btnDetailPay.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnDetailPay.setBounds(272, 21, 140, 50);
        frame.getContentPane().add(btnDetailPay);
        
        JButton btnPayInfo = new JButton("회비 사용 내역");
        btnPayInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnPayInfo.setBounds(480, 21, 140, 50);
        frame.getContentPane().add(btnPayInfo);
        
        JScrollPane scrollPane_Pay = new JScrollPane();
        scrollPane_Pay.setBounds(12, 176, 357, 275);
        frame.getContentPane().add(scrollPane_Pay);
        
        Pay_table = new JTable();
        scrollPane_Pay.setViewportView(Pay_table);
        
        JScrollPane scrollPane_notice = new JScrollPane();
        scrollPane_notice.setBounds(408, 215, 284, 196);
        frame.getContentPane().add(scrollPane_notice);
        
        Notice_table = new JTable();
        scrollPane_notice.setViewportView(Notice_table);
        
        JButton btnNoticeDetailButton = new JButton("보기");
        btnNoticeDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showNoiceFrame();
            }
        });
        btnNoticeDetailButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        btnNoticeDetailButton.setBounds(560, 421, 60, 30);
        frame.getContentPane().add(btnNoticeDetailButton);
        
        JButton btnNoticeDeleteButton = new JButton("삭제");
        btnNoticeDeleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        btnNoticeDeleteButton.setBounds(632, 421, 60, 30);
        frame.getContentPane().add(btnNoticeDeleteButton);
        
        JLabel lblNotice = new JLabel("공지사항");
        lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
        lblNotice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNotice.setBounds(470, 164, 150, 30);
        frame.getContentPane().add(lblNotice);
        
        JLabel lblPayment = new JLabel("납부현황");
        lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
        lblPayment.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblPayment.setBounds(108, 136, 150, 30);
        frame.getContentPane().add(lblPayment);
    }

    private void showNoiceFrame() {

            int row = Notice_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(frame, 
                        "리스트 값을 선택하세요.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
     
            Integer noticeNo = (Integer) model.getValueAt(row, 0);

            MemberNoticeFrame.newNoticeFrame(frame, noticeNo, MemMain.this);
    }

    @Override 
    public void MemberViewFrame() { // 디테일 뷰 프레임
                
        
    }

    @Override
    public void memberNoticeView() {
        // TODO Auto-generated method stub
        
    }
}
