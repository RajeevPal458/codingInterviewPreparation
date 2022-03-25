package org.leet.code.goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisGivenN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=3;
		List<String> list = new ArrayList<String>();
		genparanthesis(n,0,0,"",list);
		System.out.println(list);
	}

	private static void genparanthesis(int n, int open, int close, String s,List<String> ans) {
		// TODO Auto-generated method stub
		if(open==n && close ==n) {
			ans.add(s);
			return;
		}
		
		if(open < n) {
			genparanthesis(n, open+1, close, s+"(", ans);
		}
		
		if(close < open) {
			genparanthesis(n, open, close+1, s+")", ans);
		}
		
	}

}
