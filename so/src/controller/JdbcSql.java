package controller;

import static model.Member.Entity.*;


public interface JdbcSql {
    // 문자열 포맷 : %s - 문자열, %d - 정수, %f - 실수

    // 전체 검색 - 회원정보 오름차순 정렬
    String SQL_SELECT = String.format(
            "select * from %s order by %s desc",
                    TBL_MEMBERLIST, COL_MEM_ID);
//    // 블로그 글 번호로 검색하기.
//    String SQL_SELECT_BY_NO = String.format(
//                    "select * from %s where %s = ?",
//                    TBL_BLOGS, COL_BLOG_NO);
//    
//    // 블로그 새 글 저장.
//    String SQL_INSERT = String.format(
//                    "insert into %s (%s, %s, %s) values (?,?,?)", 
//                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR);
//    
    // 블로그 글 업데이트(수정). 
    String SQL_UPDATE = String.format(
                    "update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, where %s = ?",
                    TBL_MEMBERLIST, COL_MEM_JOINDAY, COL_MEM_BIRTHDAY,COL_MEM_NAME,COL_MEM_PHONE,COL_MEM_CITY,COL_MEM_Q);
//    // 블로그 글 삭제
//    String SQL_DELETE = String.format(
//                    "delete from %s where %s = ?",
//                    TBL_BLOGS, COL_BLOG_NO);
//    
//    // 제목으로 검색하기
//    String SQL_SELECT_BY_TITLE = String.format(
//            "select * from %s where lower(%s) like ? order by %s desc",
//            TBL_BLOGS, COL_TITLE, COL_BLOG_NO);
//    // 내용으로 검색하기
//    String SQL_SELECT_BY_CONTENT = String.format(
//            "select * from %s where lower(%s) like ? order by %s desc",
//            TBL_BLOGS, COL_CONTENT, COL_BLOG_NO);
//    
//    // 제목 또는 내용으로 검색하기
//    String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
//            "select * from %s where lower(%s) like ? or lower(%s) like ? order by %s desc",
//            TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_BLOG_NO);
//    
//    // 작성자로 검색하기
//    String SQL_SELECT_BY_AUTHOR = String.format(
//            "select * from %s where lower(%s) like ? order by %s desc",
//            TBL_BLOGS, COL_AUTHOR,COL_BLOG_NO);
            
}
