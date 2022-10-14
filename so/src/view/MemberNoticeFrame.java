package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MemberDaoImpl;

public class MemberNoticeFrame extends JFrame {

    public interface MemberNoticeListener {
        void memberNoticeView();
    }
    
    private JPanel contentPane;
    private MemberNoticeListener listener;
    private MemberDaoImpl dao;
    private Component parent;
    private Integer noticeNo;
    /**
     * Launch the application.
     */
    public static void newNoticeFrame(Component parent, Integer noticeNo, MemberNoticeListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberNoticeFrame frame = new MemberNoticeFrame(parent, noticeNo, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public MemberNoticeFrame(Component parent, Integer noticeNo, MemberNoticeListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.dao = MemberDaoImpl.getInstance();
        this.noticeNo = noticeNo;
    }
    /**
     * Create the frame.
     */
    public void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x + 60, y + 50, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
    }

}
