package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyCustomFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void showMycustomFrame(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyCustomFrame frame = new MyCustomFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MyCustomFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
    }

}
