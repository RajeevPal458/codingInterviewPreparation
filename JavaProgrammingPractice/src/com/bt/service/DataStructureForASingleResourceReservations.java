package com.bt.service;
import java.util.Date;

public class DataStructureForASingleResourceReservations {
	// every job take 4 second time to complete work using same machine ;
	final static int k=4;
	static Node reservations=null;
	static class Node{
		int time;
		Node left,right;
		Node(int time){
			this.time=time;
			this.left=this.right=null;
		}
	}
	public static Node doReservation(Node root,int require,int takeTime ){
		
		if(root==null){
			return new Node(require);
		}
		
		if(require-takeTime<root.time&&require+takeTime>root.time)
			return root;
		if(require<root.time)
			root.left=doReservation(root.left,require,takeTime );
		else
			root.right=doReservation(root.right,require,takeTime );
		return root;
	}
	public static void main(String[] args) {
		
		//At time 0
		
		Date date=new Date();
		System.out.println("	start Reservation at Time:"+date.getTime());
		int[] queryTime={2};
		reservations=doReservation(reservations,2,4);
		try {
			Thread.sleep(3000*60);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("second reservation Sedule Time:"+date.getTime());
		
		try {
			Thread.sleep(3000*60);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("second reservation Sedule Time:"+date.getTime());
	}
}
