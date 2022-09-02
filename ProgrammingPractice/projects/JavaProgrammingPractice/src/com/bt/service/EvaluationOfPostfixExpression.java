package com.bt.service;
import javax.imageio.plugins.bmp.BMPImageWriteParam;

public class EvaluationOfPostfixExpression {
	static int MAX=100;
	static int top;
	static int[] stack;
	static void initializestack(){
		top=-1;
		stack=new int[MAX];
		for(int i=0;i<MAX;i++)
			stack[i]=0;
	}
	static void push(int val){
		if(top==MAX){
			return;
		}
		top+=1;
		stack[top]=val;
	}
	static int pop(){
		if(top==-1){
			System.out.println("stack is underflow!");
			return '\0';
		}
		int val=stack[top];
		top-=1;
		return val;
	}
	static boolean isEmpty(){
		if(top==-1)
			return true;
		else
			return false;
	}
	static int a,b;
	public static void evaluateExpression(String s){
		char ch='\0';
		for(int i=0;i<s.length();i++){
			
			try{
				ch=s.charAt(i);
			}
			catch(NullPointerException e){System.out.println("string is empty:");e.printStackTrace();}
			
			if(ch>='0'&&ch<='9'){
				push((ch-'0'));
			}
			else{
				b=pop();
				a=pop();
				push(calculate(ch));
			}
		}
		while(!isEmpty())
		System.out.println(pop());
		
	}
	public static int calculate(char sym){
		int result=0;
		switch(sym){
		
		case '+': result= a+b;
			break;
		case '-': result=a-b;
			break;
		case '*': result=a*b;
			break;
		case '/': result=a/b;
			break;
		case '%': result=a%b;
			break;
		case '^': result=(int)Math.pow(a,b);
			break;
		default:System.out.println("Symbol Not Match!");
		}
		return result;
	}
	public static void main(String[] args) {
		String s="7532^*922^-/+64*+";
		initializestack();
		evaluateExpression(s);
		
	}
}
