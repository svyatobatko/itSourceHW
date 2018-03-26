package itSourceHW.hw9;

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List; 
import java.util.stream.Stream; 
import java.util.Scanner;
import java.util.ArrayList;

public class TextEditor { 
	 
	public static void main(String[] args) throws IOException { 
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите имя файла"); 
		String varText = sc.nextLine(); 
		String filePath = varText; 
		String writeText = "";
		System.out.println("Введите текст файла, для завершения необходимо ввести команду: exit"); 
		varText = "";
		do {
			varText = sc.nextLine(); 
			if (varText.equals("exit") == false) {writeText += varText + "\n";}
		} while (varText.equals("exit") == false);
		writeToFile(filePath, writeText); 

		List<String> lines = new ArrayList<>();
		lines = printFileToConsole(filePath); 
		FileLine[] fileLines = new FileLine[lines.size()];
		//System.out.println(lines); 

		String[] lineArr = new String[lines.size()];
		lineArr = lines.toArray(lineArr);

		 for (int i=0;i<lines.size();i++) 
		 { 
			 fileLines[i] = new FileLine(lineArr[i], i+1); 
			// System.out.println(fileLines[i].getNumber() + " " + fileLines[i].getLine() + " " + fileLines[i].getQuantityVowels());
		 } 
		 
		Stream<FileLine> lineStream = Stream.of(fileLines); 
		lineStream 
					.sorted( (line1, line2) -> { 
						return line2.getQuantityVowels() - line1.getQuantityVowels(); 
						})
					.limit(1)
					.forEach(s->System.out.println("Самое большое количество гласных содержится в строке:" + s.getNumber() +  
								". Их число состовляет: " + s.getQuantityVowels())); 
		 
		System.out.println("Размер файла в символах: " + sizeInSymbol (fileLines)); 
		System.out.println("Количество слов в файле: " + sizeInWordText (fileLines)); 
		sc.close(); 
	}

	private static int sizeInSymbol (FileLine[] fileLines) {
		int sizeInSymbol = 0;
			for (int i=0;i<fileLines.length;i++) 
			{ 
				sizeInSymbol += fileLines[i].getQuantitySymbols(); 
			} 

		return sizeInSymbol;
	}

	private static int sizeInWordText (FileLine[] fileLines) {
		int sizeInWord = 0;
			for (int i=0;i<fileLines.length;i++) 
			{ 
				sizeInWord += fileLines[i].getQuantityWords(); 
			} 
		return sizeInWord;
	}

	private static void writeToFile(String path, String textToWrite) throws IOException {
		Files.write(Paths.get(path), textToWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}


	public static List<String> printFileToConsole(String path) throws IOException { 
		try (Stream<String> fStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) { 
			fStream.forEach(System.out::println);
		} 
		List<String> lines = Files.readAllLines(Paths.get(path)); 
		return lines;
	} 

	static class FileLine { 
		String line; 
		boolean exist; 
		int quantityVowels; 
		int quantitySymbols; 
		int quantityWords; 
		int number; 

		public FileLine(String line, int number) { 
			this.line = line;
			this.quantityVowels = countVolwels(line); 
			this.quantitySymbols = countSymbols(line); 
			this.quantityWords = countWords(line); 
			this.number = number; 
			this.exist = true; 
		} 

		public int getQuantityVowels() { 
			return this.quantityVowels; 
		} 
		 
		public int getQuantitySymbols() { 
			return this.quantitySymbols; 
		} 
		 
		public int getQuantityWords() { 
			return this.quantityWords; 
		} 
		 
		public int getNumber() { 
			return this.number; 
		} 
		 
		public String getLine() { 
			return this.line; 
		} 

		public void setLine(String line) { 
			this.line = line; 
		} 

		public boolean existFileLine(String line) { 
			if (this.line == line) { 
				return true; 
			} else { 
				return false; 
			} 
		} 

		private int countVolwels(String line) { 
			int quntityVolwels = 0;
			for (int i=0; i < line.length();i++) 
			{ 
				if (charIsVolwels(line.charAt(i))) {
					quntityVolwels++;
				}
			} 
			return quntityVolwels;
		} 
		
		private int countSymbols(String line) { 
			int quntitySymbols = 0;
			for (int i=0; i < line.length();i++) 
			{ 
				quntitySymbols++;
			} 
			return quntitySymbols;
		} 
		
		private static int countWords(String line) {
			int sizeInWord = 0;
			String[] words = line.split("\\s");
			sizeInWord = words.length;
			return sizeInWord;
		}

		private boolean charIsVolwels(char symbol)
		{ 
			char symbolU = Character.toUpperCase(symbol);
			if (symbolU == 'A' || symbolU == 'E' || symbolU == 'I' || symbolU == 'O' || symbolU == 'U' || symbolU == 'Y' ) {
//					symbolU == "А" || symbolU == "Е" || symbolU == "Ё" ||  symbolU == "О" || symbolU == "У" || 
//					symbolU == "Э" || symbolU == "Ю" || symbolU == "Я" || symbolU == "Ы")
			return true; 
			} else {
				return false;
			}

		}

	} 
}