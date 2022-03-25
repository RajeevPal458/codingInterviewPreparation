package com.bt.service;

public class InFixExpressionToPostFix {
	static StringBuffer sb=null;
	static int MAX=100;
	static int top;
	static char[] stack;
	static void initializestack(){
		top=-1;
		stack=new char[MAX];
		for(int i=0;i<MAX;i++)
			stack[i]=0;
	}
	static void push(char val){
		if(top==MAX){
			return;
		}
		top+=1;
		stack[top]=val;
	}
	static char pop(){
		if(top==-1){
			return '\0';
		}
		char val=stack[top];
		top-=1;
		return val;
	}
	static boolean isEmpty(){
		if(top==-1)
			return true;
		else
			return false;
	}
	public static int precidency(char symbol){
		int val=-1;
		switch(symbol){
			
			case '(':
			case ')':val=0;
				break;
			case '+':
			case '-':val=1;
				break;
			case '*':
			case '/':
			case '%':val=2;
					break;
			case '^':val=3;
					break;
			default: val=0;
		}
		return val;
	}
	public static void conversionInfixToPostFix(String str){
		initializestack();
		sb=new StringBuffer();
		char ch='\0';
		char c;
		if(str==null)  return ;
		int len=str.length();
		for(int i=0;i<len;i++){
			try{
				ch=str.charAt(i);
			}
			catch(NullPointerException e){System.out.println("string is empty:");e.printStackTrace();}
			if(ch=='(')
			{
				push(ch);
			}
			else if(ch==')'){
				while((c=pop())!='(')
					sb.append(String.valueOf(c));
				
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='%'||ch=='^'){
				while(!isEmpty()&&(precidency(stack[top])>=precidency(ch)))
					sb.append(String.valueOf(pop()));
				push(ch);
			}
			else{
				sb.append(String.valueOf(ch));
			}
		}
		while(!isEmpty())
			sb.append(pop());
	}
	public static void main(String[] args) {
		
		String s="A-B^C+D*E/(F+G)";
		conversionInfixToPostFix(s);
		
		String st=(sb!=null)?sb.toString():null;
		System.out.println(st);
	}
}
