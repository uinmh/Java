package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemberUpdateFrame extends JFrame {

    public interface MemberUpdateListener {
        void MemberUpdate();
    }
    private JPanel contentPane;
    private Component parent;
    private MemberUpdateListener listener;
    private JTextField textmemId;
    private JTextField textField;
    private JLabel lblBirthDay;
    private JTextField textBirthDay;
    private JLabel lblName;
    private JTextField textName;
    private JLabel lblPhone;
    private JTextField textPhone;
    private JLabel lblCity;
    private JTextField textCity;
    private JLabel lblQ;
    
    /**
     * Launch the application.
     */
    public static void newMemberUpdateFrame(Component parent, MemberUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberUpdateFrame frame = new MemberUpdateFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MemberUpdateFrame(Component parent, MemberUpdateListener listener) {
        this.parent = parent;
        this.listener = listener;
        
        initialize();
        
    }
      
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("회원 정보 수정");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x + 120, y + 50, 358, 383);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblmemId = new JLabel("회원번호");
        lblmemId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblmemId.setHorizontalAlignment(SwingConstants.CENTER);
        lblmemId.setBounds(12, 22, 61, 22);
        contentPane.add(lblmemId);
        
        textmemId = new JTextField();
        textmemId.setEnabled(false);
        textmemId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textmemId.setBounds(72, 25, 25, 20);
        contentPane.add(textmemId);
        textmemId.setColumns(10);
        
        JLabel lblmemJoin = new JLabel("가입일");
        lblmemJoin.setHorizontalAlignment(SwingConstants.CENTER);
        lblmemJoin.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblmemJoin.setBounds(178, 22, 61, 22);
        contentPane.add(lblmemJoin);
        
        textField = new JTextField();
        textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textField.setColumns(10);
        textField.setBounds(241, 25, 80, 20);
        contentPane.add(textField);
        
        lblBirthDay = new JLabel("생년월일");
        lblBirthDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblBirthDay.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblBirthDay.setBounds(178, 55, 61, 22);
        contentPane.add(lblBirthDay);
        
        textBirthDay = new JTextField();
        textBirthDay.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textBirthDay.setColumns(10);
        textBirthDay.setBounds(241, 57, 80, 20);
        contentPane.add(textBirthDay);
        
        lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblName.setBounds(12, 54, 61, 22);
        contentPane.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textName.setColumns(10);
        textName.setBounds(72, 57, 70, 20);
        contentPane.add(textName);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblPhone.setBounds(12, 86, 61, 22);
        contentPane.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textPhone.setColumns(10);
        textPhone.setBounds(72, 89, 70, 20);
        contentPane.add(textPhone);
        
        lblCity = new JLabel("지역");
        lblCity.setHorizontalAlignment(SwingConstants.CENTER);
        lblCity.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblCity.setBounds(178, 87, 61, 22);
        contentPane.add(lblCity);
        
        textCity = new JTextField();
        textCity.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textCity.setColumns(10);
        textCity.setBounds(241, 87, 80, 20);
        contentPane.add(textCity);
        
        lblQ = new JLabel("비고");
        lblQ.setHorizontalAlignment(SwingConstants.CENTER);
        lblQ.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lblQ.setBounds(130, 119, 61, 22);
        contentPane.add(lblQ);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 151, 318, 180);
        contentPane.add(scrollPane);
        
        JTextArea textQ = new JTextArea();
        textQ.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        scrollPane.setViewportView(textQ);
    
    }
}
