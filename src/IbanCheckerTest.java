import static org.junit.Assert.*;

import org.junit.Test;



public class IbanCheckerTest {

	IbanChecker ibanChecker = new IbanChecker();
	
	@Test
	public void shouldReturnValidForFirstCharacters() throws Exception {
		assertTrue(ibanChecker.isValidPreliminary("IT60Q0123412345000000753XYZ"));
	}
	
	@Test
	public void shouldReturnNonValidForFirstCharacters() throws Exception {
		assertFalse(ibanChecker.isValidPreliminary("0060Q0123412345000000753XYZ"));
	}

	@Test
	public void shouldReturnNonValidForSecondCharacters() throws Exception {
		assertFalse(ibanChecker.isValidPreliminary("ITNE60Q0123412345000000753XYZ"));
	}

	@Test
	public void shouldRefactorIbanNumber() throws Exception {
		assertEquals("Q0123412345000000753XYZIT60", ibanChecker.refactorIban("IT60Q0123412345000000753XYZ"));
	}
	
	@Test
	public void shouldReturnFirstFiveCharacters() throws Exception {
		assertEquals("Q0123", ibanChecker.getNexPackOfNumbers("Q0123412345000000753XYZIT60", 0));
	}
	
	@Test
	public void shouldCalculateModulusForIbanNumber() throws Exception {
		assertEquals(1, ibanChecker.calculateModulus("260123412345000000753333435182960"));
	}
	
	@Test
	public void shouldReplaceCharactersWithNumbers() throws Exception {
		assertEquals("260123412345000000753333435182960", ibanChecker.replaceCharacters("Q0123412345000000753XYZIT60"));
	}
}
