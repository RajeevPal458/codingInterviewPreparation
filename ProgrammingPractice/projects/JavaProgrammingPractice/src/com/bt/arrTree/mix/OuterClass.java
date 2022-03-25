
package com.bt.arrTree.mix;

class OuterClass{
	Inner head;
	class Inner{
		int data;
		Inner prev;
		Inner next;
		public Inner(int data){
			this.data=data;
			this.prev=this.next=null;
		}
	}
	public void call(){
		Inner in =new Inner(10);
		System.out.println(in.data);
	}
	public void print(Inner head){
		System.out.println("by next.............");
		Inner temp=null;
		if(head==null)
			System.out.println("List is empty");
		else{
			Inner ptr=head;
			while(ptr!=null){
				System.out.print(ptr.data+" ");
				temp=ptr;
				ptr=ptr.next;
			}
		}
		System.out.println();
		System.out.println("by prev.................");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
		
		System.out.println();
	}
}

class Tester{
	
	public static void main(String[] args) {
		OuterClass out=new OuterClass();
		out.head=out.new Inner(1);
	}
}

