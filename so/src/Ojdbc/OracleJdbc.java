package Ojdbc;

public interface OracleJdbc {

    // Oracle DB에 접속하는 주소(, 포트번호, SID)
    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
                                // 아이피주소 : 포트번호 : sid
    
    // Oracle DB에 접속하는 사용자 계정
    String USER = "scott";
    
    // Oracle DB에 접속하는 사용자 비밀번호
    
    String PASSWORD = "tiger";
}
