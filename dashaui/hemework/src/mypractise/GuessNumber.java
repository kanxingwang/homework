package mypractise;
/*
 * 猜大小游戏
 * 刚开始用的while循环，结果第二次生成随机数无法参与判断的问题。进一步思考了这俩个循环的用处。
 */
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String result=null;
		//生成随机数
			Random random=new Random();
			int confirmnum=random.nextInt(10)+1;
			System.out.println("生成的随机数："+confirmnum);
		do{
			int  guessnum=getGuessnum();
			if(confirmnum>guessnum){
				result="dala";
				System.out.println("小了，请输大点");
			}
			else if(confirmnum<guessnum){
				result="xiaole";
				System.out.println("大了，请输小点");
			}
			else{
				result="duile";
			System.out.println("恭喜！猜对了");
			}
		}while(result!="duile");
	}
	//用户输入数字
	public static int getGuessnum(){
		System.out.println("请用户在键盘输入值：");
		Scanner inpu=new Scanner(System.in);
		int guessnum=inpu.nextInt();
		System.out.println("用户输入的值是："+guessnum);
		return guessnum;
	}	
}
