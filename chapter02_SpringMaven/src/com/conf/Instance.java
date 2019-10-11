package com.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample03.SungJukDTO;
import sample03.SungJukImpl;

import sample05.SungJukDTO2;
import sample05.SungJukInput;
import sample05.SungJukOutput;

@Configuration
public class Instance {
	
	@Bean(name="sungJukImpl")
	public SungJukImpl getSungJukImpl(){
		return new SungJukImpl();
	}
	
	@Bean(name="sungJukDTO")
	public SungJukDTO getSungJukDTO(){
		return new SungJukDTO();
	}
	
	@Bean(name="list")
	public ArrayList<SungJukDTO2> getArrayList() {
		return new ArrayList<SungJukDTO2>();
	}
	
	@Bean(name="sungJukDTO2")
	@Scope("prototype")
	public SungJukDTO2 getSungJukDTO2(){
		return new SungJukDTO2();
	}
	
	@Bean
	@Scope("prototype")
	public SungJukInput sungJukInput() {
		return new SungJukInput();
	}
	@Bean
	public SungJukOutput sungJukOutput() {
		return new SungJukOutput();
	}
	
}









