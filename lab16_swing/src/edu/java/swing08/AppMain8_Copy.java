package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain8_Copy {

    private JFrame frame;
    private JButton btnDelete;
    private JButton btnInput;
    private JList<String> list;
    private JScrollPane scrollPane;
    private JTextField textField;
    
    //JList의 원소들을 관리하는 객체
    //JList에 새로운 원소 추가, 원소 삭제, 선택된 원소에 대한 정보, .....
    private DefaultListModel<String> listmodel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain8_Copy window = new AppMain8_Copy();
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
    public AppMain8_Copy() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 455, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        textField.setBounds(12, 22, 212, 59);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addItemToList();

            }
        });
        btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        btnInput.setBounds(269, 22, 124, 23);
        frame.getContentPane().add(btnInput);

        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletelist();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        btnDelete.setBounds(269, 58, 124, 23);
        frame.getContentPane().add(btnDelete);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 121, 415, 444);
        frame.getContentPane().add(scrollPane);

        list = new JList<>(); // JList 객체 생성
        listmodel = new DefaultListModel<>(); // JList의 원소들을 관리하는 ListModel 객체를 생성.
        list.setModel(listmodel); // JList에 ListModel을 설정.
        list.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        scrollPane.setViewportView(list);
    }

    protected void addItemToList() {
        
        // JTextField에 입력된 내용을 읽음.
        String input = textField.getText();
        
        //JTextFeild에 입력된 내용이 없는 경우 getText() 메서드는 빈 문자열("")을 리턴!
        
        if(input.equals("")) {
            JOptionPane.showMessageDialog(frame, 
                    "입력된 내용이 없습니다.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return; // 배열이 생성되지 않게 리턴. addItemToList 종료..
        }
        // 리스트에 새로운 원소를 추가
        listmodel.addElement(input);
     
        // JTextField를 초기화 - 입력된 내용 지우기.
        textField.setText("");
    }

    private void deletelist() {
        
        //JList에서 선택된 원소의 인덱스를 찾음.        
        
        int index = list.getSelectedIndex();
        
        if (index == -1) { // JList에서 선택된 원소가 없을때
            JOptionPane.showMessageDialog(frame,
                    "리스트에서 삭제할 원소를 반드시 선택해주세요.",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // 사용자에게 삭제 여부를 다시한번 확인
        
        int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?","삭제 확인",JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) { // 다이얼로그에서 Yes를 클릭했을때 
         // DefaultListModel에서 특정 인덱스의 원소를 삭제하면 JList에서 그 원소가 자동으로 삭제
            listmodel.remove(index);   
        }
    }
}


