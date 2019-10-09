package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	static ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>(); //전역변수 잡으면 안됨
	
	public void menu() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk;
		
		while(true) {
			System.out.println(list);
			
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.끝");
			int input = scan.nextInt();
			
			if(input == 1) {
				sungJuk = (SungJukInput)context.getBean("sungJukInput");
				sungJuk.execute();
			} else if(input == 2) {
				sungJuk = (SungJukOutput)context.getBean("sungJukOutput");
				sungJuk.execute();
			} else if(input == 3) {
				sungJuk = (SungJukModify)context.getBean("sungJukModify");
				sungJuk.execute();
			} else if(input == 4) {
				sungJuk = (SungJukDelete)context.getBean("sungJukDelete");
				sungJuk.execute();
			} else if(input == 5) {
				System.out.println("close");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
		helloSpring.menu();
	}

}
