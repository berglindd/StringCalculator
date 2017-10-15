package is.ru.stringcalculator;

public class Calculator {
	public static int add (String text) {
		if (text.equals(""))
			return 0;
		else {
			try {
				if (text.contains(",") || text.contains("\n")) {
					String [] numbers = text.split(",|\n");
					return getSum(numbers);
				}
				if (toInt(text) < 0) {
					throw new CalculatorException("Negatives not allowed: " + text);
				}
				return toInt(text);
			}
			catch (CalculatorException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return -1;
	}

	private static int toInt (String number) {
		return Integer.parseInt(number);
	}

	private static int getSum (String [] numbers) {
		int sum = 0;

		for (String number: numbers) {
			sum += toInt(number);
		}
		return sum;
	}
}