package com.poly.app.enity;

import org.springframework.stereotype.Component;

@Component
public class VNSpeech implements Speech {

	@Override
	public void sayGreeting() {
		System.out.println("Xin chào");
		
	}

}
