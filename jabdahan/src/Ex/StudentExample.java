package Ex;

public class StudentExample {

    public static void main(String[] args) {
       
        Student student = new Student("홍길동", "12345-123145", 1);
        
        System.out.println("NAME : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);
    }

}
