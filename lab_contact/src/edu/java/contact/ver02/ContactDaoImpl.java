package edu.java.contact.ver02;

public class ContactDaoImpl implements ContactDao{

    public static final int MAX_LENGTH = 3;
    
    private Contact[] contactList = new Contact[MAX_LENGTH];
    
    private int count = 0;
    
    public int getCount() {
        return count;
    }
    
    private static ContactDaoImpl instance = null;
    
    
    private ContactDaoImpl() {
        
    }
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    @Override
    public int creat(Contact m) {
        contactList[count] = m; 
        count++;
        
        if (count > MAX_LENGTH) {
        return 0;
        }
        
        return 1;
    }
    
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < count);
    }

    public boolean isMemoryAvailable() {
        return count < MAX_LENGTH;
    }


    @Override
    public Contact[] read() {
    // contactList에 저장된 Contact 객체의 수만큼 크기 배열을 새로 생성.
    Contact[] contacts = new Contact[count];
    for (int i = 0; i < count; i++) {
        contacts[i] = contactList[i]; //null이 아닌 값들만 복사.
    }
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if (index >= 0 && index < count) {
            return contactList[index];
        }else {
            return null;
        }
    }

    @Override
    public int update(int index, String Name, String phone, String email) {
        if (index >= 0 && index < count) {
        contactList[index].setName(Name);
        contactList[index].setPhone(phone);
        contactList[index].setEmail(email);
        return 1;
        }else {
            return 0;
        }
    }

}
