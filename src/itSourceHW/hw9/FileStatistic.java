package itSourceHW.hw9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

import itSourceHW.hw6.Sweets;

public class FileStatistic {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите имя файла, статистику которого Вы хотите просмотреть:");
		String varFile = sc.nextLine();
		String[] fileLine = printFileToArrayString(varFile);
		char[] fileChars = arrayStringToArrayChar(fileLine);
		Symbol[] symbolInFile = new Symbol[200];
		int symbolQuant = 0;
		for (int i = 0; i < fileChars.length; i++) {
			for (int j = 0; j < symbolInFile.length; j++) {
				if (symbolInFile[j] == null) {
					symbolInFile[j] = new Symbol();
					symbolInFile[j].symbolName = fileChars[i];
					symbolQuant++;
					break;
				}
				if (symbolInFile[j].existSymbol(fileChars[i])) {
					symbolInFile[j].increaseSymbolQuntity();
					break;
				} 
			}
		}
		
		Symbol[] symbolInFileSort = new Symbol[symbolQuant];
		for (int i = 0; i < symbolInFileSort.length; i++) {
			symbolInFileSort[i] = symbolInFile[i];
		}
		
		System.out.println("В файле присутствует " + symbolQuant + " символа(ов), следующие символы:");
		Stream<Symbol> symbolStream = Stream.of(symbolInFileSort);
		symbolStream
					.sorted( (symbol1, symbol2) -> {
						return symbol1.getQuantity() - symbol2.getQuantity();
						}).forEach(s->System.out.println(s.getSymbolName() + 
								" - содержится в файле: " + s.getQuantity()));
		
		sc.close();
	}

	@SuppressWarnings("null") // уточнить у Андрея
	public static String[] printFileToArrayString(String path) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			String[] allLine = new String[10000];
			int i = 0;
			while ( (line = br.readLine()) != null) {
				allLine[i] = line;
				i++;
			}
			String[] allLinesOut = new String[i];
			for (int j = 0; j < allLinesOut.length; j++) {
				allLinesOut[j] = allLine [j];
			}
			return allLinesOut;
		}
	}

	public static char[] arrayStringToArrayChar(String[] inputText) {
		char[] cArray1 = new char[1000000000];
		int indexPos = 0;
		for (int i=0;i<inputText.length;i++)
		{
		   for (int c=0;c<inputText[i].length();c++)
		    {
		          cArray1[indexPos++]=inputText[i].charAt(c);
		    }
		}
		char[] cArrayOut = new char[indexPos];
		for (int i = 0; i < cArrayOut.length; i++) {
			cArrayOut[i] = cArray1[i]; 
		}
		return cArrayOut;
	}
	
	
	static class Symbol {
		char symbolName;
		int quantity;
		
		public Symbol() {
			this.quantity = 1;
		}
		
		public void increaseSymbolQuntity () {
			this.quantity += 1;
		}

		public int getQuantity() {
			return quantity;
		}
		
		public char getSymbolName() {
			return symbolName;
		}

		public void setSymbolName(char symbolName) {
			this.symbolName = symbolName;
		}

		public boolean existSymbol(char name) {
			if (this.symbolName == name) {
				return true;
			} else {
				return false;
			}
			
			
		}

	}
}
