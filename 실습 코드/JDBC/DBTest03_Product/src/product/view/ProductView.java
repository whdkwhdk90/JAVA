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
					System.out.print("pid 입력: ");
					String id = sc.next();
					Product resOne = pc.selectOne(id);
					System.out.println(resOne);
					break;
			case 3:
					System.out.println("***추가할 데이터 입력***");
					System.out.print("추가할 pid 입력: ");
					String id2 = sc.next();
					System.out.print("추가할 pname 입력: ");
					String name2 = sc.next();
					System.out.print("추가할 price 입력: ");
					int price2 = sc.nextInt();
					System.out.print("추가할 desc 입력: ");
					String desc2 = sc.next();
					Product res2 = new Product();
					res2.setpId(id2);
					res2.setpName(name2);
					res2.setPrice(price2);
					res2.setDesc(desc2);
					
					int number = pc.insert(res2);
					if(number>0) {
						System.out.println("추가 성공");
					}else {
						System.out.println("추가 실패");
					}
					break;
			case 4:
					System.out.print("수정할 pid 입력: ");
					String id3 = sc.next();
					System.out.print("수정할 pname 입력: ");
					String name3 = sc.next();
					System.out.print("수정할 price 입력: ");
					int price3 = sc.nextInt();
					System.out.print("수정할 desc 입력: ");
					String desc3 = sc.next();
					Product res3 = new Product();
					res3.setpId(id3);
					res3.setpName(name3);
					res3.setPrice(price3);
					res3.setDesc(desc3);
					
					int number3 = pc.update(res3);
					
					
					if(number3>0) {
						System.out.println("수정 완료");
					}else {
						System.out.println("수정 실패");
					}
					break;
			case 5:
					System.out.print("삭제할 pid 입력: ");
					String name4 = sc.next();
					int number4 = pc.delete(name4);
					
					if(number4>0) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("삭제 실패");
					}
					break;
			case 6: 
				System.out.println("프로그램을 종료합니다");
				return;
			}
			
		}
		
		
	}
	
}
