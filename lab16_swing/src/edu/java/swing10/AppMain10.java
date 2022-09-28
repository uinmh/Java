package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain10 {

    private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};
    
    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lbKorean = new JLabel("국어");
        lbKorean.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lbKorean.setBounds(39, 61, 102, 40);
        frame.getContentPane().add(lbKorean);
        
        JLabel lbEnglish = new JLabel("영어");
        lbEnglish.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lbEnglish.setBounds(39, 111, 102, 40);
        frame.getContentPane().add(lbEnglish);
        
        JLabel lbMath = new JLabel("수학");
        lbMath.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lbMath.setBounds(39, 162, 102, 40);
        frame.getContentPane().add(lbMath);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("굴림", Font.PLAIN, 20));
        textKorean.setBounds(116, 61, 120, 40);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("굴림", Font.PLAIN, 20));
        textEnglish.setColumns(10);
        textEnglish.setBounds(116, 111, 120, 40);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setFont(new Font("굴림", Font.PLAIN, 20));
        textMath.setColumns(10);
        textMath.setBounds(116, 162, 120, 40);
        frame.getContentPane().add(textMath);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    inputScore();
            }
            
        });
        btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btnInput.setBounds(23, 231, 102, 40);
        frame.getContentPane().add(btnInput);
        
        JButton btndelete = new JButton("삭제");
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTable();
            }
        });
        btndelete.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        btndelete.setBounds(153, 231, 102, 40);
        frame.getContentPane().add(btndelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 308, 260, 213);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // JTable(); 생성
        
        model = new DefaultTableModel(null, COLUMN_NAMES); // 컬럼 이름만 갖는 테이블 모델 생성
        
        table.setModel(model); // 테이블 모델을 테이블에 세팅
        
        scrollPane.setViewportView(table);
    }

    private void deleteTable() {
        
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(
                    frame,
                    "입력된 row값이 없습니다.",
                    "삭제 오류",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                index + "번째 행을 정말 삭제 하시겠습니까?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index);
        }

        
    }

    private void inputScore() {
        
        // 3개의 입력받은 JTextField에서 읽은 문자열을 정수(int)로 변환
        int korean = 0;
        int english = 0;
        int math = 0;
        
        try { 
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
                    
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame,
                    "입력 값은 반드시 정수여야 합니다.",
                    "입력 오류",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }finally {
            clearAllTextFields();
        }
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean,english,math);
        
        // 테이블에 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        
        Object[] rowData = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.sum(),
                score.average()
        };
        // row데이터를 table모델에 추가
        
        model.addRow(rowData);
        
    }

    private void clearAllTextFields() {
        
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
}
