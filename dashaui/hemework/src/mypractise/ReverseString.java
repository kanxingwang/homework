package mypractise;
import java.util.*;
import java.lang.ArrayIndexOutOfBoundsException;
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="afceg34cx";
		System.out.println("��תǰ��ģ��");
		char[] reverstr=str.toCharArray();
		for(int i=0;i<reverstr.length;i++){
		System.out.println(reverstr[i]);		
		}
		System.out.println("��ת���ģ��");
		for(int i=0;i<reverstr.length;i++){
			System.out.println(reverstr[reverstr.length-i-1]);		
			}
	}

}
