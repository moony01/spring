package sample01;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean messageBean = new MessageBean(); //1:1관계, 결함도 100%
		messageBean.sayHello("Spring");
	}
}
