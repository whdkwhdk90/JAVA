package silsub2.run;

import silsub2.model.vo.Product;

public class Run {
		public static void main(String[] args) {
			
			Product pd = new Product();
			
			pd.setBrand("나이키");
			pd.setPName("마이클 조던");
			pd.setPrice(230000);
			
			System.out.println(pd.info());
			
			
		}
}
