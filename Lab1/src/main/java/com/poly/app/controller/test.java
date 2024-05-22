package com.poly.app.controller;

public class test {
	public static void main(String[] args) {
		String  s= "samsung1.jpg-samsung21.jpg-samsung3.jpg-samsung4.jpg-samsung5.jpg-";
		
		String[] str = s.split("-");
		
		for (String string : str) {
			System.out.println(string);
		}
	}
}
