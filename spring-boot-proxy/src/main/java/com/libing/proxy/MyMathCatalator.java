package com.libing.proxy;

public class MyMathCatalator implements Calcultaor {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		System.out.println("========正常代码执行111111111111===========");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result=i-j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result=i*j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result=i/j;
		return result;
	}

}
