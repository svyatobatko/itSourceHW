package itSourceHW.hw9;

public class UpperCase {
	public static void main(String[] args) {
		
		final String inputTextLine1 = "When I was younger";
		final String inputTextLine2 = "I never needed";
		System.out.println("Дан текст:\n" + inputTextLine1 + "\n" + inputTextLine2 + "\n");
		System.out.println("Результат, все первые буквы слов - заглавные:");
		String[] separetedTextLine1=inputTextLine1.split("\\s");
		for (String words : separetedTextLine1) {
			System.out.print(makeFirstLeterUpper(words) + " ");
		}
		System.out.println();
		String[] separetedTextLine2=inputTextLine2.split("\\s");
		for (String words : separetedTextLine2) {
			System.out.print(makeFirstLeterUpper(words) + " ");
		}

	}
	
	public static String makeFirstLeterUpper(String word) {
		String upperWord; 
		if (word.length() == 1) {
			upperWord = word.toUpperCase();
		} else {
			upperWord = word.substring(0, 1).toUpperCase() + word.substring(1);
		} 
		return upperWord;
	}
}
