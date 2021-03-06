package itSourceHW.hw11_12;

public class Ware {
	private int id; 
	private String name;
	private int weight; // in grams
	private int dimWidth;
	private int dimHeight;
	private int dimDepth;
	private int quantity;
	private int price;
	private int reserved;

	public Ware() {
		
	}
	
	public Ware(String[] field) {
		this.id = Integer.parseInt(field[0]);
		this.name = field[1];
		this.weight = Integer.parseInt(field[2]);
		this.dimWidth = Integer.parseInt(field[3]);
		this.dimHeight = Integer.parseInt(field[4]);
		this.dimDepth = Integer.parseInt(field[5]);
		this.quantity = Integer.parseInt(field[6]);
		this.price = Integer.parseInt(field[7]);
		this.reserved = 0;
	}
	
	public int getReserved() {
		return reserved;
	}

	public void incReserved() {
		this.reserved++;
	}
	
	public boolean canReserved() {
		if (this.quantity > this.reserved) {
			return true;
		} else {
			return false;
		}
	}

	public int getPrice() {
		return price;
	}

	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public int getDimWidth() {
		return dimWidth;
	}
	public int getDimHeight() {
		return dimHeight;
	}
	public int getDimDepth() {
		return dimDepth;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id + price;
		return result;
	}
}
