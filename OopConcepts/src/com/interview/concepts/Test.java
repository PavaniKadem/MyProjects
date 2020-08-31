package com.interview.concepts;
//Inheritence & RunTime Polymorphism(method overriding)
public class Test extends CutTheFruit{
	
	@Override
	public void threeSlices() {
		System.out.println("inside test");
	}
	public static void main(String[] args) {
		Test test=new Test();
		test.threeSlices();
		System.out.println("Ran Successfully!");
	}
	public void twoSlices() {
		System.out.println("Inside main class");
	}

}
