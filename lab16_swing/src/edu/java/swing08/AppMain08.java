package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

    private JFrame frame;
    private JButton btnDelete;
    private JButton btnInput;
    private JList<String> list;
    private JScrollPane scrollPane;
    private JTextField textField;
    private DefaultListModel<String> listmodel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
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

                inputlist();

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

        list = new JList<>();
        listmodel = new DefaultListModel<>();
        list.setModel(listmodel);
        list.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        scrollPane.setViewportView(list);
    }

    private void deletelist() {
        
        try {
        int index = list.getSelectedIndex();
        listmodel.remove(index);
        if (index == listmodel.getSize()) {
            index--;
        }
        list.setSelectedIndex(index);

    }catch (Exception e) {
        textField.setText("<<데이터 없음>>");
    }
}

    private void inputlist() {
        String s = textField.getText();

        listmodel.addElement(s);
    }
}
