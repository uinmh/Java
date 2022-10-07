package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;
import static edu.java.ojdbc.model.Blog.Entity.*;


public class BlogDaoImpl implements BlogDao {

    private static BlogDaoImpl instance = null;
    
    private BlogDaoImpl() {}
    
    public static BlogDaoImpl getInstance() {
        
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        return instance;
    }
    
    
    @Override
    public List<Blog> select() {
        
        return null;
    }

    @Override
    public Blog select(Integer blogNo) {
        
        return null;
    }

    @Override
    public int insert(Blog blog) {
        
        return 0;
    }

    @Override
    public int update(Blog blog) {
        
        return 0;
    }

    @Override
    public int delete(Integer blogNo) {
        
        return 0;
    }

}
