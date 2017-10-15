package is.ru.stringcalculator;

public class Calculator {
	public static int add (String text) {
		if (text.equals(""))
			return 0;
		else {
			try {
				if (text.contains(",") || text.contains("\n")) {
					String [] numbers = text.split(",|\n");
					String message = getNegatives(numbers);

					if (message != "") {
						message = message.substring(0, message.length() - 1);
						throw new CalculatorException("\nNegatives not allowed: " + message);
					}

					return getSum(numbers);
				}

				int theNumber = toInt(text);

				if (theNumber < 0) {
					throw new CalculatorException("\nNegatives not allowed: " + text);
				}
				return theNumber;
			}
			catch (CalculatorException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return -1;
	}

	private static String getNegatives (String [] numbers) {
		int match = 0;
		String message = "";

		for (String number: numbers) {
			if (toInt(number) < 0) {
				match = 1;
				message += number + ",";	
			}
		}

		return message;
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