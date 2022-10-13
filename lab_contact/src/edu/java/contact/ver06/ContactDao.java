package edu.java.contact.ver06;

import java.util.List;

// CRUD Create(insert),Read(Select),Update,Delete를 담당하는 컨트롤러
public interface ContactDao {

    List<Contact> select();
    Contact select(Integer cid); //연락처 테이블의 고유키로 (pk)로 검색
    int insert(Contact contact); // insert 문장 실행
    int update(Contact contact); // update 문장 실행
    int delete(Integer cid); // delete 문장

}
