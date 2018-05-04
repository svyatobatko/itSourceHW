package itSourceHW.hw11_12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import itSourceHW.hw11_12.Ware;

public class Shop {
	
	private static final int MAX_WARE = 10000;
	private static final int MAX_FILD = 8;
//	private Ware[] ware = new Ware[MAX_WARE];
	private List<Ware> myWare = new ArrayList<Ware>();

	private String wareFile = "src/itSourceHW/hw11_12/Ware.txt";
	
	public List<Ware> getWare() {
		return this.myWare;
	}
	

	public void setWare(List<Ware> myWare) {
		this.myWare = myWare;
	}


	public Shop() throws IOException { 
		
		String[] fileLine = printFileToArrayString(wareFile);
		String[][] fild = new String[fileLine.length][MAX_FILD];
		for (int i = 0; i < fileLine.length; i++) {
			String[] newFild = fileLine[i].split(";");
			for (int j = 0; j < newFild.length; j++) {
				fild[i][j] = newFild[j];
			}
		}
		//this.ware = new Ware[fileLine.length];
		for (int i = 1; i < fileLine.length; i++) {
			myWare.add(new Ware(fild[i]));
		}
	}
	
	private static void writeToFile(String path, String textToWrite) throws IOException {
		Files.write(Paths.get(path), textToWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}

	private static String[] printFileToArrayString(String path) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			String[] allLine = new String[MAX_WARE];
			int i = 0;
			while ( (line = br.readLine()) != null) {
//				System.out.println(allLine.length);
				allLine[i] = line;
				i++;
				if ((i - 1) == MAX_WARE) {
					allLine = new String[MAX_WARE*2];
				}
			}
			String[] allLinesOut = new String[i];
			for (int j = 0; j < allLinesOut.length; j++) {
				allLinesOut[j] = allLine[j];
			}
			return allLinesOut;
		}
	}

	public void addWare(String addWare) throws IOException {
		String allField = (myWare.size()+1) + ";" + addWare;
		String[] field = allField.split(";");
		Ware newWare = new Ware(field);
		writeToFile(wareFile, (System.lineSeparator() + ( (myWare.size()+1) + ";" + addWare)));
		myWare.add(newWare);
		System.out.println("Товар успешно добавлен в магазин.");
//		setWare(myWare);
		for (Ware ware : myWare) {
			System.out.println(ware.getId());
		}
		System.out.println();
		
	}

	public void helloBuyer() {
		System.out.println("Здравствуйте покупатель, для пользования магазином введите одну из команд:");
		helpBuyer();
	}
	
	public void helpBuyer() {
		System.out.println("add - добавить товар в магазин (только для администратора);");
		System.out.println("print - вывести все товары;");
		System.out.println("put - положить товар в корзину;");
		System.out.println("basket - вывести, какие товары уже в корзине и общая сумма товаров;");
		System.out.println("buy - сделать покупку;");
		System.out.println("help - вывести помощь;");
		System.out.println("exit - завершить работу с магазином;");
	}
	
	public boolean putWare(int idWare) {
		boolean added = false;
		boolean putHash = true;
		for (Ware ware : myWare) {
			if (idWare == ware.getId() && ware.canReserved()) {
				ware.incReserved();
				System.out.println("Товар добавлен в корзину.");
				added = true;
				putHash = true;
			} else if (idWare == ware.getId() && !ware.canReserved()) {
				System.out.println("Извините, данный товар закончился или зарезервирован.");
				added = true;
				putHash = false;
			}
		}
		if (!added) {
			System.out.println("Извините, такого товара нет в магазине.");
			putHash = false;
		}
		return putHash;

	}

}
