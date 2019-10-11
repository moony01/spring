package sample05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@Component
@ComponentScan("com.conf")

public class SungJukOutput implements SungJuk {
	//@Autowired
	//private ArrayList<SungJukDTO2> list;
	
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		System.out.println();
		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2);
		}//for
	}

}





