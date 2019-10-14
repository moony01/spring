package sample01;

import lombok.Setter;

//Target
public class MessageBeanImpl implements MessageBean {
	@Setter
	private String str;
	
	@Override
	public String showPrint() {
		System.out.println("showPrint 메시지 = " +str);//핵심관심사항
		return "KIN";
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메시지 = "+str);//핵심관심사항	
	}

	@Override
	public void display() {
		System.out.println("display 메시지 = "+str);//핵심관심사항
	}

}
