package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukModify implements SungJuk {
	private List<SungJukDTO> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 이름을 입력하세요 : ");
		String name = scan.next();
		
		int sw=0;
		for(SungJukDTO sungJukDTO : list) {
			if(sungJukDTO.getName().equals(name)) {
				System.out.println(sungJukDTO);
				sw=1;
				
				System.out.println();
				System.out.println(name + "님의 데이터 수정을 시작합니다...");			
				System.out.print("국어 입력 : ");
				sungJukDTO.setKor(scan.nextInt());
				System.out.print("영어 입력 : ");
				sungJukDTO.setEng(scan.nextInt());
				System.out.print("수학 입력 : ");
				sungJukDTO.setMath(scan.nextInt());
				
				sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
				sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
			}
		}//for
		
		if(sw==0) 
			System.out.println("찾고자 하는 이름이 없습니다");
		else
			System.out.println(name+"님의 데이터를 수정하였습니다");
	}

}







