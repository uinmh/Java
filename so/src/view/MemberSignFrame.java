package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MemberDaoImpl;
import model.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class MemberSignFrame extends JFrame {

    public interface MemberSignListener {
        void MemberSign();
    }
    
    
    private JPanel contentPane;
    private MemberSignListener listener;
    private Component parent;
    private MemberDaoImpl dao;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textCity;
    private JTextField textBirthday;
    private JLabel lblNewLabel;
    private JTextArea textQ;
    private JButton btnInsert;
    /**
     * Launch the application.
     */
    public static void newMemberSignFrame(Component parent, MemberSignListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberSignFrame frame = new MemberSignFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    public MemberSignFrame(Component parent, MemberSignListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.dao = MemberDaoImpl.getInstance();
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("신규 멤버 등록");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x + 70, y + 50, 450, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(198, 31, 70, 20);
        contentPane.add(lblName);
        
        textName = new JTextField();
        textName.setBounds(280, 31, 116, 21);
        contentPane.add(textName);
        textName.setColumns(10);
        
        JLabel 전화번호 = new JLabel("전화번호");
        전화번호.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        전화번호.setHorizontalAlignment(SwingConstants.CENTER);
        전화번호.setBounds(198, 70, 70, 20);
        contentPane.add(전화번호);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(280, 70, 116, 21);
        contentPane.add(textPhone);
        
        textCity = new JTextField();
        textCity.setBounds(280, 108, 116, 21);
        contentPane.add(textCity);
        textCity.setColumns(10);
        
        JLabel lblCity = new JLabel("지역/도시");
        lblCity.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        lblCity.setHorizontalAlignment(SwingConstants.CENTER);
        lblCity.setBounds(199, 108, 70, 20);
        contentPane.add(lblCity);
        
        JLabel lblBirthday = new JLabel("생년월일");
        lblBirthday.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
        lblBirthday.setBounds(199, 149, 70, 20);
        contentPane.add(lblBirthday);
        
        textBirthday = new JTextField();
        textBirthday.setColumns(10);
        textBirthday.setBounds(280, 148, 116, 21);
        contentPane.add(textBirthday);
        
        JTextArea textPhoto = new JTextArea();
        textPhoto.setText("Photo");
        textPhoto.setBounds(25, 29, 161, 140);
        contentPane.add(textPhoto);
        
        lblNewLabel = new JLabel("비고");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        lblNewLabel.setBounds(25, 189, 57, 15);
        contentPane.add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 214, 379, 102);
        contentPane.add(scrollPane);
        
        textQ = new JTextArea();
        scrollPane.setViewportView(textQ);
        
        btnInsert = new JButton("등록");
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            memberInsert();
            }
        });
        btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        btnInsert.setBounds(290, 179, 97, 23);
        contentPane.add(btnInsert);
    }


    private void memberInsert() {
       
        Date memBirthDay = Date.valueOf(textBirthday.getText());
        String memName = textName.getText();
        String memPhone = textPhone.getText();
        String memCity = textCity.getText();
        String memQ = textQ.getText();
        
        if(memName.equals("") || memPhone.equals("") || memCity.equals("")
                || memBirthDay.equals("") || memQ.equals("")){
            
            JOptionPane.showMessageDialog(
                    MemberSignFrame.this,
                    "빈 항목이 없도록 작성 해주세요.", 
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return; 
     }
    
     Member member = new Member(null, null, memBirthDay, memName, memPhone, memCity, memQ);
        int result = dao.insert(member);
        if (result == 1) { 
            JOptionPane.showMessageDialog(this, "멤버 등록 성공");
            dispose(); 
            
            listener.MemberSign();
        }else {
            JOptionPane.showMessageDialog(this, 
                    "멤버 등록 실패", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
