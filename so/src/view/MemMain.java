package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import view.MemberDetailView.MemberViewListener;

public class MemMain 
                implements MemberViewListener{

    private JFrame frame;
    private JButton btnDetailMem;
    private JTable Pay_table;
    private JTable Notice_table;

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
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        btnDetailMem = new JButton("멤버 리스트");
        btnDetailMem.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnDetailMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MemberDetailView.newMemberDetailView(frame, MemMain.this);
            }
        });
        btnDetailMem.setBounds(50, 21, 140, 50);
        frame.getContentPane().add(btnDetailMem);
        
        JButton btnDetailPay = new JButton("회비 납부 내역");
        btnDetailPay.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnDetailPay.setBounds(202, 21, 140, 50);
        frame.getContentPane().add(btnDetailPay);
        
        JButton btnPayInfo = new JButton("회비 사용 내역");
        btnPayInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnPayInfo.setBounds(354, 21, 140, 50);
        frame.getContentPane().add(btnPayInfo);
        
        JScrollPane scrollPane_Pay = new JScrollPane();
        scrollPane_Pay.setBounds(12, 176, 357, 275);
        frame.getContentPane().add(scrollPane_Pay);
        
        Pay_table = new JTable();
        scrollPane_Pay.setViewportView(Pay_table);
        
        JScrollPane scrollPane_notice = new JScrollPane();
        scrollPane_notice.setBounds(408, 176, 284, 196);
        frame.getContentPane().add(scrollPane_notice);
        
        Notice_table = new JTable();
        scrollPane_notice.setViewportView(Notice_table);
        
        JButton btnNoticeDetailButton = new JButton("보기");
        btnNoticeDetailButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        btnNoticeDetailButton.setBounds(560, 382, 60, 30);
        frame.getContentPane().add(btnNoticeDetailButton);
        
        JButton btnNoticeDeleteButton = new JButton("삭제");
        btnNoticeDeleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        btnNoticeDeleteButton.setBounds(632, 382, 60, 30);
        frame.getContentPane().add(btnNoticeDeleteButton);
        
        JLabel lblNotice = new JLabel("공지사항");
        lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
        lblNotice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNotice.setBounds(469, 136, 150, 30);
        frame.getContentPane().add(lblNotice);
        
        JLabel lblPayment = new JLabel("납부현황");
        lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
        lblPayment.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblPayment.setBounds(108, 136, 150, 30);
        frame.getContentPane().add(lblPayment);
    }

    @Override
    public void MemberViewPoint() {
        
        
    }
}
