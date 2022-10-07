package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

public interface BlogDao {

    List<Blog> select(); // SQL_SELECT_ALL
    
    Blog select(Integer blogNo); // SELECT_BY_NO
    
    int insert(Blog blog); // SQL_INSERT
    
    int update(Blog blog); // SQL_UPDATE
    
    int delete(Integer blogNo); // SQL_DELETE
    
}
