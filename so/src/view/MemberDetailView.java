package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.MemberDaoImpl;
import model.Member;
import view.MemberUpdateFrame.MemberUpdateListener;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import static model.Member.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberDetailView extends JFrame 
            implements MemberUpdateListener{
    
  private static final String[] COLUMN_NAMES = {
    COL_MEM_ID,COL_MEM_NAME,COL_MEM_PHONE,COL_MEM_BIRTHDAY,COL_MEM_CITY
  };
    
    public interface MemberViewListener {
        void MemberViewPoint();
    }

    private JPanel contentPane;
    private Component parent;
    private MemberViewListener listener;
    private JTextField textField;
    private JComboBox comboBox;
    private DefaultTableModel model;
    private MemberDaoImpl dao;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void newMemberDetailView(Component parent, MemberViewListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberDetailView frame = new MemberDetailView(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public MemberDetailView(Component parent, MemberViewListener listener) {
        this.parent = parent;
        this.listener = listener;
        initialize(); 
        dao = MemberDaoImpl.getInstance();
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
        setTitle("회원 관리 정보창");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x + 50, y + 50, 600, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnUpdateMem = new JButton("정보 수정");
        btnUpdateMem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MemberUpdateFrame.newMemberUpdateFrame(MemberDetailView.this, MemberDetailView.this);;
            }
        });
        btnUpdateMem.setBounds(69, 447, 97, 27);
        contentPane.add(btnUpdateMem);
        btnUpdateMem.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        
        comboBox = new JComboBox();
        comboBox.setBounds(171, 448, 93, 27);
        comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        
        String[] comboBoxItems = { "이름", "지역", "전화번호", "가입일", "생년월일"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        comboBox.setModel(comboBoxModel);
        comboBox.setSelectedIndex(0);
        contentPane.add(comboBox);
        
        textField = new JTextField();
        textField.setBounds(268, 448, 178, 27);
        contentPane.add(textField);
        textField.setToolTipText("입력하세요.");
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setColumns(15);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setBounds(453, 447, 63, 29);
        contentPane.add(btnSearch);
        btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 27, 560, 410);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        JLabel lblNewLabel = new JLabel("회원 명단");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblNewLabel.setBounds(193, 0, 198, 21);
        contentPane.add(lblNewLabel);
    }

    @Override
    public void MemberUpdate() {
        // TODO Auto-generated method stub
        
    }
}
