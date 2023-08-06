package com.hcl.withoutframework;

public class ParentDemoClass {

	
	String name = "Class - Variable ** Parent Class **";
	
	public ParentDemoClass() {
		System.out.println("Parent Class constructor");
	}

	public void getData() {
		System.out.println("getData - Parent Class");
	}
	
	public void getThisData() {
		String name = "Method - Variable ** Parent Class **";
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
