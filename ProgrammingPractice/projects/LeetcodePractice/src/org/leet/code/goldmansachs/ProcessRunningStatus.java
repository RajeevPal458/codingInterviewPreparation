package org.leet.code.goldmansachs;

import java.util.HashMap;
import java.util.Map;

/*
 * 15,
["0 A created",
 "1 B created",
 "10 A running",
 "12 B waiting",
 "13 B running",
 "14 A waiting",
 "17 B terminated",
 "18 A terminated"]
 */
public class ProcessRunningStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(int t, String[] logs) {
        // write your code in Java 8
        String result="";
        Map<String, String> map =new HashMap<String, String>();
        for(int i=0;i<logs.length;i++) {
        	//logs
        	String process = logs[i];
        	String[] parr =process.split(" ");
        	int time =Integer.valueOf(parr[0]);
        	String procc =parr[1];
        	String status =parr[2];
        }
        return result;
    }

}
