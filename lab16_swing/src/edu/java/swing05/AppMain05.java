package edu.java.swing05;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private Component lblImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 624, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblImage = new JLabel(new ImageIcon("images/flower1.jpg"));
        JLabel lblImage1 = new JLabel(new ImageIcon("images/flower2.jpg"));
        JLabel lblImage2 = new JLabel(new ImageIcon("images/flower3.jpg"));
        JLabel lblImage3 = new JLabel(new ImageIcon("images/flower4.jpg"));
        JLabel lblImage4 = new JLabel(new ImageIcon("images/flower5.jpg"));
        lblImage.setBounds(12, 10, 584, 566);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                frame.getContentPane().add(lblImage4);
                
            
            }
        });
        btnPrev.setBounds(99, 640, 97, 23);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                
            }
        });
        btnNext.setBounds(399, 640, 97, 23);
        frame.getContentPane().add(btnNext);
    }
}
