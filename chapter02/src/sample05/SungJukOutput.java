package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungJukOutput implements SungJuk {

	@Override
	public void execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukDTO sungJukDTO = (SungJukDTO)context.getBean("sungJukDTO");
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(int i=0; i<HelloSpring.list.size(); i++) {
			   System.out.println( HelloSpring.list.get(i).getName()
					   +"\t"+HelloSpring.list.get(i).getKor()
					   +"\t"+HelloSpring.list.get(i).getEng()
					   +"\t"+HelloSpring.list.get(i).getMath() 
					   +"\t"+HelloSpring.list.get(i).getTot()
					   +"\t"+HelloSpring.list.get(i).getAvg() 
					   );
		}
		
	}

}
