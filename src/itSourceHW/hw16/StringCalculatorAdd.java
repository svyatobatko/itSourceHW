package itSourceHW.hw16;

import static org.junit.Assume.assumeNoException;

public class StringCalculatorAdd {
	
	private int result;
	private String ADDENDUM_SEPARATOR = "(,|\\n|;|%|\\*|#)"; //can be added any delimiter what you need

	public StringCalculatorAdd(String args) throws Exception {
		int result = 0;
		if (args.length() > 0) {
			String[] addendum = args.split(ADDENDUM_SEPARATOR);
			for (String addString : addendum) {
				try {
					if (Integer.parseInt(addString) < 0) {
						throw new Exception("negatives not allowed");
					}
					if (Integer.parseInt(addString) < 1000) {
						result += Integer.parseInt(addString);
					}
				}
				catch (NumberFormatException exceptionObject) {
					addString = "0";
				}
				catch (Exception exceptionObject) {
					throw new Exception("negatives not allowed");
				}
				
			}
		} 
		this.result = result;
	}

	public int getResult() {
		return result;
	}

}
