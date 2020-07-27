package silsub3.run;

import silsub3.model.vo.Circle;

public class Run {
		public static void main(String[] args) {
			
			Circle cc = new Circle();
			
			cc.setRadius(3);
			System.out.println("원의 넓이 : " +cc.Sum());
			System.out.println("원의 둘레 : " +cc.Length());
			
			cc.incrementRadius();
			System.out.println("원의 넓이 : " +cc.Sum());
			System.out.println("원의 둘레 : " +cc.Length());
			
			
		}
}
