package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.awt.event.ActionEvent;

public class BlogDetailFrame extends JFrame {

    public interface OnBlogUpdateListener {
        void onBlogUpdate();
    }
    
    private OnBlogUpdateListener linstener;
    private JPanel contentPane;
    private Component parent;
    private Integer blogNo;
    private BlogDaoImpl dao;
    
    private JTextField textBlogNo;
    private JTextField textTitle;
    private JTextArea textContent;
    private JTextField textAuthor;
    private JTextField textCreatedDate;
    private JTextField textModifiedDate;
    private JScrollPane scrollPane;
    

    /**
     * Launch the application.
     */
    public static void newBlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailFrame frame = new BlogDetailFrame(parent, blogNo, listener);
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
    public BlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        this.parent = parent; // 부모 컴퍼넌트 객체 저장.
        this.blogNo = blogNo; // 상세보기 // 수정할 블로그 글 번호.
        this.dao = BlogDaoImpl.getInstance();
        this.linstener = listener; // 블로그글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
        initialize(); // UI 컴포넌트 생성, 초기화.
    
        initializeBlogData(); // JTextField, JTextArea의 내용을 DB에서 검색한 내용으로 채움.
        
        
        
    }
    
    
    private void initializeBlogData() {
       
      Blog blog = dao.select(blogNo);
      if (blog != null) {
          textBlogNo.setText(blog.getBlogNo().toString());
          textTitle.setText(blog.getTitle());
          textContent.setText(blog.getContent());
          textAuthor.setText(blog.getAuthor());
          textCreatedDate.setText(blog.getCreatedDate().toString());
          textModifiedDate.setText(blog.getModifiedDate().toString());
          
      }
    }

    public void initialize() {
        setTitle("블로그 상세 보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = parent.getX(); // 부모 컴퍼넌트 x좌표
        int y = parent.getY(); // 부모 컴퍼넌트 y좌표
        setBounds(x, y, 450, 1033);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBlogNo = new JLabel("번호");
        lblBlogNo.setFont(new Font("굴림", Font.BOLD, 25));
        lblBlogNo.setBounds(12, 10, 410, 54);
        contentPane.add(lblBlogNo);
        
        textBlogNo = new JTextField();
        textBlogNo.setEditable(false);
        textBlogNo.setFont(new Font("굴림", Font.BOLD, 25));
        textBlogNo.setBounds(12, 62, 410, 42);
        contentPane.add(textBlogNo);
        textBlogNo.setColumns(10);
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
        lblTitle.setBounds(12, 114, 410, 54);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("굴림", Font.BOLD, 25));
        textTitle.setColumns(10);
        textTitle.setBounds(12, 160, 410, 42);
        contentPane.add(textTitle);
        
        JLabel lblContent = new JLabel("내용");
        lblContent.setFont(new Font("굴림", Font.BOLD, 25));
        lblContent.setBounds(12, 212, 410, 54);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 276, 410, 281);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("굴림", Font.PLAIN, 25));
        scrollPane.setViewportView(textContent);
        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("굴림", Font.BOLD, 25));
        lblAuthor.setBounds(12, 567, 410, 54);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setEditable(false);
        textAuthor.setFont(new Font("굴림", Font.BOLD, 25));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 617, 410, 42);
        contentPane.add(textAuthor);
        
        JLabel lblCreatedDate = new JLabel("작성시간");
        lblCreatedDate.setFont(new Font("굴림", Font.BOLD, 25));
        lblCreatedDate.setBounds(12, 669, 410, 54);
        contentPane.add(lblCreatedDate);
        
        textCreatedDate = new JTextField();
        textCreatedDate.setFont(new Font("굴림", Font.BOLD, 25));
        textCreatedDate.setEditable(false);
        textCreatedDate.setColumns(10);
        textCreatedDate.setBounds(12, 724, 410, 42);
        contentPane.add(textCreatedDate);
        
        JLabel lblModifiedDate = new JLabel("최종 업데이트 시간");
        lblModifiedDate.setFont(new Font("굴림", Font.BOLD, 25));
        lblModifiedDate.setBounds(12, 776, 410, 54);
        contentPane.add(lblModifiedDate);
        
        textModifiedDate = new JTextField();
        textModifiedDate.setFont(new Font("굴림", Font.BOLD, 25));
        textModifiedDate.setEditable(false);
        textModifiedDate.setColumns(10);
        textModifiedDate.setBounds(12, 829, 410, 42);
        contentPane.add(textModifiedDate);
        
        JButton btnUpdate = new JButton("수정완료");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBlog();
            }
        });
        btnUpdate.setFont(new Font("굴림", Font.PLAIN, 25));
        btnUpdate.setBounds(130, 909, 158, 46);
        contentPane.add(btnUpdate);
    }

    private void updateBlog() {
        
        
        //수정할 title, content 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        
        if (title.equals("") || content.equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "제목과 내용은 반드시 입력 되어야 합니다", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Blog blog = new Blog(blogNo, title, content, null, null, null);
        
        int result = dao.update(blog);
        
        if (result == 1) {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 성공");
            
            dispose();
            
            linstener.onBlogUpdate();
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 실패"
                    );
        }    
        
    }
}
