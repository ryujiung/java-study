package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods camera = new Goods();
		camera.setName("Nikon");
		camera.setPrice(40000);
		camera.setCountStock(10);
		camera.setCountSold(20);
		
		// 정보은닉(데이터 보호) 
		camera.setPrice(-1);
		
		//countOfGoods test
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		camera.showInfo();
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		System.out.println("상품이름: "+camera.getName()+", 가격: "+camera.getPrice()+", 재고개수: "+camera.getCountStock()+", 팔린개수: "+camera.getCountSold());
	}

}
