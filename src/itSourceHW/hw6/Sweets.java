package itSourceHW.hw6;

import java.util.Comparator;

public class Sweets {

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
	
	public class SweetsCaloriesComparator implements Comparator<Sweets>{
		  
	    public int compare(Sweets a, Sweets b){
	      
	        if ((a.getCalories()) > (b.getCalories())) {
	        	return a.getCalories();
			} else {
				return b.getCalories();
			}
	    }
	}
}
