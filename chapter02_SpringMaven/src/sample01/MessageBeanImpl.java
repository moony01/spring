package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
public class MessageBeanImpl implements MessageBean{
	private @Value("딸기") String fruit;
	private @Value("5000") int cost;
	private @Value("3") int qty;
	
	/*
	//fruit 생성자 Injection
	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
	}
	
	//cost, qty setter Injection
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	*/
	
	@Override
	public void sayHello() {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}	

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);		
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}

}
