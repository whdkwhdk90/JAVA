package backjoon;

import java.util.Scanner;

public class 와일세번째 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;	
		int num1, num2, num3;
/*		do {
			num1 = (num/10) + (num%10);
			num2 = (num%10)*10 + num1;
			count++;
			System.out.println(num1 +" " +num2);
		}while(num != num2);
	
		System.out.println(count);
*/		
		num3 = num;
		while(true) {
			
			num1 = (num/10) + (num%10);
			
			num2 = (num%10)*10 + (num1%10);
			count++;
			
			if(num3 ==num2) {
				break;
			}
			else {
				num = num2;
			}
			
			System.out.print(count);
		}
		
		
		
		
		
		
	}
}
