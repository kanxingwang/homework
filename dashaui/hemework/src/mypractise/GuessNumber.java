package mypractise;
/*
 * �´�С��Ϸ
 * �տ�ʼ�õ�whileѭ��������ڶ�������������޷������жϵ����⡣��һ��˼����������ѭ�����ô���
 */
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String result=null;
		//���������
			Random random=new Random();
			int confirmnum=random.nextInt(10)+1;
			System.out.println("���ɵ��������"+confirmnum);
		do{
			int  guessnum=getGuessnum();
			if(confirmnum>guessnum){
				result="dala";
				System.out.println("С�ˣ�������");
			}
			else if(confirmnum<guessnum){
				result="xiaole";
				System.out.println("���ˣ�����С��");
			}
			else{
				result="duile";
			System.out.println("��ϲ���¶���");
			}
		}while(result!="duile");
	}
	//�û���������
	public static int getGuessnum(){
		System.out.println("���û��ڼ�������ֵ��");
		Scanner inpu=new Scanner(System.in);
		int guessnum=inpu.nextInt();
		System.out.println("�û������ֵ�ǣ�"+guessnum);
		return guessnum;
	}	
}
