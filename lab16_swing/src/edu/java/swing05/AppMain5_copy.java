package edu.java.swing05;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain5_copy {
    // 이미지 파일들의 경로를 저장한 (문자열) 배열.
    private static final String[] IMAGES= {
            "images/flower1.jpg",
            "images/flower2.jpg",
            "images/flower3.jpg",
            "images/flower4.jpg",
            "images/flower5.jpg"      
    };
    private int index; 
    private JFrame frame;
    private JLabel lblImage;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain5_copy window = new AppMain5_copy();
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
    public AppMain5_copy() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 624, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [닫기] 버튼 클릭 동작 -> 현재 다이얼로그만 종료.
        frame.getContentPane().setLayout(null);
                
        lblImage = new JLabel(new ImageIcon(IMAGES[index]));
       
        
        lblImage.setBounds(12, 10, 584, 566);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // 자바 가상머신이 
                showPrevImage();   // 내부 클래스에서는 외부 클래스 매서드도 사용 가능.
            }
        });
        btnPrev.setBounds(99, 640, 97, 23);
        frame.getContentPane().add(btnPrev);
        
        
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        btnNext.setBounds(399, 640, 97, 23);
        frame.getContentPane().add(btnNext);
    }

    protected void showPrevImage() {
        // 현재 보여지는 이미지가 첫번째 이미지가 아니면 인덱스 1 감소 -> 새로운 이미지를 보여줌.
        // 현재 보여지는 이미지가 첫번째 이미지면 마지막 이미지를 보여줌.
        if (index > 0) {
            index--;
        }else {
            index = IMAGES.length - 1;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[index]));
        
    }

    private void showNextImage() {
        // 현재 보여지는 이미지의 인덱스를 1증가 -> 새로운 이미지를 보여줌.
//        ImageIcon sc = new ImageIcon(IMAGES[index]);
        if (index < IMAGES.length - 1) {
            index++;
        }else {
            index = 0;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[index]));
        // 현재 보여지는 이미지가 가장 마지막 이미지이면 첫번째 이미지를 보여줌.
    }
}
