package com.leetcode.sixty;
/**
 * 
 * @author jenice
 * #67
 *
 */
public class AddBinary {
	
	public static void main(String[] args) {
		System.out.println(addBinaryWay2("0","0"));
		System.out.println(addBinaryWay2("100","110010"));
		System.out.println(addBinaryWay2("11", "1"));
		System.out.println(addBinaryWay2("1010", "1011"));
	}
	
	public static String addBinary(String a, String b) {
		
        int length = Math.max(a.length(), b.length());
        char[][] storage = new char[3][length+1];
        
        for(int i=0; i<2; i++) {
        	for(int j=0; j<=length;j++) {
        		storage[i][j]= '0'; 
        	}
        }
        
        for(int i = a.length()-1; i>=0; i--) {
        	storage[0][i+1+length-a.length()] = a.charAt(i);
        }
        for(int i = b.length()-1; i>=0; i--) {
        	storage[1][i+1+length-b.length()] = b.charAt(i);
        }
		
        int addition = 0;
        for(int i = length; i>=0; i--) {
        	if(storage[0][i] == '1' && storage[1][i] == '1') {
        		int temp = 2 + addition;
        		if(temp == 2)
        			storage[2][i] = '0';
        		else if(temp == 3) {
        			storage[2][i] = '1';
        		}
        		addition=1;
        	}else if(storage[0][i] == '1' && storage[1][i] == '0' || storage[0][i] == '0' && storage[1][i] == '1') {
        		int temp = 1 + addition;
        		if(temp == 2) {
        			storage[2][i] = '0';
        			addition = 1;
        		}
        		else if(temp == 1) {
        			storage[2][i] = '1';
        			addition = 0;
        		}
        	}else {
        		int temp = addition;
        		if(temp == 0)
        			storage[2][i] = '0';
        		else if(temp == 1) {
        			storage[2][i] = '1';
        		}
        		addition=0;
        	}
        }
        
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0; i<=length; i++) {
        	sBuilder.append(storage[2][i]);
        }
        
        if(sBuilder.charAt(0) == '0') {
        	sBuilder.deleteCharAt(0);
        }
        
		return sBuilder.toString();
    }
	
	public static String addBinaryWay2(String a, String b) {
		StringBuilder sBuilder = new StringBuilder();
		int x = 0, y = 0;
		int pre = 0, sum = 0;
		
		while(a.length()!=b.length()) {
			if(a.length()>b.length()) {
				b = "0"+ b;
			}else {
				a = "0"+ a;
			}
		}
		
		for(int i = a.length()-1; i>=0; i--) {
			x = a.charAt(i) - '0';
			y = b.charAt(i) - '0';
			sum = x + y + pre;
			if(sum>=2) {
				pre = 1;
				sBuilder.append(sum-2);
			}else {
				pre = 0;
				sBuilder.append(sum);
			}
		}
		
		if(pre == 1) {
			sBuilder.append("1");
		}
		
		return sBuilder.reverse().toString();
	}
}
