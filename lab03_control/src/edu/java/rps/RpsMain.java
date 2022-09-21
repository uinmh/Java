package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

	public static void main(String[] args) {
	
		// 조건문 가위바위보.
		
				Random random = new Random();
				Scanner scanner = new Scanner(System.in);
				
				
				// 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
				System.out.println("가위(0) 바위(1) 보(2) 게임");
				System.out.println("--------------------------");
				System.out.println("--------입력하세요--------");
				System.out.println("--------------------------");
				
				int user = scanner.nextInt();
				int com = random.nextInt(3);
				
				System.out.println("유저 : " + user + " 컴퓨터 : " + com );
								
				if (user == 0 && com == 0) {
					System.out.println("비겼습니다.");
				}else if (user == 0 && com == 1) {
					System.out.println("컴퓨터가 이겼습니다.");			
				}else if (user == 0 && com == 2) {
					System.out.println("유저가 졌습니다");
				}
				
				else if (user == 1 && com == 0) {
					System.out.println("유저가 이겼습니다.");
				}else if (user == 1 && com == 1 ) {
					System.out.println("비겼습니다.");
				}else if (user == 1 && com == 2){
					System.out.println("컴퓨터가 이겼습니다.");
				}
				
				else if (user == 2 && com == 0) {
					System.out.println("컴퓨터가 이겼습니다.");
				}else if (user == 2 && com == 1) {
					System.out.println("유저가 이겼습니다.");
				}else if (user == 2 && com == 2){
					System.out.println("비겼습니다.");
				}
				else {
				    
				}
				
				//==============================================    
				
				if (user == com) {
				    System.out.println("Tie");
				} else if((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
				    //사용자가 이기는 경우
				    System.out.println("User win");
				} else {
				    System.out.println("Computer win");
				}
				
		    //==============================================	

			if (user == 0) {
			     if (com == 0) {
			     System.out.println("tie");
			     } else if (com == 1) {
			     System.out.println("Computer win");
				 } else {
				 System.out.println("User win");
				 }
			     }else if (user == 1){
				 if (com == 0){
				 System.out.println("User win");
				 }
				 else if (com == 1){
				 System.out.println("tie");
				 }
				 else {
				 System.out.println("Computer win");
				 }
				 }
				 else if (user == 2){
				 if (com == 0) {
				 System.out.println("Computer win");
				 }  else if (com == 1) {
				 System.out.println("User win");
				 }
				 else {
				 System.out.println("tie");
				 }
				 }
				 
			//==============================================
			
			        if (user == com) { //비긴경우
				    System.out.println("tie");
				    }else if (user == 0) { // 사용자 - 가위
				    if (com == 1) {// 컴퓨터 - 바위
				    System.out.println("Computer win");
				    }else { // 컴퓨터(2) - 보
				    System.out.println("User win");
	                 }
				    }
				    else if (user == 1) { // 사용자 - 바위
				    if (com == 0) { // 컴퓨터 - 가위
				    System.out.println("User win");
				    }else {// 컴퓨터 (2) - 보
				    System.out.println("Computer win");
				     }
				    }
				   else if (user == 2) { // 사용자 - 보
				   if (com == 0) { // 컴퓨터 가위
				    System.out.println("computer win");
				   }else { // 컴퓨터 바위
				    System.out.println("User win");
				     }
				    }
				
				
	}
}

