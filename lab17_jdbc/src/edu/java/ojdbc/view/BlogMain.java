package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import edu.java.ojdbc.view.BlogCreateFrame.BlogInsertListener;
import edu.java.ojdbc.view.BlogDetailFrame.OnBlogUpdateListener;
import static edu.java.ojdbc.controller.JdbcSql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;


public class BlogMain
	implements BlogInsertListener, OnBlogUpdateListener{
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES= {
            COL_BLOG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE
    };
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboBox;
    private BlogDaoImpl dao; 
    private JTextField textKeyword;

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() { // UI 컴포넌트 생성, 초기화
        initialize();
        dao = BlogDaoImpl.getInstance();
        initializeTable(); // 메인 화면에서의 JTable 데이터 초기화
    
    }

    private void initializeTable() {
        // 데이터 없는 컬럼 이름들만 설정된 테이블 모델 객체를 생성. - 데이터 초기화
        model = new DefaultTableModel(null, COLUMN_NAMES);
       
        // 테이블에 모듈객체를 설정
        table.setModel(model);
        // db에서 데이터 검색
        List<Blog> list = dao.select();
        // 오브젝트 2차원 배열을 만들면됨.
        for (Blog b : list) {
            Object[] row = {
                    b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()
                    
            };
            model.addRow(row);
        }
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("블로그");
        frame.setBounds(100, 100, 745, 622);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 글 작성");
        btnCreate.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	    // 새 블로그 글 작성 Frame 만들기
        		BlogCreateFrame.newBlogCreateFrame(frame, BlogMain.this); // 그냥 this는 익명클래스를 뜻하므로 사용해선 안됨.
        		
        	}
        });
        
        JButton btnReadAll = new JButton("전체 보기");
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        btnReadAll.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnReadAll);
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnCreate);
        
        JButton btnDetail = new JButton("상세보기");
        btnDetail.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	    showDetailFrame();
        	}
        });
        btnDetail.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnDetail);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            	deleteBlog();            	   
            	}catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame,
                            "삭제할 행을 먼저 선택 하세요.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);	
            	}
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JPanel searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.SOUTH);
        
        comboBox = new JComboBox<>();
        String[] comboBoxItems = {"제목","내용","제목 + 내용", "작성자"};
        DefaultComboBoxModel<String> comboBoxModel= new DefaultComboBoxModel<>(comboBoxItems);
        comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        comboBox.setModel(comboBoxModel);
        comboBox.setSelectedIndex(0);
        searchPanel.add(comboBox);
        
        textKeyword = new JTextField();
        searchPanel.add(textKeyword);
        textKeyword.setColumns(10);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBlogsByKeyword();
            }
        });
        btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        searchPanel.add(btnSearch);
    }



	private void searchBlogsByKeyword() {
        
	    String keyword = textKeyword.getText();
	    if (keyword.equals("")) { // 검색어 JTextField가 비어있으면
	        JOptionPane.showMessageDialog(
	                frame, // parent Component
	                "검색어를 입력하세요.", // message
	                "Warning", // title 
	                JOptionPane.WARNING_MESSAGE); // messageType	        
	        
	        return;
	    }
	           
	    
	   int type = comboBox.getSelectedIndex();
	   System.out.println("type = " + type + "keyword = " + keyword);
	   
	   // TODO : DAO에 검색 타입과 검색어를 argument로 갖는 검색 메서드 호출.
	   
	   List<Blog> list = dao.select(type, keyword);
	   
	   model = new DefaultTableModel(null, COLUMN_NAMES);
	   table.setModel(model);
	   for (Blog b : list) {
	       Object[] row = {b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()
	               };
	       model.addRow(row);
	   }
        
    }

    private void showDetailFrame() {
       int row = table.getSelectedRow();
       if(row == -1) {
           JOptionPane.showMessageDialog(frame,
                   "테이블의 행을 먼저 선택하세요",
                   "Error",
                   JOptionPane.ERROR_MESSAGE); //
                   
           return;
        
       }
       Integer blogNo = (Integer)model.getValueAt(row, 0); 
       System.out.println("blogNo = " + blogNo);
       
       BlogDetailFrame.newBlogDetailFrame(frame, blogNo, BlogMain.this); // 여기서 BlogMain.this = this 와 같음.
    }

    private void deleteBlog() {
        
    	int row = table.getSelectedRow(); // 테이블에서 선택된 행, 인덱스
    	
    	//선택된 행에서 인덱스 0번 컬럼의 값 (BLOG_NO)를 읽음.
    	Integer blogNo = (Integer)model.getValueAt(row, 0);
    	
        int confirm = JOptionPane.showConfirmDialog(frame,
                blogNo + "번 글을 삭제 하시겠습니까",
                "삭제 확인",
                JOptionPane.YES_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(blogNo);
        }else {
            return;
        }
        
        // 테이블 갱신
        model.removeRow(row);
        
        JOptionPane.showMessageDialog(frame, "삭제 완료!");
        
        
    }

	@Override
	public void BlogInsertNotify(Blog blog) {
	    initializeTable();
	}

    @Override
    public void onBlogUpdate() {
        initializeTable();
    }




}