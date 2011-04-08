
public class IbanChecker {

	public boolean isValidPreliminary(String ibanNumber) {
		if (!(isLetter(ibanNumber.charAt(0))) || (!(isLetter(ibanNumber.charAt(1))))) {
			return false;
		}
		else if (isLetter(ibanNumber.charAt(2)) || isLetter(ibanNumber.charAt(3))) {
			return false;
		}
		return true;
	}
	
	private boolean isLetter(char myChar) {
		if (myChar<'A' || myChar>'Z') {
			return false;
		}
		return true;
	}

	public String refactorIban(String ibanNumber) {
		String refactoredIban = ibanNumber.substring(4, ibanNumber.length()) + ibanNumber.substring(0, 4);
		return refactoredIban;
	}

	public String getNexPackOfNumbers(String ibanNumber, int packCounter) {
		int upperLimit = (packCounter+1)*5;
		if (upperLimit>ibanNumber.length()) {
			upperLimit = ibanNumber.length();
		}
		return ibanNumber.substring(packCounter*5, upperLimit);
	}

	public int calculateModulus(String ibanNumber) {
		int modulus = 0;
		for (int i=0;i<7;i++) {
			String nextPackOfNumbers = modulus + getNexPackOfNumbers(ibanNumber, i);
			int nextPack = Integer.parseInt(nextPackOfNumbers);
			modulus = nextPack % 97;
		}
		return modulus;
	}

	public String replaceCharacters(String ibanNumber) {
		String result ="";
		for (int i=0;i<ibanNumber.length();i++) {
			if (isLetter(ibanNumber.charAt(i))) {
				result += String.valueOf(ibanNumber.charAt(i)-'A'+10);
			} else {
				result += ibanNumber.charAt(i);
			}
		}
		return result;
	}

}
