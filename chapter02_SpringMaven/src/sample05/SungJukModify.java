package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukModify implements SungJuk {
	//@Autowired
	//private ArrayList<SungJukDTO2> list;
	
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름을 입력하세요 : ");
		String name = scan.next();
		
		int sw=0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				System.out.println(sungJukDTO2);
				sw=1;
				
				System.out.println();
				System.out.println(name + "님의 데이터 수정을 시작합니다...");			
				System.out.print("국어 입력 : ");
				sungJukDTO2.setKor(scan.nextInt());
				System.out.print("영어 입력 : ");
				sungJukDTO2.setEng(scan.nextInt());
				System.out.print("수학 입력 : ");
				sungJukDTO2.setMath(scan.nextInt());
				
				sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
				sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.0);
			}
		}//for
		
		if(sw==0) 
			System.out.println("찾고자 하는 이름이 없습니다");
		else
			System.out.println(name+"님의 데이터를 수정하였습니다");
	}

}














