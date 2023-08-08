package com.hcl.baseframework;

import java.util.Random;

public class Utilities {
	
	public static Integer randomNumberGenerator() {
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return randomInt; 
	}
	
}

