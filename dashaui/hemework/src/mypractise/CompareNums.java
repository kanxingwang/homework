package mypractise;
/*
 * �Ƚ�������
 */
public class CompareNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={23,42,38,23,24,56};
		int max=0;
		max=nums[0];
		for(int i=0;i<nums.length;i++){
			if(nums[i]>max){
				max=nums[i];
			}
		}
		System.out.println("���ֵ��"+max);
	}

}
