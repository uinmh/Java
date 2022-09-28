package edu.java.swing05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private Component lblImage;
    int i = 0;
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
        
        

        ArrayList<String> images = new ArrayList<>(Arrays.asList(
                "images/flower1.jpg","images/flower2.jpg"
                ,"images/flower3.jpg","images/flower4.jpg"
                ,"images/flower5.jpg"));
        
        JLabel lblImage = new JLabel(new ImageIcon(images.get(i)));
        
        
        lblImage.setBounds(12, 10, 584, 566);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    i += 1;
                    ImageIcon test  = new ImageIcon(images.get(i));
                    lblImage.setIcon(test);
                    } catch (IndexOutOfBoundsException e1) {
                        i = 0;
                        ImageIcon test  = new ImageIcon(images.get(i));
                        lblImage.setIcon(test);
                    }
                
            
            }
        });
        btnPrev.setBounds(99, 640, 97, 23);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
                try {
                    i -= 1;
                    ImageIcon test  = new ImageIcon(images.get(i));
                    lblImage.setIcon(test);
                    } catch (IndexOutOfBoundsException e1) {
                        i = 4;
                        ImageIcon test  = new ImageIcon(images.get(i));
                        lblImage.setIcon(test);
                    }
                
                
            }
        });
        btnNext.setBounds(399, 640, 97, 23);
        frame.getContentPane().add(btnNext);
    }
}
