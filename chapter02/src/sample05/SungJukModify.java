package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungJukModify implements SungJuk {
	SungJukDTO sungJukDTO;
	
	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukDTO sungJukDTO = (SungJukDTO)context.getBean("sungJukDTO");
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정하고자 하는 이름 입력");
		String name = scan.next();
		
		int sw = 0;
		
		for(int i=0;i<HelloSpring.list.size();i++) {
			if(HelloSpring.list.get(i).getName().equals(name)) {
				System.out.print("이름 입력: ");
				HelloSpring.list.get(i).setName(input.next());
				
				System.out.print("국어 입력: ");
				HelloSpring.list.get(i).setKor(input.nextInt());
				
				System.out.print("영어 입력: ");
				HelloSpring.list.get(i).setEng(input.nextInt());
				
				System.out.print("수학 입력: ");
				HelloSpring.list.get(i).setMath(input.nextInt());
				
				sw++;
			}
		}

		if(sw == 0) {
			System.out.println("수정할 정보가 없습니다.");
		} else {
			System.out.println("수정완료!");
		}
		
	}

	
}
