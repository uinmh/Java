package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.model.Blog;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogCreateFrame extends JFrame {

	   @FunctionalInterface
	    public interface BlogInsertListener {
	        void BlogInsertNotify(Blog blog);
	    }
	private BlogInsertListener listener;
	private Component parent;
	private JFrame frame;

    private JPanel contentPane;
    private JTextArea textTitle;
    private JTextArea textContent;
    private JTextArea textAuthor;
	
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
        setTitle("새 글 추가"); 
        
    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
   
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 497, 533);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		textTitle = new JTextArea();
		textTitle.setFont(new Font("굴림", Font.PLAIN, 32));
		textTitle.setBounds(93, 55, 284, 54);
		contentPane.add(textTitle);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("굴림", Font.PLAIN, 32));
		textContent.setBounds(93, 159, 284, 54);
		contentPane.add(textContent);
		
		textAuthor = new JTextArea();
		textAuthor.setFont(new Font("굴림", Font.PLAIN, 32));
		textAuthor.setBounds(93, 252, 284, 54);
		contentPane.add(textAuthor);
		
		JButton btnConfirm = new JButton("저장");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewBlog();
			}
		});
		btnConfirm.setFont(new Font("굴림", Font.PLAIN, 20));
		btnConfirm.setBounds(93, 349, 103, 54);
		contentPane.add(btnConfirm);
		
		JLabel lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lblTitle.setBounds(12, 55, 71, 54);
		contentPane.add(lblTitle);
		
		JLabel lblContent = new JLabel("내용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("굴림", Font.PLAIN, 20));
		lblContent.setBounds(12, 159, 69, 54);
		contentPane.add(lblContent);
		
		JLabel lblAutor = new JLabel("작성자");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("굴림", Font.PLAIN, 20));
		lblAutor.setBounds(12, 252, 69, 54);
		contentPane.add(lblAutor);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 20));
		btnCancel.setBounds(274, 349, 103, 54);
		contentPane.add(btnCancel);
	}

	private void createNewBlog() {
		
		String Title = textTitle.getText();
        String Content = textContent.getText();
        String Autor = textAuthor.getText();
		
        Blog blog = new Blog(null, Title, Content, Autor, null, null) ;
        
        dispose();
        
        listener.BlogInsertNotify(blog);
		
	}
}
