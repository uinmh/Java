package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        // Account 타입 변수 선언, Account 객체 생성
        Account ac = new Account(12345, 5000);
        System.out.println(ac);
        System.out.println("계좌번호 : " + ac.accountNo);
        System.out.println("입금액 : " + ac.deposit(10000));
        System.out.println("출금후 잔액 : " + ac.withdraw(2000));
        System.out.println("잔고 : " + ac.balance);
        
        Account ac1 = new Account(56789, 5000);
        System.out.println(ac.transfer(ac1,1000));
        System.out.println();
        ac.accountview();
        ac1.accountview();
        
        
        System.out.println("====================================");

        Account account1 = new Account(123456, 10000);
        System.err.println(account1);
        
        account1.accountview(); // 계좌 정보 출력
        
        double money = account1.deposit(1000); // 입금
        System.out.println(money); // 입금후출력 
        account1.accountview();
        
        money = account1.withdraw(5000); // 출금
        System.out.println(money);
        
        // 이체할 계좌 생성
        Account account2 = new Account(456789, 1000);
        account2.accountview();
        
        // account 1번에서 2번으로 5천원 2체
        
        account1.transfer(account2, 5000);
        account1.accountview();
        account2.accountview();
        
    }

}
