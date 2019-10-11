package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk {
	private List<SungJukDTO> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String name = scan.next();
		
		int sw=0;
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				it.remove();
				sw=1;
			}
		}//for
		
		if(sw==0) 
			System.out.println("찾고자 하는 이름이 없습니다");
		else
			System.out.println(name+"님의 데이터를 삭제하였습니다");

	}

}









