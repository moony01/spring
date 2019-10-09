package sample03;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SungJukImpl implements SungJuk {
	private SungJukDTO sungJukDTO;

	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot() / 3.0);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("이름 입력: ");
		sungJukDTO.setName(input.next());
		
		System.out.print("국어 입력: ");
		sungJukDTO.setKor(input.nextInt());
		
		System.out.print("영어 입력: ");
		sungJukDTO.setEng(input.nextInt());
		
		System.out.print("수학 입력: ");
		sungJukDTO.setMath(input.nextInt());
	}
	
	
}
