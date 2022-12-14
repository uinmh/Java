package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MemberDao;
import controller.MemberDaoImpl;
import model.Member;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MemberUpdateFrame extends JFrame {

    public interface MemberUpdateListener {
        void MemberUpdate();
    }
    private JPanel contentPane;
    private Component parent;
    private MemberUpdateListener listener;
    private JTextField textmemId;
    private JTextField textJoinDay;
    private JLabel lblBirthDay;
    private JTextField textBirthDay;
    private JLabel lblName;
    private JTextField textName;
    private JLabel lblPhone;
    private JTextField textPhone;
    private JLabel lblCity;
    private JTextField textCity;
    private JLabel lblQ;
    private MemberDaoImpl dao;
    private Integer memNo;
    private JTextArea textQ;
    private JButton btnUpdate;
    /**
     * Launch the application.
     */
    public static void newMemberUpdateFrame(Component parent, Integer memNo, MemberUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberUpdateFrame frame = new MemberUpdateFrame(parent, memNo, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MemberUpdateFrame(Component parent, Integer memNo, MemberUpdateListener listener) {
        this.parent = parent;
        this.listener = listener;
        this.memNo = memNo;
        this.dao = MemberDaoImpl.getInstance();
        initialize();
        initializeMemberInfo();
    }
      
    
    void initializeMemberInfo() {
    	Member member = dao.read(memNo);
    	System.out.println(memNo);
    	textmemId.setText(member.getMemberId().toString());
    	textName.setText(member.getMemName());
    	textPhone.setText(member.getMemPhone());
    	textJoinDay.setText(member.getMemJoinDay().toString());
    	textBirthDay.setText(member.getMemBirthDay().toString());
    	textCity.setText(member.getMemCity());
    	textQ.setText(member.getMemQ());
    }
    
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("?????? ?????? ??????????????? /??????");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x + 120, y + 50, 358, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblmemId = new JLabel("????????????");
        lblmemId.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblmemId.setHorizontalAlignment(SwingConstants.CENTER);
        lblmemId.setBounds(12, 22, 61, 22);
        contentPane.add(lblmemId);
        
        textmemId = new JTextField();
        textmemId.setEnabled(false);
        textmemId.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textmemId.setBounds(72, 25, 25, 20);
        contentPane.add(textmemId);
        textmemId.setColumns(10);
        
        JLabel lblmemJoin = new JLabel("?????????");
        lblmemJoin.setHorizontalAlignment(SwingConstants.CENTER);
        lblmemJoin.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblmemJoin.setBounds(178, 22, 61, 22);
        contentPane.add(lblmemJoin);
        
        textJoinDay = new JTextField();
        textJoinDay.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textJoinDay.setColumns(10);
        textJoinDay.setBounds(241, 25, 80, 20);
        contentPane.add(textJoinDay);
        
        lblBirthDay = new JLabel("????????????");
        lblBirthDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblBirthDay.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblBirthDay.setBounds(178, 55, 61, 22);
        contentPane.add(lblBirthDay);
        
        textBirthDay = new JTextField();
        textBirthDay.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textBirthDay.setColumns(10);
        textBirthDay.setBounds(241, 57, 80, 20);
        contentPane.add(textBirthDay);
        
        lblName = new JLabel("??????");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblName.setBounds(12, 54, 61, 22);
        contentPane.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textName.setColumns(10);
        textName.setBounds(72, 57, 70, 20);
        contentPane.add(textName);
        
        lblPhone = new JLabel("????????????");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblPhone.setBounds(12, 86, 61, 22);
        contentPane.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textPhone.setColumns(10);
        textPhone.setBounds(72, 89, 100, 20);
        contentPane.add(textPhone);
        
        lblCity = new JLabel("??????");
        lblCity.setHorizontalAlignment(SwingConstants.CENTER);
        lblCity.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblCity.setBounds(178, 87, 61, 22);
        contentPane.add(lblCity);
        
        textCity = new JTextField();
        textCity.setFont(new Font("?????? ??????", Font.PLAIN, 12));
        textCity.setColumns(10);
        textCity.setBounds(241, 87, 80, 20);
        contentPane.add(textCity);
        
        lblQ = new JLabel("??????");
        lblQ.setHorizontalAlignment(SwingConstants.CENTER);
        lblQ.setFont(new Font("?????? ??????", Font.BOLD, 12));
        lblQ.setBounds(130, 119, 61, 22);
        contentPane.add(lblQ);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 151, 318, 180);
        contentPane.add(scrollPane);
        
        textQ = new JTextArea();
        textQ.setFont(new Font("?????? ??????", Font.PLAIN, 13));
        scrollPane.setViewportView(textQ);
        
        btnUpdate = new JButton("????????????");
        btnUpdate.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	MemberUpdate();
        	}
        });
        btnUpdate.setFont(new Font("?????? ??????", Font.PLAIN, 13));
        btnUpdate.setBounds(67, 349, 95, 30);
        contentPane.add(btnUpdate);
        
        JButton btnCancel = new JButton("??????");
        btnCancel.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	dispose();
        	}
        });
        btnCancel.setFont(new Font("?????? ??????", Font.PLAIN, 13));
        btnCancel.setBounds(192, 349, 95, 30);
        contentPane.add(btnCancel);
    
    }

	private void MemberUpdate() {
		try {
        Date memJoinDay = Date.valueOf(textJoinDay.getText());
        Date memBirthDay = Date.valueOf(textBirthDay.getText());
        String memName = textName.getText();
        String memPhone = textPhone.getText();
        String memCity = textCity.getText();
        String memQ = textQ.getText();
//        Integer memId = Integer.parseInt(textmemId.getText());
        		
        if (memJoinDay.equals("") || memBirthDay.equals("")|| memName.equals("") || memPhone.equals("")
        		|| memCity.equals("") || memQ.equals("") || memJoinDay.equals("yyyy-mm-dd")){
            JOptionPane.showMessageDialog(this, 
                    "??? ????????? ?????? ?????????.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            
            return;
            
            
        }

        Member member = new Member(memNo, memJoinDay, memBirthDay, memName, memPhone, memCity, memQ);
        
        // DAO??? ???????????? ???????????? ????????? ?????? (??????) ????????????.
       int result = dao.update(member);
     
       if (result == 1) {
        	
               dispose();

            listener.MemberUpdate();
            
            JOptionPane.showMessageDialog(parent, 
                    "???????????? ??????", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parent, 
                    "???????????? ??????", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
		} catch (Exception e) {
//			e.printStackTrace();
			   JOptionPane.showMessageDialog(this, 
	                    "YYYY-MM-DD ??? ??????????????????.",
	                    "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            
	            return;
		}
		
      		
	}
}
