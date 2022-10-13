package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BlogCreateFrame extends JFrame {

	   @FunctionalInterface
	    public interface BlogInsertListener {
	        void BlogInsertNotify(Blog blog);
	    }
	private BlogInsertListener listener;
	private Component parent; // 부모 컴퍼넌트를 저장하기위한 필드.

    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textAuthor;
    private JScrollPane scrollPane;
    private JTextArea textContent;
	private BlogDaoImpl dao; // DB테이블 insert 기능을 가지고 있는 객체.
	
	/**
	 * Launch the application.
	 */
	public static void  newBlogCreateFrame(Component parent, BlogInsertListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent, listener);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BlogCreateFrame(Component parent, BlogInsertListener listener) {
		this.parent = parent; 
		this.listener = listener;
		this.dao = BlogDaoImpl.getInstance();
		initialize(); // UI 컴포넌트들(JLabel, JTextField, JTextArea, ...) 이 생성 초기화.
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
        setTitle("새 블로그 글 작성");  // JFrame의 타이틀
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // JFrame의 닫기 버튼 동작 - 현재 창 닫기.
   
        int x = parent.getX(); // 부모 창의 x 좌표
        int y = parent.getY(); // 부모 창의 y 좌표
        setBounds(x, y, 500, 735);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JButton btnConfirm = new JButton("작성");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewBlogPost();
			}
		});
		btnConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnConfirm.setBounds(93, 520, 103, 54);
		contentPane.add(btnConfirm);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTitle.setBounds(12, 55, 71, 54);
		contentPane.add(lblTitle);
		
		JLabel lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblContent.setBounds(12, 221, 69, 54);
		contentPane.add(lblContent);
		
		JLabel lblAutor = new JLabel("작성자");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblAutor.setBounds(12, 429, 69, 54);
		contentPane.add(lblAutor);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnCancel.setBounds(334, 520, 103, 54);
		contentPane.add(btnCancel);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("굴림", Font.PLAIN, 25));
		textTitle.setBounds(93, 64, 344, 37);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("굴림", Font.PLAIN, 25));
		textAuthor.setBounds(93, 440, 344, 37);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 127, 346, 292);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("굴림", Font.PLAIN, 25));
		scrollPane.setViewportView(textContent);
	}

	private void createNewBlogPost() {
		
		String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();

        if (title.equals("") || content.equals("") || author.equals("")){
            JOptionPane.showMessageDialog(
                    this, // parentComponent -> BlogCreateFrame의 인스턴스 주소
                    "제목 내용 작성자는 반드시 입력 되어야 합니다!", // 메세지
                    "ERROR", // 타이틀
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 제목, 내용, 작성자 -> Blog 객체 생성
        		
        Blog blog = new Blog(null, title, content, author, null, null);        
        
        // dao의 insert 메서드를 호출
        
        int result = dao.insert(blog);
        if (result == 1) { // insert 성공
          JOptionPane.showMessageDialog(this, blog.getTitle() + " 글이 추가됐습니다.");
          dispose();
          listener.BlogInsertNotify(blog);
        } else { // insert 실패
          JOptionPane.showMessageDialog(this, 
                  "작성 할수 없습니다.",
                  "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
		
	}
}
