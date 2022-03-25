package org.algo.stack;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses{
	ArrayList<String> result = new ArrayList<String>();
    int max=0; 
 
    public List<String> removeInvalidParentheses(String s) {
        if(s==null)
            return result;
 
        dfs(s, "", 0, 0);
        if(result.size()==0){
            result.add("");
        }
 
        return result;
    }
    public void dfs(String substr, String res, int countLeft, int maxLeft){
    	if(substr.length()==0){
    		
    		if(countLeft<=0&&res.length()!=0){
    			if(max<maxLeft)
        			max=maxLeft;
        		
        		if((maxLeft==max)&&!result.contains(res)){
        			result.add(res);
        		}
    		}
    		return ;
    	}
    	
    	
    	if(substr.charAt(0)=='('){
    		dfs(substr.substring(1), res+"(", countLeft+1, maxLeft+1);
    		dfs(substr.substring(1), res, countLeft, maxLeft);
    	}
    	if(substr.charAt(0)==')'){
    		if(countLeft!=0)
    			dfs(substr.substring(1), res+")", countLeft-1, maxLeft);
    		dfs(substr.substring(1), res, countLeft, maxLeft);
    	}
    	else{
    		dfs(substr.substring(1), res+substr.charAt(0)+"", countLeft, maxLeft);
    	}
    }


	public static void main(String[] args) {
		RemoveInvalidParentheses rev=new RemoveInvalidParentheses();
		String str="()()())";
		rev.removeInvalidParentheses(str);
		System.out.println(rev.result);
		
	}
}
