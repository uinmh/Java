package edu.java.ojdbc.controller;

import static edu.java.ojdbc.model.Blog.Entity.*;
import static edu.java.ojdbc.OracleJdbc.*;

public interface JdbcSql {

    // 전체 검색 - 블로그 글번호 내림 차순 정렬
    String SQL_SELECT_ALL = String.format(
                    "select * from %s order by %s desc",
                    TBL_BLOGS, COL_BLOG_NO);
    // 블로그 글 번호로 검색하기.
    String SQL_SELECT_BY_NO = String.format(
                    "select * from %s where %s = ?",
                    TBL_BLOGS, COL_BLOG_NO);
    
    // 블로그 새 글 저장.
    String SQL_INSERT = String.format(
                    "insert into %s (%s, %s, %s) values (?,?,?)", 
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR);
    
    // 블로그 글 업데이트(수정). 
    String SQL_UPDATE = String.format(
                    "update %s set %s = ?, %s = ?, %s = sydate where %s = ?",
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_MODIFIED_DATE, COL_BLOG_NO);
    // 블로그 글 삭제
    String SQL_DELETE = String.format(
                    "delete from %s where %s = ?",
                    TBL_BLOGS, COL_BLOG_NO);
    
    // 제목/내용/작성자로 검색하기
}
