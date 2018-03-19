package itSourceHW.hw6.sweets;

import itSourceHW.hw6.Sweets;

public abstract class Icecream extends Sweets {
	private int storageTemperature;

	public int getStorageTemperature() {
		return storageTemperature;
	}

	public void setStorageTemperature(int storageTemperature) {
		this.storageTemperature = storageTemperature;
	}

}