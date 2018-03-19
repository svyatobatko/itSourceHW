package itSourceHW.hw6;

public class Sweets implements Comparable {

	private String sweetName;
	private int weight;
	private int sugar;
	private int calories;
	private String manufacturer;
	private String[] composition;
	private int quantity;
	
	public String getSweetName() {
		return sweetName;
	}
	public void setSweetName(String sweetName) {
		this.sweetName = sweetName;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String[] getComposition() {
		return composition;
	}
	public void setComposition(String[] composition) {
		this.composition = composition;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int compareTo(Object obj) {
		Sweets entry = (Sweets) obj;
           
        int result = sweetName.compareTo(entry.sweetName);
        if(result != 0) {
               return result;
        }

        result = calories - entry.calories;
        if(result != 0) {
               return result;
        }
        return 0;
	}
		
}

