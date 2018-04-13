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
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getDimWidth() {
		return dimWidth;
	}
	public void setDimWidth(int dimWidth) {
		this.dimWidth = dimWidth;
	}
	public int getDimHeight() {
		return dimHeight;
	}
	public void setDimHeight(int dimHeight) {
		this.dimHeight = dimHeight;
	}
	public int getDimDepth() {
		return dimDepth;
	}
	public void setDimDepth(int dimDepth) {
		this.dimDepth = dimDepth;
	}
	
	
}
