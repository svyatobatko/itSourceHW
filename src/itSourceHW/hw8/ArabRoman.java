package itSourceHW.hw8;

public class ArabRoman { 
	 
	public static String[] arrayArab = {"1", "4", "5", "9", "10", "40", "50", "90", "100", "400", "500", "900", "1000"};
	public static String[] arrayRoman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

	public static void main(String[] args) { 
	
 		System.out.println(1 + "===>" + arab2Roman(1) + "===>" + roman2Arab(arab2Roman(1)));
 		System.out.println(2 + "===>" + arab2Roman(2) + "===>" + roman2Arab(arab2Roman(2)));
 		System.out.println(5 + "===>" + arab2Roman(5) + "===>" + roman2Arab(arab2Roman(5)));
 		System.out.println(9 + "===>" + arab2Roman(9) + "===>" + roman2Arab(arab2Roman(9)));
 		System.out.println(19 + "===>" + arab2Roman(19) + "===>" + roman2Arab(arab2Roman(19)));
 		System.out.println(29 + "===>" + arab2Roman(29) + "===>" + roman2Arab(arab2Roman(29)));

 	} 
 	 
   	public static String arab2Roman(int number) { 
		String result = "";
		int i = arrayArab.length - 1;
 		if (number <= 0) { 
 			result = "";
 		} else { 
 			while (number > 0) { 
				if (number >= Integer.parseInt(arrayArab[i])) { 
					result += arrayRoman[i];
					number -= Integer.parseInt(arrayArab[i]);
				} else { 
					i--;	
				} 
 			} 
 		}
		return result;
 	} 

   	public static int roman2Arab(String str) { 
	
		str = str.intern() + "  ";

		int ret = 0;
		int i = arrayArab.length - 1;
		int pos = 0;
		while(i >= 0 && pos <= (str.length()) )
		{
			String compare1 = str.substring(pos,pos+arrayRoman[i].length());
			if(compare1.equals(arrayRoman[i]))
			{
				ret += Integer.parseInt(arrayArab[i]);
				pos += arrayRoman[i].length();
				if (i == 0) {
					i = arrayArab.length - 1;
				}
			}
			else
			{
				i--;
			}
		
		}
		return ret;
	}

} 