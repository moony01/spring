package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Scope("prototype")
@Component
@ComponentScan("com.conf")
public class SungJukInput implements SungJuk {
	//@Autowired
	//private ArrayList<SungJukDTO2> list;
	
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
		
	@Autowired
	private SungJukDTO2 sungJukDTO2;
	
	@Override
	public void execute() {
		System.out.println();
		
		//데이터 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		int tot = kor + eng + math;
		double avg = tot / 3.0;
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		list.add(sungJukDTO2);
					
		System.out.println("총 "+list.size()+"개의 데이터가 저장되어 있습니다");
	}

}








