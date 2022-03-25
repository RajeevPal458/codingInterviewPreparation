package org.algo.tree;

public class ProgramToCheckNextingOfParenthesis {
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
			System.out.println("stack is ovrflow!");
			return;
		}
		top+=1;
		stack[top]=val;
	}
	static char pop(){
		if(top==-1){
			System.out.println("stack is underflow!");
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
	public static void checkNextingOfParenthesis(String s){
		initializestack();
		char temp;char ch='\0';
		if(s==null)
			return ;
		for(int i=0;i<s.length();i++){
			try{
				ch=s.charAt(i);
			}
			catch(NullPointerException e){System.out.println("string is empty:");e.printStackTrace();}
			if(ch=='('||ch=='{'||ch=='[')
				push(ch);
			else if(ch==')'||ch=='}'||ch==']'){
				
				if(top==-1){
					System.out.println("Right Paranthesis is more then left paranthesis!");
					return;
				}
				else{
					temp=pop();
					if(!match(temp, ch)){
						System.out.println("Mish Match Paranthesis Found!");
						System.out.println(temp+" "+ch);
					}
				}
			}
		}
		if(top==-1){
			System.out.println("Balanced Paranthesis!");
			return ;
		}
		else{
			System.out.println("Left Paranthesis more then right Paranthesis!");
			return ;
		}
	}
	public static boolean match(char ch1,char ch2){
		
		if(ch1=='['&&ch2==']')
			return true;
		
		if(ch1=='{'&&ch2=='}')
			return true;
		if(ch1=='('&&ch2==')')
			return true;
		return false;
	}
	public static void main(String[] args) {
		String str="[C+{A/(B-C)*D}%B]";
		checkNextingOfParenthesis(str);
		
		
	}
}
