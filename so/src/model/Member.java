package model;

import java.sql.Date;


public class Member {

    public interface Entity {
        String TBL_MEMBERLIST = "MEMBERLIST"; // 테이블 이름
        String COL_MEM_ID = "MEM_ID"; // 회원번호
        String COL_MEM_JOINDAY = "MEM_JOINDAY"; // 가입일
        String COL_MEM_BIRTHDAY = "MEM_BIRTHDAY"; // 생년월일
        String COL_MEM_NAME = "MEM_NAME"; // 멤버이름
        String COL_MEM_PHONE = "MEM_PHONE"; // 전화번호
        String COL_MEM_CITY = "MEM_CITY"; // 사는 지역
        String COL_MEM_Q = "MEM_Q"; // 비고
    }
    
    private Integer memberId;
    private Date memJoinDay;
    private Date memBirthDay;
    private String memName;
    private String memPhone;
    private String memCity;
    private String memQ;

    
    public Member(Integer memberId, Date memJoinDay, Date memBirthDay, String memName, String memPhone, String memCity,
            String memQ) {
        this.memberId = memberId;
        this.memJoinDay = memJoinDay;
        this.memBirthDay = memBirthDay;
        this.memName = memName;
        this.memPhone = memPhone;
        this.memCity = memCity;
        this.memQ = memQ;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Date getMemJoinDay() {
        return memJoinDay;
    }

    public Date getMemBirthDay() {
        return memBirthDay;
    }

    public String getMemName() {
        return memName;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public String getMemCity() {
        return memCity;
    }

    public String getMemQ() {
        return memQ;
    }

    @Override
    public String toString() {
        return String.format("Member(MemberId = %d, MemJoinDay = %s, MemBirthDay = %s, MemName = %s, MemPhone = %s, MemCity = %s, MemQ = %s" 
                , memberId,memJoinDay,memBirthDay,memName,memPhone,memCity,memQ);
    }
    

}
