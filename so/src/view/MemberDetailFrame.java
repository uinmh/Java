package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.MemberDaoImpl;
import model.Member;
import view.MemberSignFrame.MemberSignListener;
import view.MemberUpdateFrame.MemberUpdateListener;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static model.Member.Entity.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemberDetailFrame extends JFrame 
            implements MemberUpdateListener, MemberSignListener{
    
  private static final String[] COLUMN_NAMES = {
    COL_MEM_ID,COL_MEM_NAME,COL_MEM_PHONE,COL_MEM_BIRTHDAY,COL_MEM_CITY
  };
    
    public interface MemberViewListener {
        void MemberViewFrame();
    }

    private JPanel contentPane;
    private Component parent;
    private MemberViewListener listener;
    private JComboBox<String> comboBox;
    private DefaultTableModel model;
    private MemberDaoImpl dao;
    private JTable table;
    private JTextField textKeyword;
    
    /**
     * Launch the application.
     */
    public static void newMemberDetailFrame(Component parent, MemberViewListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberDetailFrame frame = new MemberDetailFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public MemberDetailFrame(Component parent, MemberViewListener listener) {
        this.parent = parent;
        this.listener = listener;
        dao = MemberDaoImpl.getInstance();
        initialize(); 
        initializeTable();
    }

    private void initializeTable() {
        
        model = new DefaultTableModel(null,COLUMN_NAMES);
        
        table.setModel(model);
        
        List<Member> list = dao.read();
        
        for (Member m : list) {
            Object[] row = {
                m.getMemberId(),m.getMemName(),m.getMemPhone(),m.getMemBirthDay(),m.getMemCity()
            };
            model.addRow(row);
        }
        
    }
    /**
     * Create the frame.
     */
	public void initialize() {
        setTitle("?????? ?????? ?????????");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x + 50, y + 50, 600, 574);
        contentPane = new JPanel();
        contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnUpdateMem = new JButton("?????????/??????");
        btnUpdateMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showUpdateFrame();
            }
        });
        btnUpdateMem.setBounds(123, 485, 110, 31);
        contentPane.add(btnUpdateMem);
        btnUpdateMem.setFont(new Font("?????? ??????", Font.BOLD, 13));
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(113, 448, 93, 27);
        comboBox.setFont(new Font("?????? ??????", Font.BOLD, 13));
        
        String[] comboBoxItems = { "??????", "??????", "????????????", "?????????", "????????????"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        comboBox.setModel(comboBoxModel);
        comboBox.setSelectedIndex(0);
        contentPane.add(comboBox);
        
        textKeyword = new JTextField();
        textKeyword.setBounds(210, 448, 178, 27);
        contentPane.add(textKeyword);
        textKeyword.setToolTipText("???????????????.");
        textKeyword.setHorizontalAlignment(SwingConstants.LEFT);
        textKeyword.setColumns(15);
        
        JButton btnSearch = new JButton("??????");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMemberByKeyword();
            }
        });
        btnSearch.setBounds(395, 448, 63, 29);
        contentPane.add(btnSearch);
        btnSearch.setFont(new Font("?????? ??????", Font.BOLD, 13));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 42, 560, 395);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        
        table = new JTable();
        table.setAlignmentY(0.0f);
        table.setAlignmentX(0.0f);
        scrollPane.setViewportView(table);
        JLabel lblNewLabel = new JLabel("?????? ??????");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("?????? ??????", Font.BOLD, 15));
        lblNewLabel.setBounds(184, 11, 198, 21);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("????????????");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            initializeTable();
            }
        });
        btnNewButton.setFont(new Font("?????? ??????", Font.BOLD, 13));
        btnNewButton.setBounds(479, 8, 93, 29);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("?????? ??????");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MemberSignFrame.newMemberSignFrame(MemberDetailFrame.this,MemberDetailFrame.this);
            }
        });
        btnNewButton_1.setFont(new Font("?????? ??????", Font.BOLD, 13));
        btnNewButton_1.setBounds(245, 485, 95, 31);
        contentPane.add(btnNewButton_1);
        
        JButton btnDelete = new JButton("??????");
        btnDelete.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		memberDelete();
        	}
        });
        btnDelete.setFont(new Font("?????? ??????", Font.BOLD, 13));
        btnDelete.setBounds(352, 485, 95, 31);
        contentPane.add(btnDelete);
    }

    private void memberDelete() {
		
        int row = table.getSelectedRow();
        if (row == -1) { 
            JOptionPane.showMessageDialog(MemberDetailFrame.this, 
                    "????????? ?????? ?????? ???????????????",
                    "Warning", // ????????? 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // ????????? CID
        Integer memNo = (Integer) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(MemberDetailFrame.this, 
                "????????? ????????? ?????? ???????????????????",
                "?????? ??????",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
         
            int result = dao.delete(memNo);
            if (result == 1) {
                initializeTable();
                JOptionPane.showMessageDialog(MemberDetailFrame.this, "?????? ??????");
            } else {
                JOptionPane.showMessageDialog(MemberDetailFrame.this, "?????? ??????");
            }
        }
		
	}

	private void searchMemberByKeyword() {
        String keyword = textKeyword.getText();
        if (keyword.equals("")) { 
            JOptionPane.showMessageDialog(MemberDetailFrame.this,    
                    "???????????? ???????????????.", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int type = comboBox.getSelectedIndex();
        
        List<Member> list = dao.read(type, keyword);
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        for (Member m : list) {
            Object[] row = {
                m.getMemberId(),m.getMemName(),m.getMemPhone(),m.getMemBirthDay(),m.getMemCity()
            };
            model.addRow(row);
        }
    }

    private void showUpdateFrame() {
       
    	int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(MemberDetailFrame.this, 
                    "????????? ?????? ???????????????.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        Integer memNo = (Integer) model.getValueAt(row, 0);
 
        MemberUpdateFrame.newMemberUpdateFrame(MemberDetailFrame.this, memNo, this);
    }


    
	@Override
    public void MemberUpdate() {
       
        initializeTable();
    }

    @Override
    public void MemberSign() {
        
        initializeTable();
        
    }
}
