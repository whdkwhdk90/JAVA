package args;

public class MainArgs {
		public static void main(String[] test) {    //던져준 데이터를 배열로 받음
			System.out.println("전달값 갯수 : " + test.length);
			
			
			
			
			for(int i = 0 ; i < test.length; i++) {
					System.out.println(i+ "번째 값 : " + test[i]);
			}  //이때 결과값은 문자열임!!!!
			
		}
}
