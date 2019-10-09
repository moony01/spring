package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungJukInput implements SungJuk {
	SungJukDTO sungJukDTO;
	
	
	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukDTO sungJukDTO = (SungJukDTO)context.getBean("sungJukDTO");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("이름 입력: ");
		sungJukDTO.setName(input.next());
		
		System.out.print("국어 입력: ");
		sungJukDTO.setKor(input.nextInt());
		
		System.out.print("영어 입력: ");
		sungJukDTO.setEng(input.nextInt());
		
		System.out.print("수학 입력: ");
		sungJukDTO.setMath(input.nextInt());
		
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		
		HelloSpring.list.add(sungJukDTO);
	}

}
