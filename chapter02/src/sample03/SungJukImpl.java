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
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("�̸� �Է�: ");
		sungJukDTO.setName(input.next());
		
		System.out.print("���� �Է�: ");
		sungJukDTO.setKor(input.nextInt());
		
		System.out.print("���� �Է�: ");
		sungJukDTO.setEng(input.nextInt());
		
		System.out.print("���� �Է�: ");
		sungJukDTO.setMath(input.nextInt());
	}
	
	
}
