package edu.java.contact.ver06;

import static edu.java.contact.ver06.Contact.Entity.*;
import static edu.java.contact.ver06.OracleConnection.*;

public interface ContactSql {

    
    // ContactDao.read() 메서드에서 사용할 sql문장
    // select * from CONTACTS order by NAME
    String SQL_READ_ALL = String.format(
            "select * from %s order by %s", 
            TBL_CONTACTS, COL_NAME);
    
    // ContactDao.read(Integer cid) 메서드에서 사용할 sql
    // select * from CONTACTS where CID = ?
    String SQL_READ_BY_ID = String.format(
            "select * from %s where %s = ?", 
            TBL_CONTACTS, COL_CID);
    
    // ContactDao.create(Contact contact) 메서드에서 사용할 SQL
    
    String SQL_INSERT = String.format(
            "insert into %s (%s, %s, %s) values (?, ?, ?)", 
            TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL);
    
    // ContactDAO.update(Contact contact) 메서드에서 사용할 SQL
    String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ? where %s = ?",
            TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL, COL_CID);
    // ContactDAO.delete(Integer cid) 메서드에서 사용할 SQL
    // delete from CONTACTS where CID = ?
    
    String SQL_DELETE = String.format(
            "delete from %s where %s = ?",
            TBL_CONTACTS, COL_CID);
    
}
