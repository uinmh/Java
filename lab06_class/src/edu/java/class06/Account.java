package edu.java.class06;


/**
 * 은행 계좌 정보 클레스.
 * 계좌번호, 잔액을 필드로 갖고, 입금, 출금,이체 ,정보출력등을 메서드로 갖음.
 */
public class Account {

    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // constructor - argument 2개를 갖는 생성자.
    // 매개변수 = 파라미터
    public Account(int accoutnNo, double balance) {
    this.accountNo = accoutnNo;
    this.balance = balance;
    
    }
    
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액
     * @return 
     */
    public double deposit(double amount) {
        this.balance += amount; 
        return this.balance;
    }
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    
    public double withdraw(double amount) {
        balance -= amount;
        return this.balance;
    }
    /**
     * 이체(transfer)
     * 
     * @param to 이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return 
     */
    
    public boolean transfer(Account ac,double amount) {
        
        // 내 계좌에서는 출금
        this.balance -= amount;
        // 상대방 계좌 에서는 입금
        ac.balance += amount;
        
        return true;
    
//        this.withdraw(amount);
//        ac.deposit(amount);
    }
    
    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    
    public void accountview () {
        System.out.println("계좌번호 : " +  this.accountNo);
        System.out.println("계좌 잔액 : " + this.balance);
    }
    
}
