package edu.java.swing07;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox comboBox;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 470, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("Arial", Font.PLAIN, 20));
        rbPrivate.setBounds(8, 6, 85, 41);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
               public void actionPerformed(ActionEvent e) {
            printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("Arial", Font.PLAIN, 20));
        rbPackage.setBounds(111, 6, 101, 41);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
            printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("Arial", Font.PLAIN, 20));
        rbProtected.setBounds(232, 6, 112, 41);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("Arial", Font.PLAIN, 20));
        rbPublic.setBounds(361, 6, 85, 41);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCheckBoxStatus(e);
            }
        });
        cbAbstract.setFont(new Font("Arial", Font.PLAIN, 20));
        cbAbstract.setBounds(57, 49, 101, 23);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCheckBoxStatus(e);
            }
        });
        cbFinal.setFont(new Font("Arial", Font.PLAIN, 20));
        cbFinal.setBounds(183, 49, 67, 23);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showCheckBoxStatus(e);
            }
        });
        cbStatic.setFont(new Font("Arial", Font.PLAIN, 20));
        cbStatic.setBounds(292, 49, 101, 23);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnText = (String) comboBox.getSelectedItem();
                textArea.setText(btnText + " ??????");
            }
        });
        comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        final String[] items = {"naver.com","kakao.com","gmail.com","msn.com"}; 
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        comboBox.setBounds(137, 105, 150, 30);
        frame.getContentPane().add(comboBox);
        
        JButton btnShowInfo = new JButton("??????");
        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("?????? ??????", Font.PLAIN, 20));
        btnShowInfo.setBounds(165, 188, 101, 30);
        frame.getContentPane().add(btnShowInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setToolTipText("");
        scrollPane.setBounds(8, 241, 434, 340);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        scrollPane.setViewportView(textArea);
    }

    private void printInfo() {
  
        StringBuilder buffer = new StringBuilder(); // TextArea??? ????????? ???????????? ????????? ?????? ??????
        
        // Radio ????????? ????????? ?????? ????????? ????????? ?????????
        
        if(rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText());
        }else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText());
        }else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText());
        }else if (rbPublic.isSelected()) {
            buffer.append(rbPublic.getText());
        }
        buffer.append(" ????????? ?????? ??????\n");
        
        // ??????????????? ????????? ?????? ?????????????????? ?????? ?????????
        
        if(cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");
        }
        if(cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if(cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");
        }
     
        buffer.append("???????????? ?????? \n");
        
        //ComboBox??? ???????????? ????????? ?????? ????????? ?????????
        
        String item = (String) comboBox.getSelectedItem();
    
        buffer.append(item).append(" ???????????? ????????? ??????\n");
        
        // ????????? ????????? TextArea??? ??????
        
        textArea.setText(buffer.toString());
    }

    private void showCheckBoxStatus(ActionEvent e) {
       JCheckBox checkBox = (JCheckBox)e.getSource();
       String btnText = checkBox.getText();
       boolean selected = checkBox.isSelected();
       textArea.setText(btnText + " : " + selected);
        
    }

    private void printRadioButtonStatus(ActionEvent e) {
        
        JRadioButton radioBtn = (JRadioButton)e.getSource(); // ???????????? ????????? ????????? ??????
        String btnText = radioBtn.getText(); // ????????? ????????? ?????????
        boolean selected = radioBtn.isSelected(); // ????????? ????????? ??????/?????? ??????
        textArea.setText(btnText + " : " + selected);
        
    }
}
