package zookeeper;

public class PossibleExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	void AllowedNumericValuesAre1and2() {
		System.out.print("""
				***********************************************
				ERROR: Allowed Numeric Values Are 1 and 2 Only.
				***********************************************
				""");
	}

	void HabitatNumbersAreFrom1To6() {
		System.out.print("""
				***************************************
				ERROR: Habitat Numbers are From 1 To 6.
				***************************************
				""");
	}
}
