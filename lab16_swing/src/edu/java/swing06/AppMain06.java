package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

    private JFrame frame;
    private JButton btnConfirmDlg;
    private JButton btnOptionDlg;
    private JButton btnInputDlg;
    private JButton btnCustomDlg;
    private JButton btnCustomFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 465, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 클릭시 종료
        frame.getContentPane().setLayout(null);
        
        JButton btnMsgDlg = new JButton("Message Dialog");
        btnMsgDlg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                JOptionPane.showMessageDialog(frame, "안녕하세요.");
                                        // 어떤 프레임위에 보일지 , 메시지 설정
                JOptionPane.showMessageDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트 
                        "안녕하세요", // 다이얼로그의 표시된 메시지
                        "메시지", // 다이얼로그의 타이틀
                        JOptionPane.WARNING_MESSAGE,
                        null); // 메시지 타입 (아이콘)
                        
                
            }
        });
        btnMsgDlg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnMsgDlg.setBounds(12, 10, 425, 60);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        btnConfirmDlg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
//               int result =  JOptionPane.showConfirmDialog(frame, "삭제할까요?");
           int result = JOptionPane.showConfirmDialog(
                   frame, // 다이얼로그가 실행될 부모 컴포넌트
                   "선택한 파일을 삭제할까요?", // 다이얼로그의 메시지
                   "삭제 확인", // 다이얼로그 제목 표시줄(타이틀)
                   JOptionPane.YES_NO_OPTION, // 확인 옵션 (YES = NO , YES - NO - CANCEL,.....)
                   JOptionPane.QUESTION_MESSAGE, // 메시지 타입 (-> 아이콘을 자동으로 설정)
                   null
                   ); // 아이콘
                    // ShowConfirmDialog의 리턴값 : yes = 0 , no = 1 , Cancel= 2 , x(종료) = -1
                   btnConfirmDlg.setText("Confirm = " + result);
            }
        }
        
        );
        
        btnConfirmDlg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnConfirmDlg.setBounds(12, 80, 425, 60);
        frame.getContentPane().add(btnConfirmDlg);
        
        
        
        btnOptionDlg = new JButton("Option Dialog");
        btnOptionDlg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"아니요","어려워요","재미있어요"};
              int result = JOptionPane.showOptionDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "Swing GUI 재미있나요?", // 다이얼로그의 메시지
                        "확인", // 다이얼로그의 타이틀
                        JOptionPane.YES_NO_CANCEL_OPTION, // 다이얼로그의 옵션 타입 (yes - no , yes - no - cancel...)
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입(Question, Information, ...)
                        null, // 아이콘
                        options, // 옵션 버튼에서 사용할 문자열 배열
                        options[2] // 다이얼로그가 실행될 때 포커스를 받는 버튼 옵션
                        );
                btnOptionDlg.setText("Result = " + result);
            }
        });
        btnOptionDlg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnOptionDlg.setBounds(12, 150, 425, 60);
        frame.getContentPane().add(btnOptionDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        btnInputDlg.addActionListener(new ActionListener() {
          
            // 문자열을 입력받아서 입력받은 값을 리턴해주는 기능.
            @Override
            public void actionPerformed(ActionEvent e) {
//                String input = JOptionPane.showInputDialog("이름?");
                // -> OK 버튼을 클릭하면 입력한 내용이 리턴, Cancel을 클릭하면 빈 문자열을 리턴.
//               String input = JOptionPane.showInputDialog(frame, "이름");
                Object[] selectionValues = {"10대","20대","30대","40대"};
                
                Object input = JOptionPane.showInputDialog(
                    frame, // 부모 컴포넌트
                    "나이?",// 메시지
                    "확인", // 타이틀
                    JOptionPane.QUESTION_MESSAGE, // 메시지타입
                    null, //아이콘
                    selectionValues,// 선택값들의 배열
                    selectionValues[1] // 선택 값들 중에서 포커스를 받는 컴포넌트
                    );
                btnInputDlg.setText("입력 = " + input);
            }
        });
        btnInputDlg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnInputDlg.setBounds(12, 220, 425, 60);
        frame.getContentPane().add(btnInputDlg);
        
        btnCustomDlg = new JButton("Custom Dialog");
        btnCustomDlg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
                MyCustomDialog.showMyCustomDialog(null);
            
                
            }
        });
        btnCustomDlg.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnCustomDlg.setBounds(12, 290, 425, 60);
        frame.getContentPane().add(btnCustomDlg);
        
        btnCustomFrame = new JButton("Custom Frame");
        btnCustomFrame.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomFrame.showMycustomFrame(null);
            }
        });
        btnCustomFrame.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnCustomFrame.setBounds(12, 360, 425, 60);
        frame.getContentPane().add(btnCustomFrame);
    }
}
