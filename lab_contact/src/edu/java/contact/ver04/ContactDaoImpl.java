package edu.java.contact.ver04;

import java.io.File;
import java.util.List;

// 패키지의 클래스가 가지고 있는 static으로 선언된 모든 멤버(필드, 메서드) 이름을 import
import static edu.java.contact.fileutil.FileUtil.*;

public class ContactDaoImpl implements ContactDao {

    private List<Contact> contacts; // 연락처 데이터
    private File dataDir; // 데이터 파일을 저장하는 폴더
    private File dataFile; // 연락처 데이터 파일

    // singleton
    private static ContactDaoImpl instance = null;

    private ContactDaoImpl() {
        dataDir = initDataDir(); // 데이터 폴더 초기화
        dataFile = new File(DATA_DIR, DATA_FILE); // 데이터 파일 객체
        contacts = initData(); // 데이터 초기화
    }

    public static ContactDaoImpl getInstance() {

        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Contact> read() {

        return contacts;
    }

    @Override
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }

    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact);
        // 새로운 데이터가 추가 된 후 메모리와 파일을 동기화 하기 위해서 파일 데이터를 저장.
        writeDataToFile(contacts, dataFile);
        return 1;
    }

    @Override
    public int update(int index, Contact contact) {

        if (!isValidIndex(index)) {
            return 0;
        }
        contacts.set(index, contact);
//        contacts.get(index).setName(contact.getName());
//        contacts.get(index).setPhone(contact.getPhone());
//        contacts.get(index).setEmail(contact.getEmail());
        //변경된 연락처 정보를 파일에 작성
        writeDataToFile(contacts, dataFile);
        
        return 1;
    }

    @Override
    public int delete(int index) {
        if(!isValidIndex(index)) {
            return 0;
        }
        contacts.remove(index); //리스트에서 해당 인덱스에 원소를 삭제.
        writeDataToFile(contacts, dataFile); // 변경된 데이터를 파일에 저장.
        return 1;
    }

    public boolean isValidIndex(int index) {

        return ((index >= 0) && (index < contacts.size()));
    }

}
