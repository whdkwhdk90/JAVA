package silsub.run;

import silsub1.model.vo.Member;

public class Run {
		public static void main(String[] args) {
			
			Member mb = new Member();
	//		Member mb = new Member("이창진","good","soon",23,'M',"12345325","asdasd");
//			이렇게해도 선언됨(위에 줄이 밑에 7줄과 같은 의미)
			
			
			
			mb.setMemberName("이창진");
			mb.setMemberPwd("good");
			mb.setMemberId("soon");
			mb.setPhone("12912354954");
			mb.setEmail("dsadasdasd");
			mb.setAge(23);
			mb.setGender('M');
			
			
			
			System.out.println(mb.getMemberId());
			System.out.println(mb.getMemberPwd());
			System.out.println(mb.getMemberName());
			System.out.println(mb.getAge());
			System.out.println(mb.getPhone());
			System.out.println(mb.getEmail());
			System.out.println(mb.getGender());
			
			
			
			
		}
}
