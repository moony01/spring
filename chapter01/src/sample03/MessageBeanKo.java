package sample03;

public class MessageBeanKo implements MessageBean {
	private int num;
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo �⺻ ������");
	}

	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		System.out.println("�ȳ��ϼ��� "+name+"!!");
		
	}
	
}
