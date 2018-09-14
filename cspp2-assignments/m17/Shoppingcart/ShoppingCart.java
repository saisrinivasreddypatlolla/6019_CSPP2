class ShoppingCart {
	// static int size = 0, size1 = 0;
	Item io = new Item();
	double payableAmount = 0.0;
	double totalAmount = 0.0;
	double disc = 0.0;
	public void addToCatalog(Item obj) {
		io.add(obj);
	}
	public void showCatalog() {
		for (int i = 0; i < io.size; i++) {
			System.out.println(io.item[i] + " " + io.quantity[i] + " " + io.prices[i]);
		}
	}
	public void addToCart(Item obj) {
		io.addCart(obj);
	}
	public void showCart() {
		for (int i = 0; i < io.size1; i++) {
			System.out.println(io.cartItems[i] + " " + io.cartQuantity[i]);
		}
	}
	public double getTotalAmount() {
		totalAmount = 0.0;
		for (int i = 0; i < io.size1; i++) {
			totalAmount += io.prices[indexOf(io.cartItems[i])] * io.cartQuantity[i];
		}
		return totalAmount;
	}
	private int indexOf(String item) {
		for (int i = 0; i < io.size; i++) {
			if (item.equals(io.item[i])) {
				return i;
			}
		}
		return -1;
	}
	public void removeFromCart(Item obj) {
		// for (int i = 0; i < size1; i++) {
		// 	if (item.equals(io.cartItems[i])) {
		// 		io.cartQuantity[i] -= quant;
		// 	}
		// }
		io.remove(obj);
	}
	public double getPayableAmount() {
		payableAmount = getTotalAmount()-disc;
		double tax = payableAmount*0.15;
		// for (int i = 0; i < io.size1; i++) {
		// 	payableAmount += io.prices[indexOf(io.cartItems[i])] * io.cartQuantity[i];
		// }
		return payableAmount+tax;
	}
	public void applyCoupon(String coupon) {
		if (coupon.equals("IND10")) {
			disc = totalAmount * 0.10;
		} else if (coupon.equals("IND20")) {
			disc = totalAmount * 0.20;
		} else if (coupon.equals("IND30")) {
			disc = totalAmount * 0.30;
		} else if (coupon.equals("IND50")) {
			disc = totalAmount * 0.50;
			System.out.println(totalAmount+" "+totalAmount * 0.50);
		} else {
			System.out.println("Invalid coupon");
		}
	}
	public void printInvoice(){
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < io.size1; i++) {
			System.out.println(io.cartItems[i] + " " + io.cartQuantity[i] + " " + io.prices[indexOf(io.cartItems[i])]);
		}
		System.out.println("Total:"+totalAmount);
		System.out.println("Disc%:"+disc);
		System.out.println("Tax:"+(payableAmount*0.15));
		System.out.println("Payable amount: "+((totalAmount-disc)+(payableAmount*0.15)));
	}
}