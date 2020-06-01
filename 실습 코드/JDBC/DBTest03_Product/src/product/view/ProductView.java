package product.view;

import java.util.List;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.vo.Product;

public class ProductView {
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		System.out.println("1. 전체 출력");
		System.out.println("2. 선택 출력");
		System.out.println("3. 추가");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택: ");
		int select = sc.nextInt();
		return select;
	}
	
	public ProductView() {
		int select = 0;
		//view는 controller와만 데이터를 주고 받아야함
		ProductController pc =  new ProductController();
		
		while(select != 6) {
			select = getMenu();
			
			switch(select) {
			case 1: 
					List<Product> res = pc.selectAll();
							for(Product p : res) {
								System.out.println(p);
							}
					break;
			case 2:
					
					break;
			case 3:
				
					break;
			case 4:
				
					break;
			case 5:
					
					break;
			case 6: 
				System.out.println("프로그램을 종료합니다");
				return;
			}
			
		}
		
		
	}
	
}
