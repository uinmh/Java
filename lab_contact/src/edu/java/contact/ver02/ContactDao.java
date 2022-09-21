package edu.java.contact.ver02;

public interface ContactDao {

    int creat(Contact m);

    Contact[] read();
    
    
    Contact read(int index);
    
//    int update(int index, Contact c);
    int update(int index, String Name, String phone, String email);
    
}
