package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

public class ContectDaoImpl implements ContectDao {

    private ArrayList<Contact> cont = new ArrayList<>(); // 연락처 정보를 저장할 List

    private static ContectDaoImpl instance = null; // singleton 인스턴스 생성

    private ContectDaoImpl() { // 생성자는 반드시 private

    }

    public static ContectDaoImpl getInstance() {

        if (instance == null) {
            instance = new ContectDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Contact> read() {

        return cont;
    }

    @Override
    public Contact read(int index) {

        if (index >= 0 && index < cont.size()) {
            return cont.get(index);
        } else {
            return null;
        }

    }

    @Override
    public int create(Contact c) {
        cont.add(c);
        return 1;
    }

    @Override
    public int update(int index, Contact contact) {
        cont.remove(index);
        cont.add(contact);
        return 1;
    }
//    if (!isValidIndex(index)) {
//        return 0;
//    }
//    Contacts.set(index, contact);
//    Contact c = contacts.get(index);
//    c.setName(contact.getName());
//    c.setPhone(contact.getPhone());
//    c.setEmail(contact.getEmail());
//
//    return 1;
    
    
    @Override
    public int delete(int index) {

        cont.remove(index);

        return 1;
    }

}
