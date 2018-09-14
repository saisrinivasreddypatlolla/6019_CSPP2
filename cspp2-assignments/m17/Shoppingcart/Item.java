import java.util.*;
class Item {
	int size = 0, size1 = 0;
	boolean flag = false;
	String items, cartItem;
	int quant, cartQuant;
	double price;
	String[] item = new String[20];
	int[] quantity = new int[20];
	double[] prices = new double[20];
	String[] cartItems = new String[20];
	int[] cartQuantity = new int[20];
	Item() {

	}
	Item(String itemName, int quant, double price1) {
		this.items = itemName;
		this.quant = quant;
		this.price = price1;
	}
	Item(String cartItem, int cartQuant) {
		this.cartItem = cartItem;
		this.cartQuant = cartQuant;
	}
	public void add(Item obj) {
		item[size] = obj.items;
		quantity[size] = obj.quant;
		prices[size] = obj.price;
		size++;
	}
	public void addCart(Item obj) {
		for (int k = 0; k < size1; k++) {
			if (obj.cartItem.equals(cartItems[k])) {
				flag = true;
			}
		}
		if (flag == true) {
			cartQuantity[indexOfCart(obj.cartItem)] += obj.cartQuant;
			quantity[indexOf(obj.cartItem)] -= obj.cartQuant;
			flag = false;
		} else {
			cartItems[size1] = obj.cartItem;
			cartQuantity[size1] = obj.cartQuant;
			quantity[indexOf(obj.cartItem)] -= obj.cartQuant;
			size1++;
		}
	}
	public void remove(Item obj) {
		for (int k = 0; k < size; k++) {
			if (obj.cartItem.equals(cartItems[k])) {
				quantity[size] += obj.quant;
				cartQuantity[indexOfCart(obj.cartItem)] -= obj.cartQuant;
				int value = indexOfCart(obj.cartItem);
				if(cartQuantity[indexOfCart(obj.cartItem)]==0){
					for(int i=value;i<size1;i++){
						cartItems[i]=cartItems[i+1];
						cartQuantity[i]=cartQuantity[i+1];
						size1--;
					}

				}
			}
		}
	}
	private int indexOf(String items) {
		for (int k = 0; k < size; k++) {
			if (items.equals(item[k])) {
				return k;
			}
		}
		return -1;
	}
	private int indexOfCart(String items) {
		for (int k = 0; k < size1; k++) {
			if (items.equals(cartItems[k])) {
				return k;
			}
		}
		return -1;
	}
}