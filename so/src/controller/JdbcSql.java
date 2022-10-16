package controller;
import static model.Member.Entity.*;
public interface JdbcSql {
    // 문자열 포맷 : %s - 문자열, %d - 정수, %f - 실수

    // 전체 검색 - 회원정보 내림차순 정렬
    String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc",
                    TBL_MEMBERLIST, COL_MEM_ID);
//  [회원관리] 회원 번호로 검색하기.
    String SQL_SELECT_BY_ID = String.format(
                    "select * from %s where %s = ?",
                    TBL_MEMBERLIST, COL_MEM_ID);

//  신규 멤버 저장.
    String SQL_INSERT = String.format(
                    "insert into %s (%s, %s, %s, %s, %s, %s) values (?,?,?,?,?,sysdate)", 
                    TBL_MEMBERLIST, COL_MEM_NAME, COL_MEM_CITY, COL_MEM_PHONE, COL_MEM_BIRTHDAY, COL_MEM_Q, COL_MEM_JOINDAY);
    
//  글 업데이트(수정). 
    String SQL_UPDATE = String.format(
                    "update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? where %s = ?",
                    TBL_MEMBERLIST, COL_MEM_JOINDAY, COL_MEM_BIRTHDAY, COL_MEM_NAME,COL_MEM_PHONE,COL_MEM_CITY,COL_MEM_Q,COL_MEM_ID);
//  멤버 삭제
    String SQL_DELETE = String.format(
                    "delete from %s where %s = ?",
                    TBL_MEMBERLIST, COL_MEM_ID);
    
//  이름으로 검색하기
    String SQL_SELECT_BY_NAME = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_MEMBERLIST, COL_MEM_NAME, COL_MEM_ID);
//  지역으로 검색하기
    String SQL_SELECT_BY_CITY = String.format(
            "select * from %s where lower(%s) like ? order by %s desc",
            TBL_MEMBERLIST, COL_MEM_CITY, COL_MEM_ID);
//  전화번호로 검색하기
 String SQL_SELECT_BY_PHONE = String.format(
         "select * from %s where lower(%s) like ? order by %s desc",
         TBL_MEMBERLIST, COL_MEM_PHONE, COL_MEM_ID);    
//  가입일로 검색하기
String SQL_SELECT_BY_JOINDAY = String.format(
        
   TBL_MEMBERLIST, COL_MEM_JOINDAY,COL_MEM_ID);    
    
//가입일로 검색하기
String SQL_SELECT_BY_BIRTHDAY = String.format(
    "select * from %s where to_char(%s, 'YYYY-MM-DD') = ? order by %s",
TBL_MEMBERLIST, COL_MEM_BIRTHDAY,COL_MEM_ID);    
//===========================================================================

//게시물 등록번호 내림차순 정렬
String SQL_SELECT_BY_NOTICE = String.format(
        "select * from %s order by %s desc",
             TBL_MEMBER_NOTICE,COL_NOTICE_NO);

//[회원관리] 회원 번호로 검색하기.
String SQL_SELECT_BY_NOTICE_NO = String.format(
                "select * from %s where %s = ?",
                TBL_MEMBER_NOTICE, COL_NOTICE_NO);






}
