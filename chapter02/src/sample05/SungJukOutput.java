package sample05;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;

@Setter
public class SungJukOutput implements SungJuk {
	private List<SungJukDTO> list;
	
	@Override
	public void execute() {
		System.out.println();
		for(SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO);
		}//for
	}

}
